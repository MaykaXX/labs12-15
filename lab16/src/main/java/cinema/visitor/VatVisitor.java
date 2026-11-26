package cinema.visitor;

import cinema.Log;

/** ConcreteVisitor: розрахунок ПДВ (ставки умовні й різні). */
public class VatVisitor implements OrderVisitor {
    private double totalVat = 0;

    public double getTotalVat() { return totalVat; }

    private void addVat(OrderItem item, double rate) {
        double vat = item.getPrice() * rate;
        totalVat += vat;
        Log.log("ПДВ", item.getName() + ": " + Log.money(item.getPrice())
                + " x " + (int) (rate * 100) + "% = " + Log.money(vat));
    }

    @Override public void visitTicket(Ticket item) { addVat(item, 0.07); }
    @Override public void visitDrink(Drink item) { addVat(item, 0.20); }
    @Override public void visitPopcorn(Popcorn item) { addVat(item, 0.14); }
    @Override public void visitGlasses3D(Glasses3D item) { addVat(item, 0.20); }
    @Override public void visitGiftCertificate(GiftCertificate item) { addVat(item, 0.0); }
}
