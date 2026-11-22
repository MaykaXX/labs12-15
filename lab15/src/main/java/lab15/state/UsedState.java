package main.java.lab15.state;

/** ConcreteState: замовлення використано. Кінцевий стан, усі операції відхиляються базовим класом. */
public class UsedState extends BaseOrderState {
    @Override
    public String getName() { return "UsedState"; }
}