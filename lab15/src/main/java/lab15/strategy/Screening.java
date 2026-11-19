package main.java.lab15.strategy;

import main.java.lab15.Logger;

/** Context: сеанс зберігає правило ціноутворення, яке можна змінити в будь-який момент. */
public class Screening {
    private final String title;
    private final double basePrice;
    private final int capacity;
    private final int soldSeats;
    private PricingStrategy pricingStrategy;

    public Screening(String title, double basePrice, int capacity, int soldSeats) {
        this.title = title;
        this.basePrice = basePrice;
        this.capacity = capacity;
        this.soldSeats = soldSeats;
    }

    public void setPricingStrategy(PricingStrategy strategy) {
        String old = pricingStrategy == null ? "—" : pricingStrategy.getName();
        this.pricingStrategy = strategy;
        Logger.log("Screening", "правило ціноутворення сеансу «" + title + "»: " + old + " → " + strategy.getName());
    }

    public double calculatePrice() {
        Logger.log("Screening", "застосовується правило " + pricingStrategy.getName());
        return pricingStrategy.calculatePrice(this);
    }

    public String getTitle() {
        return title;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public int getOccupancyPercent() {
        return soldSeats * 100 / capacity;
    }
}
