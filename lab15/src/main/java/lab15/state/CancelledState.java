package main.java.lab15.state;

/** ConcreteState: замовлення скасовано. Кінцевий стан, усі операції відхиляються базовим класом. */
public class CancelledState extends BaseOrderState {
    @Override
    public String getName() { return "CancelledState"; }
}