package main.java.lab15.strategy;

/** Strategy: єдиний інтерфейс усіх правил ціноутворення. */
public interface PricingStrategy {
    double calculatePrice(Screening screening);

    String getName();
}
