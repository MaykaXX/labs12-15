package cinema.visitor;

import java.util.ArrayList;
import java.util.List;

/** ObjectStructure: замовлення, що містить позиції різних типів. */
public class Order {
    private final String number;
    private final List<OrderItem> items = new ArrayList<>();

    public Order(String number) { this.number = number; }

    public void add(OrderItem item) { items.add(item); }

    public String getNumber() { return number; }

    public double getTotal() {
        double sum = 0;
        for (OrderItem item : items) {
            sum += item.getPrice();
        }
        return sum;
    }

    public int size() { return items.size(); }

    /** Один прохід по всьому замовленню. */
    public void accept(OrderVisitor visitor) {
        for (OrderItem item : items) {
            item.accept(visitor);
        }
    }
}
