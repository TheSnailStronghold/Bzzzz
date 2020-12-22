package org.bzzzzShop.controller;

import org.bzzzzShop.ServiceWorker;
import org.bzzzzShop.dto.BasketDTO;
import org.bzzzzShop.models.Basket;
import org.bzzzzShop.models.Customer;
import org.bzzzzShop.models.Goods;
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
        builder.append("Добро пожаловать в 'Bzzzz' — лучший пчеловодческий магазин в нашей галактике!");
        builder.append("\n\nНАШИ ТОВАРЫ:\n\n");
        /*  В браузере перенос строки он почему-то не отображает, но в Postman видит.
            Сдавать нам именно в Postman, так что не страшно, думаю.
         */
        for (Goods item: serviceWorker.products){
            builder.append(item.toString() +
                                "\n\n-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+" +
                                    "-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+\n\n");
        }
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