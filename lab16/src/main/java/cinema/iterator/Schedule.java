package cinema.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * ConcreteAggregate: розклад кінотеатру (зали -> дні -> сеанси).
 * Внутрішню структуру знає тільки цей клас.
 */
public class Schedule implements SessionCollection {
    private final List<Hall> halls = new ArrayList<>();

    public void addHall(Hall h) { halls.add(h); }

    /** Розгортає структуру в плоский список. Доступний лише ітераторам (пакет). */
    List<Session> flatten() {
        List<Session> result = new ArrayList<>();
        for (Hall h : halls) {
            for (Day d : h.getDays()) {
                result.addAll(d.getSessions());
            }
        }
        return result;
    }

    @Override
    public SessionIterator createChronologicalIterator() {
        return new ChronologicalIterator(this);
    }

    @Override
    public SessionIterator createMovieIterator(String movie) {
        return new MovieIterator(this, movie);
    }

    @Override
    public SessionIterator createFreeSeatsIterator() {
        return new FreeSeatsIterator(this);
    }
}
