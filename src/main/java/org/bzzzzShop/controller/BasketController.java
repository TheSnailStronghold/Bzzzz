package org.bzzzzShop.controller;

import org.bzzzzShop.service.BasketService;
import org.bzzzzShop.service.ServiceWorker;
import org.bzzzzShop.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/basket/{login}")
public class BasketController {
    /* Сервис для работы с товарами */
    private ServiceWorker serviceWorker = ServiceWorker.getInstance();
    /* Сервис для работы с пользователями */
    private UserService userService = UserService.getInstance();

    private BasketService basketService = BasketService.getInstance();

    @GetMapping
    public String showBasket(@PathVariable String login) {
        return basketService.getBasketFromCustomer(
                userService.findByLogin(login)
        ).toString();
    }

    @PostMapping("/{article}")
    public String addGoodsToBasket(@PathVariable String login,
                                   @PathVariable String article)
    {
        basketService.addGoodsToBasket(
                userService.findByLogin(login),
                serviceWorker.findGoodsByArticle(article)
        );
        return "Товар добавлен в корзину";
    }
    @DeleteMapping("/{article}")
    public String dropGoodsToBasket(@PathVariable String login,
                                    @PathVariable String article)
    {
        basketService.dropGoodsFromBasket(
                userService.findByLogin(login),
                serviceWorker.findGoodsByArticle(article));
        return "Товар убран из корзины.";
    }
    @PutMapping("/{article}/{amount}")
    public String setAmountOfGoods(@PathVariable String login,
                                    @PathVariable String article,
                                   @PathVariable Integer amount)
    {
        basketService.setAmountOfGoods(
                userService.findByLogin(login),
                serviceWorker.findGoodsByArticle(article),
                amount);
        return "Количество товара обновлено.";
    }
}
