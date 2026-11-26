package cinema.iterator;

import java.util.ArrayList;
import java.util.List;

/** ConcreteIterator: лише сеанси з вільними місцями (для касирів). */
public class FreeSeatsIterator implements SessionIterator {
    private final List<Session> items = new ArrayList<>();
    private int position = 0;

    public FreeSeatsIterator(Schedule schedule) {
        for (Session s : schedule.flatten()) {
            if (s.getFreeSeats() > 0) {
                items.add(s);
            }
        }
    }

    @Override
    public boolean hasNext() { return position < items.size(); }

    @Override
    public Session next() { return items.get(position++); }
}
