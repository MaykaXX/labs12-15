package main.java.lab15.state;

import main.java.lab15.Logger;

/** ConcreteState: оплачено. Можна повернути гроші (до сеансу) або пройти в зал. */
public class PaidState extends BaseOrderState {
    @Override
    public String getName() { return "PaidState"; }

    @Override
    public void refund(Order order) {
        Logger.log(getName(), "гроші повернено");
        order.setState(new CancelledState());
    }

    @Override
    public void enterHall(Order order) {
        Logger.log(getName(), "квитки перевірено, прохід у зал дозволено");
        order.setState(new UsedState());
    }
}