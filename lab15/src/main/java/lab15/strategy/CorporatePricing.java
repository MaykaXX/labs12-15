package main.java.lab15.strategy;

import main.java.lab15.Logger;

public class CorporatePricing implements PricingStrategy {
    private static final double DISCOUNT = 0.20;

    @Override
    public double calculatePrice(Screening screening) {
        Logger.log(getName(), "корпоративна знижка " + (int) (DISCOUNT * 100) + "%");
        return screening.getBasePrice() * (1 - DISCOUNT);
    }

    @Override
    public String getName() {
        return "CorporatePricing";
    }
}
