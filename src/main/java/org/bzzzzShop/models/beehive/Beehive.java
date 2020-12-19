package org.bzzzzShop.models.beehive;

import org.bzzzzShop.models.Goods;
import org.bzzzzShop.models.beehive.components.ComponentsOfTheBeehive;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/* Класс описывающий Улий*/
public class Beehive extends Goods {
    /* Что входит в улий и в каком кол.-ве */
    private List<Map.Entry<ComponentsOfTheBeehive, Integer>> componentsOfTheBeehives;

    /* Конструкторы */
    public Beehive(String article, String name, BigDecimal price,
                   Map<String, String> description, int amount,
                   List<Map.Entry<ComponentsOfTheBeehive, Integer>> componentsOfTheBeehives) {
        super(article, name, price, description, amount);
        this.componentsOfTheBeehives = componentsOfTheBeehives;
    }

    public Beehive(String article, String name, BigDecimal price,
                   String[][] description, int amount,
                   List<Map.Entry<ComponentsOfTheBeehive, Integer>> componentsOfTheBeehives) {
        super(article, name, price, description, amount);
        this.componentsOfTheBeehives = componentsOfTheBeehives;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(super.toString());
        builder.append("Улей состоит из:\n");
        componentsOfTheBeehives
                .forEach(e -> builder.append(
                        String.format("- %s, арт.%s - %d шт.\n",
                                e.getKey().getName(), e.getKey().getArticle(),
                                e.getValue())));
        return builder.toString();
    }
}
