package org.bzzzzShop.controller;

import org.bzzzzShop.service.ServiceWorker;
import org.bzzzzShop.service.UserService;
import org.bzzzzShop.dto.BasketDTO;
import org.bzzzzShop.models.Basket;
import org.bzzzzShop.models.customer.Customer;
import org.bzzzzShop.models.Goods;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class SampleController {

    /* Сервис для работы с товарами */
    private ServiceWorker serviceWorker = new ServiceWorker();
    /* Сервис для работы с пользователями */
    private UserService userService = new UserService();

    @PostMapping("/addToCart")
    public Basket addToBasket(@RequestBody BasketDTO basketDTO) {

        return null;
    }

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
            return new ResponseEntity<>(String.format("Пользователь '%s' успешно разеригстрирован.\n", customer.getUsername()), HttpStatus.CREATED);
        }
        else
            return new ResponseEntity<>(String.format("Пользователь с именем '%s' уже существует.\n", customer.getUsername()) ,HttpStatus.UNAUTHORIZED);
    }

    @PostMapping("/changeUser")
    public String changeUser(@RequestBody Customer customer) {
        /*
            Блин, а ещё ведь надо проверять, существует ли вообще такой пользователь.
        */
        /* Проверить equals*/
//        if (customer.equals(userService.getActiveCustomer())) {
//            userService.setActiveCustomer(customer);
            return "Вы переключились на пользователя " + customer.getUsername() + "\n";
//        }
//        else return "Этот пользователь уже выбран.";
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
    public ResponseEntity<String> getGoodsByArticle(@PathVariable String article) {

        Goods goods = serviceWorker.getGoodsByArticle(article);
        if (goods != null)
            return new ResponseEntity<>(goods.toString(), HttpStatus.OK);
        else
            return new ResponseEntity<>("Not find.", HttpStatus.NOT_FOUND);
    }
}