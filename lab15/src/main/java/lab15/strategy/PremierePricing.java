package main.java.lab15.strategy;

import main.java.lab15.Logger;

/** Нове правило: додається одним класом, без змін в інших класах. */
public class PremierePricing implements PricingStrategy {
    @Override
    public double calculatePrice(Screening screening) {
        Logger.log(getName(), "прем'єрна надбавка ×1.5");
        return screening.getBasePrice() * 1.5;
    }

    @Override
    public String getName() {
        return "PremierePricing";
    }
}
