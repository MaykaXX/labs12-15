package cinema.visitor;

/** ConcreteElement: 3D-окуляри. */
public class Glasses3D implements OrderItem {
    private final double price;

    public Glasses3D(double price) { this.price = price; }

    @Override public void accept(OrderVisitor v) { v.visitGlasses3D(this); }
    @Override public String getName() { return "3D-окуляри"; }
    @Override public double getPrice() { return price; }
}
