package org.bzzzzShop.models.beehive.components;

public enum Unit {
    CM("см"), MM("mm"), M("m");
    private String name;
    Unit(String name) {
        this.name = name;
    }
    public String getName(){
        return name;
    }
}
