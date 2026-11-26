package cinema.visitor;

/** ConcreteElement: напій. */
public class Drink implements OrderItem {
    private final String title;
    private final double price;

    public Drink(String title, double price) {
        this.title = title;
        this.price = price;
    }

    @Override public void accept(OrderVisitor v) { v.visitDrink(this); }
    @Override public String getName() { return "Напій " + title; }
    @Override public double getPrice() { return price; }
}
