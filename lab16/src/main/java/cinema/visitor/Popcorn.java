package cinema.visitor;

/** ConcreteElement: попкорн. */
public class Popcorn implements OrderItem {
    private final String size;
    private final double price;

    public Popcorn(String size, double price) {
        this.size = size;
        this.price = price;
    }

    @Override public void accept(OrderVisitor v) { v.visitPopcorn(this); }
    @Override public String getName() { return "Попкорн (" + size + ")"; }
    @Override public double getPrice() { return price; }
}
