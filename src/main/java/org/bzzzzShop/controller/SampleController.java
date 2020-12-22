package org.bzzzzShop.controller;

import org.bzzzzShop.ServiceWorker;
import org.bzzzzShop.dto.BasketDTO;
import org.bzzzzShop.models.Basket;
import org.bzzzzShop.models.Customer;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class SampleController {

    private ServiceWorker serviceWorker = new ServiceWorker();

    //Мы используем методы помеченные GetMapping когда хотим получить информацию
    @GetMapping("/greeting")
    public String greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return "Hello, " + name + "!";
    }

    @GetMapping("/main")
    public String mainPage() {
        StringBuilder builder = new StringBuilder();
        builder.append("Welcome, customer! You are now in 'Bzzzz' — the best beekeeping shop!");
        builder.append("\n");
        /*  В браузере перенос строки он почему-то не отображает, но в Postman видит.
            Сдавать нам именно в Postman, так что не страшно, думаю.
         */
        builder.append("You are now at beta page, shop is not finished yet. Return soon!");
        return builder.toString();
    }

    @PostMapping("/findBuyer")
    public Customer getBuyerById(@RequestParam(value = "id") UUID id) {
        //TODO здесь мы должныы опиать логику поиска покупателя по его уникального идентифкатору в БД
        return new Customer();
    }

    //Мы используем методы помеченные PostMapping когда хотим добавить или сохранить информацию
    @PostMapping("/addToCart")
    public Basket addToBasket(@RequestBody BasketDTO basketDTO) {
        //TODO здесь будет метод, который отдает корзину после добавления в нее товара
        return new Basket();
    }
}