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

    public void showOrderState(){
        System.out.println("Статус заказа: " + this.state.getName());
    }

    public void setOrderState(State state){
        this.state = state;
    }


    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();

        builder.append("Статус заказа: " + state.getName());

        return builder.toString();
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
