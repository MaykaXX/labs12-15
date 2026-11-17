package cinema13.chain;

/** Роль у шаблоні: ConcreteHandler. */
public class PromoCodeDiscount extends DiscountHandler {
    protected String getName() { return "Промокод"; }
    protected int getPercent() { return 20; }
    protected boolean isApplicable(Order order) { return order.getPromoCode() != null; }
    protected boolean stopsChain() { return true; } // з промокодом інші знижки не діють
}