package org.bzzzzShop.models;

import java.math.BigDecimal;
import java.util.Scanner;

/*Покупатель
* TODO: добавить методы,
*  конструктор,
*  Корзину,
*  и ещё что-нибудь*/
public class Customer {
    private String username;
    private String phoneNumber;
    private String email;
    private String password;

    public Customer(String username, String phoneNumber, String email, String password){
        this.username = username;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
    }

    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append(String.format("Имя покупателя: %s\n" +
                        "Номер телфона: %s\n" +
                        "E-mail: %s\n",
                username, phoneNumber, email));
        str.append("--------------------------------------------\n");
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
    public String getPassword(){
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
    public void setPassword(String password){
        this.password = password;
    }
}
