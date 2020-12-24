package org.bzzzzShop.controller;

import org.bzzzzShop.models.customer.Customer;
import org.bzzzzShop.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/{login}")
public class UserController {
    private UserService userService = UserService.getInstance();

    @GetMapping
    public String getInfo(@PathVariable String login) {
        return userService.findByLogin(login).toString();
    }
}
