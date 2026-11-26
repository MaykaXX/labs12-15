package cinema.visitor;

import cinema.Log;

/** ConcreteVisitor: нарахування бонусів (сертифікат і окуляри бонусів не дають). */
public class BonusVisitor implements OrderVisitor {
    private double totalBonus = 0;

    public double getTotalBonus() { return totalBonus; }

    private void addBonus(OrderItem item, double rate) {
        double bonus = item.getPrice() * rate;
        totalBonus += bonus;
        Log.log("Бонуси", item.getName() + ": +" + Log.money(bonus)
                + " (" + (int) (rate * 100) + "%)");
    }

    @Override public void visitTicket(Ticket item) { addBonus(item, 0.10); }
    @Override public void visitDrink(Drink item) { addBonus(item, 0.05); }
    @Override public void visitPopcorn(Popcorn item) { addBonus(item, 0.05); }

    @Override public void visitGlasses3D(Glasses3D item) {
        Log.log("Бонуси", item.getName() + ": бонуси не нараховуються");
    }

    @Override public void visitGiftCertificate(GiftCertificate item) {
        Log.log("Бонуси", item.getName() + ": бонуси не нараховуються");
    }
}
