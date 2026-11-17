package cinema13.chain;

/** Роль у шаблоні: ConcreteHandler. */
public class StudentDiscount extends DiscountHandler {
    protected String getName() { return "Студентська знижка"; }
    protected int getPercent() { return 10; }
    protected boolean isApplicable(Order order) { return order.isStudent(); }
}