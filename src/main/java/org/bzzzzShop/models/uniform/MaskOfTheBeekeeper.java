package org.bzzzzShop.models.uniform;

import java.math.BigDecimal;
import java.util.Map;

/* Класс описывающий Маски пчеловода*/
public class MaskOfTheBeekeeper extends Uniform{
    /* Конструкторы */
    public MaskOfTheBeekeeper(String article, String name, BigDecimal price,
                              Map<String, String> description, int amount,
                              String size, String brand, String material) {
        super(article, name, price, description, amount, size, brand, material);
    }

    public MaskOfTheBeekeeper(String article, String name, BigDecimal price,
                              String[][] description, int amount, String size,
                              String brand, String material) {
        super(article, name, price, description, amount, size, brand, material);
    }

}
