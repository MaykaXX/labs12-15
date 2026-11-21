package main.java.kadr.observer;

import kadr.Logger;

/** ConcreteObserver: мобільний застосунок надсилає push про будь-яку зміну. */
public class MobileApp implements SessionObserver {
    @Override
    public void update(Screening screening, SessionEvent event) {
        Logger.log(getName(), "push-сповіщення: «" + screening.getTitle() + "» — " + event);
    }

    @Override
    public String getName() { return "Застосунок"; }
}