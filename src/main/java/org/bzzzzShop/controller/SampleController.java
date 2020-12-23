package org.bzzzzShop.controller;

import org.bzzzzShop.models.Goods;
import org.bzzzzShop.models.customer.Account;
import org.bzzzzShop.models.customer.Customer;
import org.bzzzzShop.service.BasketService;
import org.bzzzzShop.service.ServiceWorker;
import org.bzzzzShop.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class SampleController {

    /* Сервис для работы с товарами */
    private ServiceWorker serviceWorker = ServiceWorker.getInstance();
    /* Сервис для работы с пользователями */
    private UserService userService = UserService.getInstance();

    private BasketService basketService = BasketService.getInstance();

    @GetMapping("/main")
    public String mainPage() {
        StringBuilder builder = new StringBuilder();
        if (!userService.getCustomerSet().isEmpty())
            builder.append("Здравствуйте, " + userService.getActiveCustomer().getUsername() + "!\n");
        builder.append("Добро пожаловать в 'Bzzzz' — лучший пчеловодческий магазин в нашей галактике!");
        builder.append("\n\nНАШИ ТОВАРЫ:\n\n");
        for (Goods item: serviceWorker.getAllProducts()){
            builder.append(item.toString() +
                    "\n\n-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+" +
                    "-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+\n\n");
        }
        return builder.toString();
    }
    /*  Про покупателя */
    @PostMapping("/addBuyer")
    public ResponseEntity<String> addBuyer(@RequestBody Customer customer) {
        if (userService.addCustomer(customer)) {
            userService.setActiveCustomer(customer);
            basketService.getBasketFromCustomer(customer);
            return new ResponseEntity<>(String.format("Пользователь '%s' успешно зарегистрирован .\n", customer.getUsername()), HttpStatus.CREATED);
        }
        else
            return new ResponseEntity<>(String.format("Пользователь с именем '%s' уже существует.\n", customer.getUsername()) ,HttpStatus.UNAUTHORIZED);
    }

    @PostMapping("/changeUser")
    public String changeUser(@RequestBody Account account) {
        if (!account.equals(userService.getActiveCustomer())) {
            Customer customer = userService.findByLogin(account.getLogin());
            if (customer != null) {
                userService.setActiveCustomer(customer);
                return "Вы переключились на пользователя '" + customer.getUsername() + "'\n";
            }
            else
                return String.format("Пользователя с логином '%s' не существует",
                        account.getLogin());
        }
        else
            return "Этот пользователь уже выбран.";
    }

    @GetMapping("/findBuyer/{login}")
    public ResponseEntity<String> findBuyer(@PathVariable String login) {
        Customer customer = userService.findByLogin(login);
        if (customer != null)
            return new ResponseEntity<>(customer.toString(), HttpStatus.OK);
        else
            return new ResponseEntity<>("Not find.",HttpStatus.NOT_FOUND);
    }

    /* Про товары */

    @GetMapping("/findGoodsByArticle/{article}")
    public ResponseEntity<String> findGoodsByArticle(@PathVariable String article) {

        Goods goods = serviceWorker.findGoodsByArticle(article);
        if (goods != null) {
            StringBuilder builder = new StringBuilder();
            builder.append("Товары по артикулу " + article + ":\n\n\n");
            builder.append(goods.toString());
            return new ResponseEntity<>(builder.toString(), HttpStatus.OK);
        }
        else
            return new ResponseEntity<>("К сожалению, товары по артикулу " + article + " не найдены.", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/findGoodsByName/{name}")
    public ResponseEntity<String> findGoodsByName(@PathVariable String name) {

        List<Goods> goods = serviceWorker.getGoodsByName(name.toUpperCase());
        if (goods != null) {
            StringBuilder builder = new StringBuilder();
            builder.append("Товары по запросу '" + name + "':\n\n\n");
            for (Goods item: goods){
                builder.append(item.toString() +
                        "\n\n-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+" +
                        "-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+\n\n");
            }
            return new ResponseEntity<>(builder.toString(), HttpStatus.OK);
        }
        else
            return new ResponseEntity<>("К сожалению, товары по запросу '" + name + "' не найдены.", HttpStatus.NOT_FOUND);
    }
    /*Работа с корзиной*/
    /*@GetMapping("/basket/{login}")
    public String showBasket(@PathVariable String login) {
       return basketService.getBasketFromCustomer(
                userService.findByLogin(login)
        ).toString();
    }

    @PostMapping("/basket/{login}/add/{article}/{amount}")
    public String addGoodsToBasket(@PathVariable String login,
                             @PathVariable String article,
                             @PathVariable Integer amount)
    {
        basketService.addGoodsToBasket(
                userService.findByLogin(login),
                serviceWorker.findGoodsByArticle(article),
                amount
        );
        return "Товар добавлен в корзину";
    }*/
}