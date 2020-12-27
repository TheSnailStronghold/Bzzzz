package org.bzzzzShop.models.orderState;

/* Класс - перечисление возможных статусов заказа*/
public enum OrderState {

    ACCEPTED("заказ принят"),

    GATHERING_ITEMS("сбор заказа"),
    IN_TRANSFER("передан в службу доставки"),
    DELIVERED_TO_PICK_UP_POINT("доставлен в пункт выдачи"),
    COMPLETED("заказ завершен");

    private String name;

    OrderState(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }

}
