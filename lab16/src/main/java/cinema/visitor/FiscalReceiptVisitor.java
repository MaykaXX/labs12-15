package cinema.visitor;

import cinema.Log;

/**
 * ConcreteVisitor: фіскальний чек.
 * Додається ОДНИМ класом, без змін у класах позицій.
 */
public class FiscalReceiptVisitor implements OrderVisitor {
    private int lineNumber = 0;
    private double sum = 0;

    public double getSum() { return sum; }

    private void line(OrderItem item) {
        lineNumber++;
        sum += item.getPrice();
        Log.log("Чек", lineNumber + ") " + item.getName() + " ... " + Log.money(item.getPrice()));
    }

    @Override public void visitTicket(Ticket item) { line(item); }
    @Override public void visitDrink(Drink item) { line(item); }
    @Override public void visitPopcorn(Popcorn item) { line(item); }
    @Override public void visitGlasses3D(Glasses3D item) { line(item); }
    @Override public void visitGiftCertificate(GiftCertificate item) { line(item); }
}
