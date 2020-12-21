package org.bzzzzShop.models;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

/*Покупатель*/
public class Customer {
    private String username;
    private String phoneNumber;
    private String email;
    private String password;
    private List<Order> orders;

    public Customer(String username, String phoneNumber, String email,
                    String password, List<Order> orders) {
        this.username = username;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
        this.orders = orders;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(String.format("Имя покупателя: %s\n" +
                        "Номер телфона: %s\n" +
                        "E-mail: %s\n",
                username, phoneNumber, email));
        str.append("--------------------------------------------\n");
        str.append("История заказов(заказ, дата):\n");
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY");
        if (orders != null) {
            for (Order o : orders)
                str.append(String.format("%05d \t %s\n",
                        o.getOrder_number(), dateFormat.format(o.getOrder_date())));
        }
        return str.toString();
    }


    public String getUsername() {
        return username;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
