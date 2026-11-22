package main.java.lab15.state;

import main.java.lab15.Logger;

import java.util.List;

/** За замовчуванням усі операції недопустимі й повертають зрозуміле повідомлення. Стани перевизначають лише дозволені. */
public abstract class BaseOrderState implements OrderState {
    @Override
    public void changeSeats(Order order, List<String> newSeats) {
        deny("зміна місць", "змінити місця можна лише в кошику");
    }

    @Override
    public void reserve(Order order) {
        deny("бронювання", "забронювати можна лише замовлення з кошика");
    }

    @Override
    public void pay(Order order) {
        deny("оплата", "оплатити можна лише заброньоване замовлення");
    }

    @Override
    public void refund(Order order) {
        deny("повернення грошей", "повернути гроші можна лише після оплати і до сеансу");
    }

    @Override
    public void enterHall(Order order) {
        deny("прохід у зал", "пройти в зал можна лише з оплаченим замовленням");
    }

    @Override
    public void cancel(Order order) {
        deny("скасування", "скасувати можна лише кошик або неоплачену бронь");
    }

    @Override
    public void waitMinutes(Order order, int minutes) {
        // у більшості станів час нічого не змінює
    }

    private void deny(String operation, String reason) {
        Logger.log(getName(), "ВІДМОВА (" + operation + "): " + reason);
    }
}