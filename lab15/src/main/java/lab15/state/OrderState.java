package main.java.lab15.state;

import java.util.List;

/** State: усі операції замовлення. Кожен стан сам вирішує, що з ними робити. */
public interface OrderState {
    String getName();

    void changeSeats(Order order, List<String> newSeats);

    void reserve(Order order);

    void pay(Order order);

    void refund(Order order);

    void enterHall(Order order);

    void cancel(Order order);

    void waitMinutes(Order order, int minutes);
}