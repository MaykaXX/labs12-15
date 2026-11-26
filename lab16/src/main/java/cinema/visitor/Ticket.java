package cinema.visitor;

/** ConcreteElement: квиток. */
public class Ticket implements OrderItem {
    private final String movie;
    private final double price;

    public Ticket(String movie, double price) {
        this.movie = movie;
        this.price = price;
    }

    @Override public void accept(OrderVisitor v) { v.visitTicket(this); }
    @Override public String getName() { return "Квиток на '" + movie + "'"; }
    @Override public double getPrice() { return price; }
}
