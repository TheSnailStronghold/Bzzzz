package org.bzzzzShop.service;

import org.bzzzzShop.models.Basket;
import org.bzzzzShop.models.Goods;
import org.bzzzzShop.models.customer.Customer;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

/* Класс синглтон
* для работы с корзиной и её владельцем */
public final class BasketService {
    private Map<Customer, Basket> baskets;
    private static BasketService instance;

    /* получение экземпляра класса */
    public static BasketService getInstance() {
        if (instance == null)
            instance = new BasketService();
        return instance;
    }

    public Basket getBasketFromCustomer(Customer customer) {
        if (baskets.containsKey(customer))
            return baskets.get(customer);
        else {
            Basket basket = new Basket();
            baskets.put(customer, basket);
            return basket;
        }
    }

    public void addGoodsToBasket(Customer customer, Goods goods) {
        addGoodsToBasket(customer, goods, 1);
    }

    public void addGoodsToBasket(Customer customer, Goods goods, int amount) {
        if (!baskets.containsKey(customer))
            throw new NoSuchElementException("Создание корзины для несуществующего покупателя");

        baskets.get(customer).addGood(goods, amount);
        /*Basket basket = baskets.get(customer);
        basket.addGood(goods, amount);
        baskets.put(customer, basket);*/
    }
    public void dropGoodsFromBasket(Customer customer, Goods goods) {
        if (!baskets.containsKey(customer))
            throw new NoSuchElementException("Создание корзины для несуществующего покупателя");
        baskets.get(customer).dropGoods(goods);
    }
    public void setAmountOfGoods(Customer customer, Goods goods, int amount){
        if (!baskets.containsKey(customer))
            throw new NoSuchElementException("Создание корзины для несуществующего покупателя");
        baskets.get(customer).setAmount(goods, amount);
    }
    /*public void dropGoodsFromBasket(Customer customer, Goods goods, int amount) {
        if (!baskets.containsKey(customer))
            throw new NoSuchElementException("Создание корзины для несуществующего покупателя");
        baskets.get(customer).deleteGood(goods, amount);
    }*/

    private BasketService() {
        baskets = new HashMap<>();
    }
}
