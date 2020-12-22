package org.bzzzzShop.models.beehive.components;

import java.math.BigDecimal;
import java.util.Map;

/* Класс описывающий Магазин улья*/
public class StorageOfTheBeehive extends ComponentsOfTheBeehive {

    /* Конструкторы */
    public StorageOfTheBeehive(String article, String name, BigDecimal price, Map<String, String> description, int amount) {
        super(article, name, price, description, amount);
    }

    public StorageOfTheBeehive(String article, String name, BigDecimal price, String[][] description, int amount) {
        super(article, name, price, description, amount);
    }

    public StorageOfTheBeehive(String article, String name, BigDecimal price,
                               Map<String, String> description, int amount, Integer length,
                               Integer width, Integer height, Unit unitName, int weight) {
        super(article, name, price, description, amount, length, width, height, unitName, weight);
    }

    public StorageOfTheBeehive(String article, String name, BigDecimal price, String description,
                               int amount, Integer length, Integer width, Integer height,
                               Unit unitName, int weight) {
        super(article, name, price, description, amount, length, width, height, unitName, weight);
    }

    public StorageOfTheBeehive(String article, String name, BigDecimal price,
                               String[][] description, int amount, Integer length,
                               Integer width, Integer height, Unit unitName, int weight) {
        super(article, name, price, description, amount, length, width, height, unitName, weight);
    }
}
