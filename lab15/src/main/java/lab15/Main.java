package main.java.lab15;
import main.java.lab15.strategy.*;

public class Main {
    public static void main(String[] args) {
        System.out.printf("\n\t---- TASK 1 ----");
        pricingScenario();
    }

    /** Завдання 1: ціноутворення квитків (Strategy). */
    static void pricingScenario() {
        TicketOffice office = new TicketOffice();
        Screening screening = new Screening("Дюна: Частина 2", 150.0, 100, 80); // зала заповнена на 80%

        System.out.println("--- 1. Стандартне та динамічне правило (зала заповнена на 80%) ---");
        screening.setPricingStrategy(new StandardPricing());
        office.sellTicket(screening);
        screening.setPricingStrategy(new DynamicPricing());
        office.sellTicket(screening);

        System.out.println("--- 2. Зміна правила на корпоративне під час виконання ---");
        screening.setPricingStrategy(new CorporatePricing());
        office.sellTicket(screening);

        System.out.println("--- 3. Нове правило «прем'єра» (один новий клас) ---");
        screening.setPricingStrategy(new PremierePricing());
        office.sellTicket(screening);
    }
}
