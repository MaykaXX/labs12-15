import cinema13.Log;
import cinema13.chain.*;
import cinema13.command.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Завдання 1 (Command)
        System.out.println("\n---Task1---");
        volumeUndo();
        sessionStart();
        emergency();
        // Завдання 2 (Chain of Responsibility)
        System.out.println("\n---Task2---");

        discountsStudentAndPromo();
        discountsPensioner();
    }

    private static void volumeUndo() {
        System.out.println("\n=== Зміна гучності і скасування ===");
        Hall hall = new Hall();
        Operator operator = new Operator();
        operator.run(new VolumeCommand(hall, 0));
        operator.undoLast();
        Log.log("Main", "Гучність після скасування: " + hall.getVolume());
    }

    private static void sessionStart() {
        System.out.println("\n=== Набір «Початок сеансу» ===");
        Hall hall = new Hall();
        Operator operator = new Operator();
        operator.run(new MacroCommand("Початок сеансу", List.of(
                new LightCommand(hall, false),
                new VolumeCommand(hall, 40),
                new AdsCommand(hall))));
    }

    private static void emergency() {
        System.out.println("\n=== Набір «Аварійна ситуація» ===");
        Hall hall = new Hall();
        Operator operator = new Operator();
        operator.run(new MacroCommand("Аварійна ситуація", List.of(
                new PauseCommand(hall),
                new LightCommand(hall, true),
                new VolumeCommand(hall, 20))));
        operator.printJournal();
    }

    // ---------- Завдання 2: знижки ----------

    /** Порядок правил задається тут, під час виконання програми. */
    private static DiscountHandler buildChain(boolean withPensioner) {
        DiscountHandler first = new PromoCodeDiscount();
        DiscountHandler last = first.setNext(new StudentDiscount());
        last = last.setNext(new BirthdayDiscount());
        last = last.setNext(new LoyaltyDiscount());
        if (withPensioner) {
            last.setNext(new PensionerDiscount()); // нове правило: існуючі класи не змінюємо
        }
        return first;
    }

    private static void printResult(Order order) {
        Log.log("Main", "Підсумок для " + order.getCustomer() + ": " + order.getAppliedDiscounts()
                + ", до сплати " + String.format("%.2f", order.getPrice()));
    }

    private static void discountsStudentAndPromo() {
        System.out.println("\n=== Знижки: студент і промокод ===");
        DiscountHandler chain = buildChain(false);

        Log.log("Main", "--- Студент без промокоду ---");
        Order student = new Order("Студент Андрій", 200).asStudent().asRegular();
        chain.handle(student);
        printResult(student);

        Log.log("Main", "--- Замовлення з промокодом: інші знижки не діють ---");
        Order promo = new Order("Студентка Марія", 200).asStudent().asRegular().withPromo("KADR20");
        chain.handle(promo);
        printResult(promo);
    }

    private static void discountsPensioner() {
        System.out.println("\n=== Знижки: додано правило для пенсіонерів ===");
        DiscountHandler chain = buildChain(true);

        Order pensioner = new Order("Пенсіонерка Ольга", 200).asPensioner().asRegular();
        chain.handle(pensioner);
        printResult(pensioner);

        Log.log("Main", "--- Замовлення, до якого жодне правило не підійшло ---");
        Order none = new Order("Відвідувач Іван", 200);
        chain.handle(none);
        printResult(none);
    }
}