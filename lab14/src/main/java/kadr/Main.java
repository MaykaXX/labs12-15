package main.java.kadr;

import main.java.kadr.mediator.*;
import main.java.kadr.observer.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("\n\t-----TASK 1 -----");
        orderFormScenario();
        System.out.println("\n\t-----TASK 2 -----");
        screeningNotificationsScenario();
    }

    /** Завдання 1: форма оформлення замовлення (Mediator). */
    static void orderFormScenario() {
        SessionSelector sessions = new SessionSelector();
        SeatMap seats = new SeatMap();
        GlassesToggle glasses = new GlassesToggle();
        PayButton pay = new PayButton();
        new OrderFormMediator(sessions, seats, glasses, pay);

        System.out.println("--- 1. Обрано 3D-сеанс ---");
        sessions.select(new Session("Дюна: Частина 2", true));

        System.out.println("--- 2. Обрано 2 місця ---");
        seats.selectSeats("A5", "A6");

        System.out.println("--- 3. Зміна сеансу на 2D ---");
        sessions.select(new Session("Паддінгтон", false));
    }

    /** Завдання 2: сповіщення про зміни в афіші (Observer). */
    static void screeningNotificationsScenario() {
        Screening premiere = new Screening("Дюна: Частина 3", "18:00");
        Website website = new Website();
        MobileApp app = new MobileApp();
        PremiereSubscriber olena = new PremiereSubscriber("Олена");
        PremiereSubscriber taras = new PremiereSubscriber("Тарас");
        TicketHolder ivan = new TicketHolder("Іван");
        TicketHolder maria = new TicketHolder("Марія");

        System.out.println("--- 1. Підписка на прем'єру, відкриття продажу ---");
        premiere.subscribe(website);
        premiere.subscribe(app);
        premiere.subscribe(olena);
        premiere.subscribe(taras);
        premiere.openSales();

        System.out.println("--- 2. Перенесення сеансу: сповіщення для власників квитків ---");
        premiere.subscribe(ivan);
        premiere.subscribe(maria);
        premiere.reschedule("20:30");

        System.out.println("--- 3. Відписка і скасування сеансу ---");
        premiere.unsubscribe(maria);
        premiere.cancel();
    }
}
