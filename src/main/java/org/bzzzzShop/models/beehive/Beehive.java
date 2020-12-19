package org.bzzzzShop.models.beehive;

import org.bzzzzShop.models.Goods;
import org.bzzzzShop.models.beehive.components.BottomOfTheBeehive;
import org.bzzzzShop.models.beehive.components.ComponentsOfTheBeehive;
import org.bzzzzShop.models.beehive.components.RoofOfTheBeehive;

import java.math.BigDecimal;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Beehive extends Goods {
    private List<Map.Entry<ComponentsOfTheBeehive, Integer>> componentsOfTheBeehives;


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
