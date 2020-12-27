package org.bzzzzShop.models.order;

import org.bzzzzShop.models.Basket;
import org.bzzzzShop.models.Goods;
import org.bzzzzShop.models.orderState.OrderState;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

public class Order {
    private UUID order_number;       // Номер заказа

    private BigDecimal order_cost;      // Цена заказа

    private Date order_date;            // Дата заказа

    private OrderState orderState;      // Статус заказа

    private Map<Goods, Integer> goods;

    private Coupon coupon;
//    private Basket basket;

    public Order() {
        order_number = UUID.randomUUID();
        order_date = new Date();
        orderState = OrderState.ACCEPTED;
    }

    public Order(Map<Goods, Integer> goods) {
        this();
        this.goods = goods;

        order_cost = BigDecimal.ZERO;
        for (Map.Entry<Goods, Integer> e : goods.entrySet()) {
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
                "Номер заказа: %s\n"
                        + "Статус заказа: %s\n"
                        + "Дата заказа: %s\n"
                , order_number, orderState.getName(),
                dateFormat.format(order_date)));
        goods.forEach((k, v) ->
                builder.append(String.format(
                        "%s - %d шт\n",
                        k.getName(), v)));
        builder.append("Итого: ").append(order_cost.setScale(BigDecimal.ROUND_FLOOR).toString());
        return builder.toString();
    }


    public UUID getOrder_number() {
        return order_number;
    }

    public BigDecimal getOrder_cost() {
        return order_cost;
    }

    public Date getOrder_date() {
        return order_date;
    }

    public OrderState getOrderState() {
        return orderState;
    }

    public void changeState(OrderState state) {
        orderState = state;
    }

}
