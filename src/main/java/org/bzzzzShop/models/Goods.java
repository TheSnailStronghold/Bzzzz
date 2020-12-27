package org.bzzzzShop.models;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/* Класс описывающий Товары */
public abstract class Goods {
    private String article; // Артикль может начинаться с нуля
    private String name;
    private Map<String, String> description; // информация о товаре

    /* для работы с денежными суммами использовать double
    является плохим тоном. Используют BigDecimal */
    private BigDecimal price;

    private int amount; // кол.-во на складе товара

    public Goods(String article, String name, BigDecimal price, Map<String, String> description, int amount) {
        this.article = article;
        this.name = name;
        this.price = price;
        this.description = description;
        this.amount = amount;
    }
    public Goods(String article, String name, BigDecimal price, String description, int amount) {
        this.article = article;
        this.name = name;
        this.price = price;
        this.description = new HashMap<>();

        this.description.put("Описание", !description.isEmpty()
                ?
                description : "Пусто");
        this.amount = amount;
    }
    public Goods(String article, String name, BigDecimal price, String[][] description, int amount) {
        this.article = article;
        this.name = name;
        this.price = price;
        Stream<String[]> s = Stream.of(description);
        this.description = s.collect(Collectors
                .toMap(p-> p[0], p-> p[1]));
        this.amount = amount;
    }
    public String mainInfo(){
        return String.format("%s(арт.%s)", name, article);
              /* Стол(арт.545) - 5шт*/
    }
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(String.format("Продукт № %s\n" +
                        "Название: %s\n" +
                        "Цена: %s\n" +
                        "В наличии: %d шт\n",
                article, name, price.toString(), amount));

        description.forEach((key, value) ->
                str.append(String.format("%s: %s\n", key, value))
        );
        return str.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Goods)) return false;
        Goods goods = (Goods) o;
        return article.equals(goods.article);
    }

    @Override
    public int hashCode() {
        return Objects.hash(article);
    }

    /*GET + SET*/
    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Map<String, String> getDescription() {
        return description;
    }

    public void setDescription(Map<String, String> description) {
        this.description = description;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

}
