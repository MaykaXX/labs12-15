package main.java.lab15;

import main.java.lab15.state.Order;
import main.java.lab15.strategy.*;
import main.java.lab15.template.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("\n\t-----TASK 1 -----");
        pricingScenario();
        System.out.println("\n\t-----TASK 2 -----");
        orderStateScenario();
        System.out.println("\n\t-----TASK 3 -----");
        sessionClosingScenario();
    }

    /** Завдання 1: ціноутворення квитків (Strategy). */
    static void pricingScenario() {
        Screening screening = new Screening("Дюна: Частина 2", 200.0, 100, 80);
        TicketOffice office = new TicketOffice();

        System.out.println("--- 1. Стандартне і динамічне правило (зала заповнена на 80%) ---");
        screening.setPricingStrategy(new StandardPricing());
        office.sellTicket(screening);
        screening.setPricingStrategy(new DynamicPricing());
        office.sellTicket(screening);

        System.out.println("--- 2. Зміна правила на корпоративне ---");
        screening.setPricingStrategy(new CorporatePricing());
        office.sellTicket(screening);

        System.out.println("--- 3. Нове правило «прем'єра» одним класом ---");
        screening.setPricingStrategy(new PremierePricing());
        office.sellTicket(screening);
    }

    /** Завдання 2: стан замовлення (State). */
    static void orderStateScenario() {
        System.out.println("--- 1. Від кошика до використання ---");
        Order order1 = new Order(1, List.of("A1", "A2"));
        order1.changeSeats(List.of("B3", "B4"));
        order1.reserve();
        order1.changeSeats(List.of("C1", "C2"));   // відмова: уже не кошик
        order1.pay();
        order1.enterHall();
        order1.refund();                            // відмова: замовлення використано

        System.out.println("--- 2. Бронювання не оплачене за 15 хвилин ---");
        Order order2 = new Order(2, List.of("D5"));
        order2.reserve();
        order2.waitMinutes(10);
        order2.waitMinutes(5);
        order2.pay();                               // відмова: бронь скасована

        System.out.println("--- 3. Прохід у зал з неоплаченим замовленням ---");
        Order order3 = new Order(3, List.of("E7", "E8"));
        order3.reserve();
        order3.enterHall();                         // відмова

        System.out.println("--- 4. Повернення грошей після оплати ---");
        Order order4 = new Order(4, List.of("F1"));
        order4.reserve();
        order4.refund();                            // відмова: ще не оплачено
        order4.pay();
        order4.refund();
    }

    /** Завдання 3: закриття сеансу (Template Method). */
    static void sessionClosingScenario() {
        System.out.println("--- 1. Закриття 2D-сеансу: усі базові етапи ---");
        new Session2DClosing("Паддінгтон").close();

        System.out.println("--- 2. Закриття 3D і VIP тією самою процедурою ---");
        List<SessionClosing> sessions = List.of(
                new Session3DClosing("Аватар"),
                new SessionVipClosing("Дюна: Частина 2"));
        for (SessionClosing session : sessions) {
            session.close();
        }
    }
}

