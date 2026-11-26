package cinema.visitor;

/** Element: позиція замовлення. Приймає відвідувача. */
public interface OrderItem {
    void accept(OrderVisitor visitor);
    String getName();
    double getPrice();
}
