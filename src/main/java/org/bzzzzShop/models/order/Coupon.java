package org.bzzzzShop.models.order;

public enum Coupon {

    COUPON005(5),
    COUPON015(15),
    COUPON020(20),
    COUPON035(35);

    private int discount;

    Coupon(int discount) {
        this.discount = discount;
    }

    public int getDiscount() {
        return discount;
    }
}
