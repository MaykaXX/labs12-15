package cinema.visitor;

/** Visitor: окремий метод для кожного типу позиції. */
public interface OrderVisitor {
    void visitTicket(Ticket item);
    void visitDrink(Drink item);
    void visitPopcorn(Popcorn item);
    void visitGlasses3D(Glasses3D item);
    void visitGiftCertificate(GiftCertificate item);
}
