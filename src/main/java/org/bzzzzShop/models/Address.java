package org.bzzzzShop.models;

public class Address {
    private String country;
    private String city;
    private String street;
    private String house;
    private String flat;

    /* Конструктор для частного дома */
    public Address(String country, String city, String street, String house)
    {
        this.country = country;
        this.city = city;
        this.street = street;
        this.house = house;
        this.flat = "-";
    }

    /* Конструктор для многоквартирного дома */
    public Address(String country, String city, String street, String house, String flat)
    {
        this.country = country;
        this.city = city;
        this.street = street;
        this.house = house;
        this.flat = flat;

    }

    public String toString()
    {
        StringBuilder builder = new StringBuilder();

        builder.append("Адрес: " + country + ", " + city + ", ул." + street + ", д." + house);

        if(flat!="-") builder.append(", кв." + flat);

        return builder.toString();
    }

    /* get + set */

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getFlat() {
        return flat;
    }

    public void setFlat(String flat) {
        this.flat = flat;
    }
}
