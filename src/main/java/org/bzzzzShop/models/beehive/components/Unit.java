package org.bzzzzShop.models.beehive.components;

/* Класс - перечисление единиц измерения*/
public enum Unit {
    CM("см"), MM("мм"), M("М");

    private String name;

    Unit(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }
}
