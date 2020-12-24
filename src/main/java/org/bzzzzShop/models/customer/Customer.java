package org.bzzzzShop.models.customer;

import org.bzzzzShop.models.order.Address;
import org.bzzzzShop.models.order.Order;

import java.text.SimpleDateFormat;
import java.util.*;


/*Покупатель*/
public class Customer {
    private String username;
    private Account account;
    private String phoneNumber;
    private String email;
    private Address address;
    private List<Order> orders;

    public void setAccount(Account account) {
        this.account = account;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public Customer(){
        orders = new LinkedList<>();
    }
    public Customer(String login, String password, String username, String phoneNumber, String email,
                    String country, String city, String street, String house) {
        account = new Account(login, password);
        this.username = username;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = new Address(country, city, street, house);
    }

    public Customer(String login, String password, String username, String phoneNumber, String email,
                    String country, String city, String street, String house, String flat) {
        account = new Account(login, password);
        this.username = username;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = new Address(country, city, street, house, flat);
    }
    public List<Order> getOrders() {
        return orders;
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public Account getAccount() {
        return account;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;
        Customer customer = (Customer) o;
        return account.equals(customer.account);
    }

    @Override
    public int hashCode() {
        return Objects.hash(account);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(account.toString());         //вывод информации об учетной записи
        str.append(String.format("Имя пользователя: %s\n" +
                        "Номер телфона: %s\n" +
                        "E-mail: %s\n",
                username, phoneNumber, email));
        str.append("--------------------------------------------\n");
        str.append("История заказов(UUID заказа, дата):\n");

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if (orders != null) {
            for (Order o : orders)
                str.append(String.format("%s \t %s\n",
                        o.getOrder_number(), dateFormat.format(o.getOrder_date())));
        }
        return str.toString();
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Order getOrderByUUID(UUID uuid) {
        Order order = null;
        try{
            order = orders.stream()
                    .filter(o -> o.getOrder_number().equals(uuid))
                    .findFirst()
                    .get();
        } catch (NoSuchElementException ignored){}
        return order;
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

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
