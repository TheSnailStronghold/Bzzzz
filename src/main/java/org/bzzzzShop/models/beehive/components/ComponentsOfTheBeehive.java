package org.bzzzzShop.models.beehive.components;

import org.bzzzzShop.models.Goods;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Objects;

/*Составляющие улья*/
public abstract class ComponentsOfTheBeehive extends Goods {
    private Integer length; // длина детали
    private Integer width; // ширина детали
    private Integer height; // высота детали
    private Unit unitName; // ед. измерения

    private int weight; // вес в граммах!

    /* Конструкторы */
    public ComponentsOfTheBeehive(String article, String name, BigDecimal price, Map<String, String> description, int amount) {
        super(article, name, price, description, amount);
    }

    public ComponentsOfTheBeehive(String article, String name, BigDecimal price, String[][] description, int amount) {
        super(article, name, price, description, amount);
    }

    public ComponentsOfTheBeehive(String article, String name, BigDecimal price,
                                  Map<String, String> description, int amount,
                                  Integer length, Integer width,
                                  Integer height, Unit unitName,
                                  int weight) {
        super(article, name, price, description, amount);
        this.length = length;
        this.width = width;
        this.height = height;
        this.unitName = unitName;
        this.weight = weight;
    }

    public ComponentsOfTheBeehive(String article, String name, BigDecimal price, String description,
                                  int amount, Integer length, Integer width,
                                  Integer height, Unit unitName, int weight) {
        super(article, name, price, description, amount);
        this.length = length;
        this.width = width;
        this.height = height;
        this.unitName = unitName;
        this.weight = weight;
    }

    public ComponentsOfTheBeehive(String article, String name, BigDecimal price, String[][] description,
                                  int amount, Integer length, Integer width,
                                  Integer height, Unit unitName, int weight) {
        super(article, name, price, description, amount);
        this.length = length;
        this.width = width;
        this.height = height;
        this.unitName = unitName;
        this.weight = weight;
    }

    /*Представление класса при выводе*/
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        if (length != 0)
            builder.append(String.format("Длина: %d %s\n", length, unitName.getName()));
        if (width != 0)
            builder.append(String.format("Ширина: %d %s\n", width, unitName.getName()));
        if (height != 0)
            builder.append(String.format("Высота: %d %s\n", height, unitName.getName()));
        builder.append(String.format("Вес: %d г\n", weight));

        StringBuilder goodsStr = new StringBuilder(super.toString());
        goodsStr.insert(goodsStr.indexOf("Цена"), builder);

        return goodsStr.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ComponentsOfTheBeehive)) return false;
        ComponentsOfTheBeehive that = (ComponentsOfTheBeehive) o;
        return weight == that.weight &&
                length.equals(that.length) &&
                width.equals(that.width) &&
                height.equals(that.height) &&
                unitName == that.unitName;
    }

    @Override
    public int hashCode() {
        return Objects.hash(length, width, height, unitName, weight);
    }
}
