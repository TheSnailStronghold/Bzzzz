package org.bzzzzShop.models;

import java.util.Objects;


/*Покупатель*/
public class Customer {
    private String username;
    private String phoneNumber;
    private String email;
    private Account customerAcc;

    public Customer(String login, String password, String username, String phoneNumber, String email) {
        customerAcc = new Account(login, password);
        this.username=username;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;
        Customer customer = (Customer) o;
        return customerAcc.equals(customer.customerAcc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerAcc);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(customerAcc.toString());         //вывод информации об учетной записи
        str.append(String.format("Имя пользователя: %s\n" +
                        "Номер телфона: %s\n" +
                        "E-mail: %s\n",
                 username, phoneNumber, email));
        str.append("--------------------------------------------\n");
        str.append("История заказов(заказ, дата):\n");
        /*SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY");
        if (orders != null) {
            for (Order o : orders)
                str.append(String.format("%05d \t %s\n",
                        o.getOrder_number(), dateFormat.format(o.getOrder_date())));
        }*/
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

    public void setUsername(String username){
        this.username=username;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
