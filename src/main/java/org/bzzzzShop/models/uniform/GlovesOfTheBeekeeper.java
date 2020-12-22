package org.bzzzzShop.models.uniform;

import java.math.BigDecimal;
import java.util.Map;

/* Класс описывающий Перчатки */
public class GlovesOfTheBeekeeper extends Uniform {
    /* Конструкторы */
    public GlovesOfTheBeekeeper(String article, String name, BigDecimal price,
                                Map<String, String> description, int amount,
                                String size, String brand, String material) {
        super(article, name, price, description, amount, size, brand, material);
    }

    public GlovesOfTheBeekeeper(String article, String name, BigDecimal price, String description,
                                int amount, String size, String brand, String material) {
        super(article, name, price, description, amount, size, brand, material);
    }

    public GlovesOfTheBeekeeper(String article, String name, BigDecimal price,
                                String[][] description, int amount, String size,
                                String brand, String material) {
        super(article, name, price, description, amount, size, brand, material);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
