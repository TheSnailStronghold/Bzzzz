package org.bzzzzShop.models.orderState;

/* Класс - перечисление возможных статусов заказа*/
public enum State {

    ACCEPTED("Заказ принят"),
    GATHERING_ITEMS("Сбор заказа"),
    IN_TRANSFER("Передан в службу доставки"),
    DELIVERED_TO_PICK_UP_POINT("Доставлен в пункт выдачи"),
    COMPLETED("Заказ завершен");

    private String name;

    State(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }

}
