package main.java.kadr.observer;

import kadr.Logger;

/** ConcreteObserver: глядач, що купив квиток. Реагує лише на перенесення і скасування. */
public class TicketHolder implements SessionObserver {
    private final String name;

    public TicketHolder(String name) { this.name = name; }

    @Override
    public void update(Screening screening, SessionEvent event) {
        switch (event) {
            case RESCHEDULED -> Logger.log(name, "отримав повідомлення: сеанс «" + screening.getTitle()
                    + "» тепер о " + screening.getTime());
            case CANCELLED -> Logger.log(name, "отримав повідомлення: сеанс «" + screening.getTitle()
                    + "» скасовано, оформлюю повернення квитка");
            default -> Logger.log(name, "подію " + event + " ігнорую, квиток уже є");
        }
    }

    @Override
    public String getName() { return name; }
}