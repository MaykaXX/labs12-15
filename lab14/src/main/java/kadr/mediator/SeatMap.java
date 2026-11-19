package main.java.kadr.mediator;

import kadr.Logger;

import java.util.ArrayList;
import java.util.List;

public class SeatMap extends FormElement {
    private final List<String> selectedSeats = new ArrayList<>();

    public SeatMap() {
        super("SeatMap");
    }

    /** Дія користувача: обрання місць. */
    public void selectSeats(String... seats) {
        selectedSeats.addAll(List.of(seats));
        Logger.log(name, "користувач обрав місця " + selectedSeats);
        mediator.notify(this, FormEvent.SEATS_CHANGED);
    }

    /** Команда від посередника: оновити схему під сеанс. */
    public void reloadFor(Session session) {
        Logger.log(name, "схему місць оновлено для сеансу " + session);
    }

    /** Команда від посередника: скинути вибір. */
    public void clearSelection() {
        selectedSeats.clear();
        Logger.log(name, "вибір місць скинуто");
    }

    public int getSelectedCount() {
        return selectedSeats.size();
    }
}
