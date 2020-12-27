package org.bzzzzShop.models;

import org.bzzzzShop.models.customer.Customer;

import java.util.HashMap;
import java.util.Map;

public class Basket {

    private Map<Goods, Integer> content = new HashMap<>();

    private Customer customer;

    public void addGood(Goods product) {
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
            Integer in_stock = content.keySet().stream()
                    .filter(product::equals)
                    .findFirst()
                    .get()
                    .getAmount();

            if (content.get(product) + amount > in_stock)
                content.put(product, in_stock);
            else
                content.put(product, content.get(product) + amount);
        }
    }

    public void setAmount(Goods goods, Integer amount) {
        if (!content.containsKey(goods))
            throw new IllegalArgumentException("Товара нет в корзине");
        if (amount <= 0)
            throw new IllegalArgumentException();

        Integer in_stock = content.keySet().stream()
                .filter(goods::equals)
                .findFirst()
                .get()
                .getAmount();
        amount = (amount > in_stock) ? in_stock : amount;
        content.put(goods, amount);
    }
    public void dropGoods(Goods goods) {
        content.remove(goods);
    }

    /*public void deleteGood(Goods product) {
        deleteGood(product, 1);
    }

    public void deleteGood(Goods product, Integer amount) {
        if (content.containsKey(product)) {
            if (amount < 0 || amount > content.get(product))
                throw new IllegalArgumentException("Некорректный аргумент - указанное количество отрицательно или больше содержимого");
            if (content.put(product, content.get(product) - amount) == amount) {
                content.remove(product);
            }
        } else {
            throw new IllegalArgumentException("Указанного товара нет в корзине");
        }
    }*/

    public void clearBasket() {
        content.clear();
    }

    public Integer contentNumber() {
        int count = 0;
        for (Integer x : content.values())
            count += x;
        return count;
    }

    public Map<Goods, Integer> getContent() {
        return content;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();

        if (content.isEmpty()) return "Корзина пуста.";

        str.append("СОДЕРЖИМОЕ КОРЗИНЫ\n");
        str.append("*****************************************\n");
        content.forEach((k, v) ->
                str.append(
                        String.format("+\t%s - %dшт\n", k.mainInfo(), v)
                )
        );
        /*for (Map.Entry<Goods, Integer> item : content.entrySet()) {
            str.append(String.format("Наименование товара: %s\n" +
                            "Количество товаров в корзине: %s\n",
                    item.getKey(), item.getValue()));
            str.append("--------------------------------------------\n");
        }*/
        str.append("*****************************************\n");
        str.append("Суммарное число товаров в корзине: " + contentNumber() + "\n");
        /*str.append("============================================\n");*/
        return str.toString();

    }
}
