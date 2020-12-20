package org.bzzzzShop.models.orderState;

/* Класс, описывающий Статус Заказа*/
public class OrderState {

    private State state;

    public OrderState(State state){
        this.state = state;
    }

    public OrderState(){
        this.state = State.ACCEPTED;
    }

    public void setOrderState(State state){
        this.state = state;
    }

    @Override
    public String toString(){
        return "Статус заказа: " + state.getName();
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
