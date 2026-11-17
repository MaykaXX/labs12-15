package cinema13.chain;

/** Роль у шаблоні: ConcreteHandler. */
public class BirthdayDiscount extends DiscountHandler {
    protected String getName() { return "Знижка дня народження"; }
    protected int getPercent() { return 15; }
    protected boolean isApplicable(Order order) { return order.isBirthday(); }
}