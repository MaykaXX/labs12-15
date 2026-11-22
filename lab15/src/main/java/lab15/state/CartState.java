package main.java.lab15.state;

import main.java.lab15.Logger;

import java.util.List;

/** ConcreteState: кошик. Місця можна змінювати, можна забронювати або скасувати. */
public class CartState extends BaseOrderState {
    @Override
    public String getName() { return "CartState"; }

    @Override
    public void changeSeats(Order order, List<String> newSeats) {
        order.setSeats(newSeats);
        Logger.log(getName(), "місця змінено на " + newSeats);
    }

    @Override
    public void reserve(Order order) {
        Logger.log(getName(), "місця заброньовано на " + ReservedState.RESERVATION_MINUTES + " хвилин");
        order.setState(new ReservedState());
    }

    @Override
    public void cancel(Order order) {
        Logger.log(getName(), "кошик скасовано");
        order.setState(new CancelledState());
    }
}