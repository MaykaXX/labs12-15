package main.java.lab15.state;

import main.java.lab15.Logger;

import java.util.List;

/** Context: замовлення нічого не перевіряє, а передає кожну операцію поточному стану. */
public class Order {
    private final int id;
    private List<String> seats;
    private OrderState state = new CartState();

    public Order(int id, List<String> seats) {
        this.id = id;
        this.seats = seats;
        Logger.log(getSource(), "створено, місця " + seats + ", стан " + state.getName());
    }

    public void changeSeats(List<String> newSeats) { state.changeSeats(this, newSeats); }

    public void reserve() { state.reserve(this); }

    public void pay() { state.pay(this); }

    public void refund() { state.refund(this); }

    public void enterHall() { state.enterHall(this); }

    public void cancel() { state.cancel(this); }

    public void waitMinutes(int minutes) { state.waitMinutes(this, minutes); }

    void setState(OrderState newState) {
        Logger.log(getSource(), "стан: " + state.getName() + " → " + newState.getName());
        this.state = newState;
    }

    void setSeats(List<String> seats) { this.seats = seats; }

    public List<String> getSeats() { return seats; }

    public String getStateName() { return state.getName(); }

    private String getSource() { return "Order #" + id; }
}