package main.java.lab15.state;

import main.java.lab15.Logger;

/** ConcreteState: місця заброньовано на 15 хвилин. Можна оплатити, скасувати, або бронь спливе сама. */
public class ReservedState extends BaseOrderState {
    public static final int RESERVATION_MINUTES = 15;
    private int waited = 0;

    @Override
    public String getName() { return "ReservedState"; }

    @Override
    public void pay(Order order) {
        Logger.log(getName(), "оплату отримано");
        order.setState(new PaidState());
    }

    @Override
    public void cancel(Order order) {
        Logger.log(getName(), "бронь скасовано користувачем");
        order.setState(new CancelledState());
    }

    @Override
    public void waitMinutes(Order order, int minutes) {
        waited += minutes;
        if (waited >= RESERVATION_MINUTES) {
            Logger.log(getName(), "минуло " + waited + " хв без оплати, бронь знімається автоматично");
            order.setState(new CancelledState());
        } else {
            Logger.log(getName(), "минуло " + waited + " хв, до кінця броні " + (RESERVATION_MINUTES - waited) + " хв");
        }
    }
}