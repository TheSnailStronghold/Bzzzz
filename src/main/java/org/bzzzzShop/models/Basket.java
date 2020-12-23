package org.bzzzzShop.models;

import org.bzzzzShop.models.customer.Customer;

import java.util.HashMap;
import java.util.Map;

public class Basket {

    private Map<Goods, Integer> content = new HashMap<>();
    private int contentNumber = 0;
    private Customer customer;

    public void addGood(Goods product){
       addGood(product, 1);
    }

    public void addGood(Goods product, Integer amount) {
        if (amount <= 0)
            throw new IllegalArgumentException("Число товара не может быть отрицательным!");
        if (amount > product.getAmount())
            amount = product.getAmount();
        if (!content.containsKey(product)) {
            content.put(product, amount);
        } else {
            content.put(product, content.get(product) + amount);
        }
        contentNumber += amount;
    }

    public void deleteGood(Goods product) {
        if (content.containsKey(product)) {
            if (content.put(product, content.get(product) - 1) == 1) {
                content.remove(product);
            }
            contentNumber--;
        }
    }

    public void clearBasket() {
        content.clear();
    }

    public Map<Goods, Integer> getContent() {
        return content;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();

        if (content.isEmpty()) return "Корзина пуста.";

        str.append("СОДЕРЖИМОЕ КОРЗИНЫ:\n");
        for (Map.Entry<Goods, Integer> item : content.entrySet()) {
            str.append(String.format("Наименование товара: %s\n" +
                            "Количество товаров в корзине: %s\n",
                    item.getKey(), item.getValue()));
            str.append("--------------------------------------------\n");
        }
        str.append("Суммарное число товаров в корзине: " + this.contentNumber + "\n");
        str.append("============================================\n");
        return str.toString();

    }
}
