package main.java.kadr.observer;

/** Observer: усе, що сеанс знає про отримувача. */
public interface SessionObserver {
    void update(Screening screening, SessionEvent event);

    String getName();
}