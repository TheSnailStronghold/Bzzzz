package org.bzzzzShop.models;

import org.bzzzzShop.models.orderState.OrderState;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class Order {
    private Integer order_number;       // Номер заказа

    private BigDecimal order_cost;      // Цена заказа

    private Date order_date;            // Дата заказа

    private Address delivery_address;   // Адрес доставки

    private OrderState orderState;      // Статус заказа

    private Basket basket;

    public Order(Integer order_number, Address delivery_address,
                 OrderState orderState, Basket basket) {
        this.order_number = order_number;
        this.delivery_address = delivery_address;
        this.orderState = orderState;
        this.basket = basket;

        order_date = new Date();

        order_cost = BigDecimal.ZERO;
        for (Map.Entry<Goods, Integer> e : basket.getContent().entrySet()) {
            order_cost = order_cost.add(
                    e.getKey().getPrice()
                            .multiply(new BigDecimal(e.getValue())));
        }

    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY");
        builder.append(String.format(
                "Номер заказа: %05d\n"
                        + "Статус заказа: %s\n"
                        + "Дата заказа: %s\n"
                        + "Адрес доставки: %s\n"
                        + "--------------------------------\n",
                order_number, orderState.getName(),
                dateFormat.format(order_date),
                delivery_address));
        basket.getContent().forEach((k, v) ->
                builder.append(String.format(
                        "%s - %d шт\n",
                        k.getName(), v)));
        builder.append("Итого: ").append(order_cost.setScale(BigDecimal.ROUND_FLOOR).toString());
        return builder.toString();
    }

    public void payOrder() {

    }

    public Integer getOrder_number() {
        return order_number;
    }

    public BigDecimal getOrder_cost() {
        return order_cost;
    }

    public Date getOrder_date() {
        return order_date;
    }

    public Address getDelivery_address() {
        return delivery_address;
    }

    public OrderState getOrderState() {
        return orderState;
    }

    public void changeState(OrderState state) {
        orderState = state;
    }

}
