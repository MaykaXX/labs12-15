package main.java.kadr.observer;

import kadr.Logger;

/** ConcreteObserver: сайт кінотеатру оновлює афішу при будь-якій зміні. */
public class Website implements SessionObserver {
    @Override
    public void update(Screening screening, SessionEvent event) {
        Logger.log(getName(), "афішу оновлено: «" + screening.getTitle() + "» — " + event);
    }

    @Override
    public String getName() { return "Сайт"; }
}