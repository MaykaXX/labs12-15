package main.java.kadr.observer;

import kadr.Logger;

/** ConcreteObserver: глядач, що чекає на прем'єру. Цікавиться тільки відкриттям продажу. */
public class PremiereSubscriber implements SessionObserver {
    private final String name;

    public PremiereSubscriber(String name) { this.name = name; }

    @Override
    public void update(Screening screening, SessionEvent event) {
        if (event == SessionEvent.SALES_OPENED) {
            Logger.log(name, "отримав повідомлення: відкрито продаж на «" + screening.getTitle() + "», купую квиток");
        } else {
            Logger.log(name, "подію " + event + " ігнорую, чекаю лише на старт продажу");
        }
    }

    @Override
    public String getName() { return name; }
}