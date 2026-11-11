package cinema.flyweight;

/** Flyweight: спільні (внутрішні) дані категорії місця. */
public class SeatCategory {
    private final String name;
    private final String description;
    private final int seatWidthCm;
    private final String icon;
    private final double basePrice;

    SeatCategory(String name, String description, int seatWidthCm, String icon, double basePrice) {
        this.name = name;
        this.description = description;
        this.seatWidthCm = seatWidthCm;
        this.icon = icon;
        this.basePrice = basePrice;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + " (" + description + ", ширина " + seatWidthCm + " см, значок " + icon
                + ", ціна " + basePrice + " грн)";
    }
}
