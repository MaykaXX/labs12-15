package cinema13.chain;

/** Роль у шаблоні: ConcreteHandler. */
public class PensionerDiscount extends DiscountHandler {
    protected String getName() { return "Знижка пенсіонера"; }
    protected int getPercent() { return 12; }
    protected boolean isApplicable(Order order) { return order.isPensioner(); }
}