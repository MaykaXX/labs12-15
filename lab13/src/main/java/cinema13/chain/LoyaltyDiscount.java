package cinema13.chain;

/** Роль у шаблоні: ConcreteHandler. */
public class LoyaltyDiscount extends DiscountHandler {
    protected String getName() { return "Знижка постійного клієнта"; }
    protected int getPercent() { return 5; }
    protected boolean isApplicable(Order order) { return order.isRegular(); }
}