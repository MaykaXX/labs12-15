package main.java.lab15.strategy;

import main.java.lab15.Logger;

public class StandardPricing implements PricingStrategy {
    @Override
    public double calculatePrice(Screening screening) {
        Logger.log(getName(), "базова ціна без коефіцієнтів");
        return screening.getBasePrice();
    }

    @Override
    public String getName() {
        return "StandardPricing";
    }
}
