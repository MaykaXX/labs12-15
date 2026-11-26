package main.java.kadr.observer;

import kadr.Logger;

import java.util.ArrayList;
import java.util.List;

/** Не знає, хто саме підписаний, лише розсилає сповіщення зі списку. */
public class Screening {
    private final String title;
    private String time;
    private final List<SessionObserver> observers = new ArrayList<>();

    public Screening(String title, String time) {
        this.title = title;
        this.time = time;
    }

    public String getTitle() { return title; }

    public String getTime() { return time; }

    public void subscribe(SessionObserver observer) {
        observers.add(observer);
        Logger.log("Screening", "Підписано: " + observer.getName() + " (на «" + title + "»)");
    }

    public void unsubscribe(SessionObserver observer) {
        observers.remove(observer);
        Logger.log("Screening", "Відписано: " + observer.getName() + " (від «" + title + "»)");
    }

    public void reschedule(String newTime) {
        Logger.log("Screening", "«" + title + "» перенесено з " + time + " на " + newTime);
        time = newTime;
        notifyObservers(SessionEvent.RESCHEDULED);
    }

    public void cancel() {
        Logger.log("Screening", "«" + title + "» скасовано");
        notifyObservers(SessionEvent.CANCELLED);
    }

    public void openSales() {
        Logger.log("Screening", "Відкрито продаж квитків на «" + title + "»");
        notifyObservers(SessionEvent.SALES_OPENED);
    }

    private void notifyObservers(SessionEvent event) {
        Logger.log("Screening", "Сповіщаю підписників (" + observers.size() + "): " + event);
        for (SessionObserver observer : new ArrayList<>(observers)) {
            observer.update(this, event);
        }
    }
}