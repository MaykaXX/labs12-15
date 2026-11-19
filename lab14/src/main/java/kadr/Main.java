package main.java.kadr;
import main.java.kadr.mediator.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("\n\t-----TASK 1 -----");
        orderFormScenario();
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
}
