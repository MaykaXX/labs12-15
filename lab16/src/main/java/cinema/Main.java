package cinema;

import cinema.iterator.*;
import cinema.visitor.*;

/** Клас-раннер: сценарії завдання 1 (Iterator) і завдання 2 (Visitor). */
public class Main {

    public static void main(String[] args) {
        System.out.println();
        Log.log("Runner", "===== ЗАВДАННЯ 1: ITERATOR (розклад сеансів) =====");
        System.out.println();
        Schedule schedule = createSchedule();
        iteratorScenario1Chronological(schedule);
        iteratorScenario2Movie(schedule);
        iteratorScenario3FreeSeatsAndParallel(schedule);

        System.out.println();
        Log.log("Runner", "===== ЗАВДАННЯ 2: VISITOR (замовлення) =====");
        System.out.println();
        Order order = createOrder();
        visitorScenario1Vat(order);
        visitorScenario2Bonus(order);
        visitorScenario3FiscalReceipt(order);
    }

    // ---------------- Iterator ----------------

    /** Розклад: 3 зали, по 1 дню з кількома сеансами (дані умовні). */
    private static Schedule createSchedule() {
        Schedule schedule = new Schedule();
        String date = "2026-11-26";

        Hall h1 = new Hall("Зала 1");
        Day d1 = new Day(date);
        d1.addSession(new Session("Дюна", "Зала 1", date, "10:00", 25));
        d1.addSession(new Session("Шрек", "Зала 1", date, "16:30", 0));
        h1.addDay(d1);

        Hall h2 = new Hall("Зала 2");
        Day d2 = new Day(date);
        d2.addSession(new Session("Шрек", "Зала 2", date, "12:15", 40));
        d2.addSession(new Session("Дюна", "Зала 2", date, "20:00", 0));
        h2.addDay(d2);

        Hall h3 = new Hall("Зала 3");
        Day d3 = new Day(date);
        d3.addSession(new Session("Аватар", "Зала 3", date, "09:30", 12));
        d3.addSession(new Session("Дюна", "Зала 3", date, "14:00", 8));
        h3.addDay(d3);

        schedule.addHall(h1);
        schedule.addHall(h2);
        schedule.addHall(h3);
        Log.log("Runner", "Розклад створено: 3 зали, 6 сеансів на 2026-11-26");
        return schedule;
    }

    private static void iteratorScenario1Chronological(Schedule schedule) {
        Log.log("Runner", "--- Ситуація 1: усі сеанси в хронологічному порядку ---");
        SessionIterator it = schedule.createChronologicalIterator();
        Log.log("Сайт", "ДО обходу: ітератор створено, перший сеанс ще не прочитано");
        int count = 0;
        while (it.hasNext()) {
            Session s = it.next();
            count++;
            Log.log("Сайт", count + ". " + s);
        }
        Log.log("Сайт", "ПІСЛЯ обходу: прочитано сеансів = " + count + ", hasNext = " + it.hasNext());
    }

    private static void iteratorScenario2Movie(Schedule schedule) {
        Log.log("Runner", "--- Ситуація 2: сеанси одного фільму (Дюна) ---");
        SessionIterator it = schedule.createMovieIterator("Дюна");
        Log.log("Застосунок", "ДО обходу: шукаємо сеанси фільму 'Дюна'");
        int count = 0;
        while (it.hasNext()) {
            Session s = it.next();
            count++;
            Log.log("Застосунок", count + ". " + s);
        }
        Log.log("Застосунок", "ПІСЛЯ обходу: знайдено сеансів = " + count);
    }

    private static void iteratorScenario3FreeSeatsAndParallel(Schedule schedule) {
        Log.log("Runner", "--- Ситуація 3: вільні місця + одночасно інший обхід ---");
        SessionIterator cashier = schedule.createFreeSeatsIterator();
        SessionIterator site = schedule.createChronologicalIterator();
        Log.log("Runner", "ДО: створено два незалежні ітератори (Каса і Сайт)");

        // Обидва ітератори рухаємо по черзі, щоб показати їхню незалежність
        while (cashier.hasNext() || site.hasNext()) {
            if (cashier.hasNext()) {
                Log.log("Каса", "вільні місця: " + cashier.next());
            }
            if (site.hasNext()) {
                Log.log("Сайт", "хронологія: " + site.next());
            }
        }
        Log.log("Runner", "ПІСЛЯ: обидва обходи завершено, кожен пройшов свій набір сеансів");
    }

    // ---------------- Visitor ----------------

    private static Order createOrder() {
        Order order = new Order("№101");
        order.add(new Ticket("Дюна", 180));
        order.add(new Ticket("Дюна", 180));
        order.add(new Drink("Кола", 60));
        order.add(new Popcorn("великий", 120));
        order.add(new Glasses3D(30));
        order.add(new GiftCertificate(500));
        Log.log("Runner", "Створено замовлення " + order.getNumber() + ": позицій = "
                + order.size() + ", сума = " + Log.money(order.getTotal()));
        return order;
    }

    private static void visitorScenario1Vat(Order order) {
        Log.log("Runner", "--- Ситуація 1: розрахунок ПДВ ---");
        VatVisitor vat = new VatVisitor();
        Log.log("ПДВ", "ДО: ПДВ = " + Log.money(vat.getTotalVat()));
        order.accept(vat);
        Log.log("ПДВ", "ПІСЛЯ: ПДВ = " + Log.money(vat.getTotalVat()));
    }

    private static void visitorScenario2Bonus(Order order) {
        Log.log("Runner", "--- Ситуація 2: нарахування бонусів ---");
        BonusVisitor bonus = new BonusVisitor();
        Log.log("Бонуси", "ДО: бонуси = " + Log.money(bonus.getTotalBonus()));
        order.accept(bonus);
        Log.log("Бонуси", "ПІСЛЯ: бонуси = " + Log.money(bonus.getTotalBonus()));
    }

    private static void visitorScenario3FiscalReceipt(Order order) {
        Log.log("Runner", "--- Ситуація 3: нова операція 'фіскальний чек' (один новий клас) ---");
        FiscalReceiptVisitor receipt = new FiscalReceiptVisitor();
        Log.log("Чек", "ДО: сума чека = " + Log.money(receipt.getSum()));
        order.accept(receipt);
        Log.log("Чек", "ПІСЛЯ: сума чека = " + Log.money(receipt.getSum())
                + " (сума замовлення = " + Log.money(order.getTotal()) + ")");
    }
}
