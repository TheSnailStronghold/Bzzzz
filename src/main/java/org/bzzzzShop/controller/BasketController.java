package org.bzzzzShop.controller;

import org.bzzzzShop.models.Basket;
import org.bzzzzShop.models.customer.Customer;
import org.bzzzzShop.models.order.Order;
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

    @PostMapping("/pay")
    public String payOrder(@PathVariable String login) {
        Customer c = userService.findByLogin(login);
        Basket basket = basketService.getBasketFromCustomer(c);
        Order order = null;
        if (!basket.getContent().isEmpty()) {
            order = new Order(basket.getContent());
            c.addOrder(order);
            return "Заказ успешно добавлен.";
        } else
            return "Нечего оплачивать.";
    }

    @PostMapping("/{article}")
    public String addGoodsToBasket(@PathVariable String login,
                                   @PathVariable String article) {

        basketService.addGoodsToBasket(
                userService.findByLogin(login),
                serviceWorker.findGoodsByArticle(article)
        );
        return "Товар добавлен в корзину";
    }

    @DeleteMapping("/{article}")
    public String dropGoodsToBasket(@PathVariable String login,
                                    @PathVariable String article) {
        try {
            basketService.dropGoodsFromBasket(
                    userService.findByLogin(login),
                    serviceWorker.findGoodsByArticle(article));
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }
        return "Товар убран из корзины.";
    }

    @PutMapping("/{article}/{amount}")
    public String setAmountOfGoods(@PathVariable String login,
                                   @PathVariable String article,
                                   @PathVariable Integer amount) {
        try {
            basketService.setAmountOfGoods(
                    userService.findByLogin(login),
                    serviceWorker.findGoodsByArticle(article),
                    amount);
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }
        return "Количество товара обновлено.";
    }
}
