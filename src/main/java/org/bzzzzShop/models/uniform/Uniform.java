package org.bzzzzShop.models.uniform;

import org.bzzzzShop.models.Goods;

import java.math.BigDecimal;
import java.util.Map;

public class Uniform extends Goods {
    private String size;
    private String brand;
    private String material;
    public Uniform(String article, String name, BigDecimal price,
                   Map<String, String> description, int amount,
                   String size, String brand, String material) {
        super(article, name, price, description, amount);
        this.size = size;
        this.brand = brand;
        this.material = material;
    }

    public Uniform(String article, String name, BigDecimal price,
                   String[][] description, int amount, String size, String brand, String material) {
        super(article, name, price, description, amount);
        this.size = size;
        this.brand = brand;
        this.material = material;
    }

    @Override
    public String toString() {
        return super.toString().replace("}",
                "\nsize='" + size + '\'' +
                ", brand='" + brand + '\'' +
                ", material='" + material + '\'' +
                '}');
    }

    /* get + set*/
    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }
}
