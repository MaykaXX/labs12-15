package cinema.visitor;

/** ConcreteElement: подарунковий сертифікат. */
public class GiftCertificate implements OrderItem {
    private final double nominal;

    public GiftCertificate(double nominal) { this.nominal = nominal; }

    @Override public void accept(OrderVisitor v) { v.visitGiftCertificate(this); }
    @Override public String getName() { return "Подарунковий сертифікат"; }
    @Override public double getPrice() { return nominal; }
}
