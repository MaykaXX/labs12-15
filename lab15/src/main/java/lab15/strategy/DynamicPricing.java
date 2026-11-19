package main.java.lab15.strategy;

import main.java.lab15.Logger;

public class DynamicPricing implements PricingStrategy {
    @Override
    public double calculatePrice(Screening screening) {
        int occupancy = screening.getOccupancyPercent();
        double factor = occupancy >= 80 ? 1.25 : occupancy >= 50 ? 1.10 : 1.0;
        Logger.log(getName(), "заповненість зали " + occupancy + "% → коефіцієнт " + factor);
        return screening.getBasePrice() * factor;
    }

    @Override
    public String getName() {
        return "DynamicPricing";
    }
}
