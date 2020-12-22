package org.bzzzzShop.controller;

import org.bzzzzShop.ServiceWorker;
import org.bzzzzShop.UserService;
import org.bzzzzShop.dto.BasketDTO;
import org.bzzzzShop.models.Basket;
import org.bzzzzShop.models.Customer;
import org.bzzzzShop.models.Goods;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;
import java.util.UUID;

@RestController
public class SampleController {

    /* Сервис для работы с товарами */
    private ServiceWorker serviceWorker = new ServiceWorker();
    /* Сервис для работы с пользователями */
    private UserService userService = new UserService();

    //Мы используем методы помеченные PostMapping когда хотим добавить или сохранить информацию
    @PostMapping("/addToCart")
    public Basket addToBasket(@RequestBody BasketDTO basketDTO) {
        //TODO здесь будет метод, который отдает корзину после добавления в нее товара
        return new Basket();
    }
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
        builder.append("You are now at beta page, shop is not finished yet. Return soon!");
        return builder.toString();
    }
    /*  Про покупателя */
    @PostMapping("/addBuyer")
    public ResponseEntity<String> addBuyer(@RequestBody Customer customer) {
        if (userService.addCustomer(customer))
            return new ResponseEntity<>(String.format("'%s' was registered", customer.getUsername()),HttpStatus.CREATED);
        else
            return new ResponseEntity<>(String.format("'%s' already exists", customer.getUsername()) ,HttpStatus.UNAUTHORIZED);
    }

    @GetMapping("/findBuyer/{username}")
    public ResponseEntity<String> findBuyer(@PathVariable String username) {
        Customer customer = userService.findCustomerByUsername(username);
        if (customer != null)
            return new ResponseEntity<>(customer.toString(), HttpStatus.OK);
        else
            return new ResponseEntity<>("Not find.",HttpStatus.NOT_FOUND);
    }
    /*  Про товары */
    @GetMapping("/getGoodsByArticle/{article}")
    public ResponseEntity<String> getGoodsByArticle(@PathVariable String article){

        Goods goods = serviceWorker.getGoodsByArticle(article);
        if (goods != null)
            return new ResponseEntity<>(goods.toString(), HttpStatus.OK);
        else
            return new ResponseEntity<>("Not find.",HttpStatus.NOT_FOUND);
    }
}