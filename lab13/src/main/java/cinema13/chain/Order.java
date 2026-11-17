package cinema13.chain;

import java.util.ArrayList;
import java.util.List;

/** Замовлення, до якого застосовуються знижки (дані, що йдуть по ланцюгу). */
public class Order {
    private final String customer;
    private double price;
    private String promoCode;
    private boolean student;
    private boolean birthday;
    private boolean regular;
    private boolean pensioner;
    private final List<String> appliedDiscounts = new ArrayList<>();

    public Order(String customer, double price) {
        this.customer = customer;
        this.price = price;
    }

    public Order withPromo(String code) { this.promoCode = code; return this; }
    public Order asStudent()   { this.student = true;   return this; }
    public Order withBirthday(){ this.birthday = true;  return this; }
    public Order asRegular()   { this.regular = true;   return this; }
    public Order asPensioner() { this.pensioner = true; return this; }

    public String getCustomer() { return customer; }
    public double getPrice() { return price; }
    public String getPromoCode() { return promoCode; }
    public boolean isStudent() { return student; }
    public boolean isBirthday() { return birthday; }
    public boolean isRegular() { return regular; }
    public boolean isPensioner() { return pensioner; }
    public List<String> getAppliedDiscounts() { return appliedDiscounts; }

    public void applyDiscount(String name, int percent) {
        price = price * (100 - percent) / 100.0;
        appliedDiscounts.add(name);
    }
}