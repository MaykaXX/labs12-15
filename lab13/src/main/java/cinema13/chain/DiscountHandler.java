package cinema13.chain;

import cinema13.Log;

public abstract class DiscountHandler {
    private DiscountHandler next;

    public DiscountHandler setNext(DiscountHandler next) {
        this.next = next;
        return next;
    }

    public final void handle(Order order) {
        Log.log(getName(), "Отримало замовлення: " + order.getCustomer());
        if (!isApplicable(order)) {
            Log.log(getName(), "Не підходить, передаю далі");
            passOn(order);
            return;
        }
        order.applyDiscount(getName(), getPercent());
        Log.log(getName(), "Застосовано знижку " + getPercent() + "%, ціна: " + String.format("%.2f", order.getPrice()));
        if (stopsChain()) {
            Log.log(getName(), "Ця знижка не поєднується з іншими, ланцюг зупинено");
            return;
        }
        passOn(order);
    }

    private void passOn(Order order) {
        if (next != null) {
            next.handle(order);
        }
    }

    protected abstract String getName();
    protected abstract boolean isApplicable(Order order);
    protected abstract int getPercent();

    protected boolean stopsChain() { return false; }
}