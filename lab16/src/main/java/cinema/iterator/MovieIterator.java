package cinema.iterator;

import java.util.ArrayList;
import java.util.List;

/** ConcreteIterator: лише сеанси конкретного фільму. */
public class MovieIterator implements SessionIterator {
    private final List<Session> items = new ArrayList<>();
    private int position = 0;

    public MovieIterator(Schedule schedule, String movie) {
        for (Session s : schedule.flatten()) {
            if (s.getMovie().equals(movie)) {
                items.add(s);
            }
        }
    }

    @Override
    public boolean hasNext() { return position < items.size(); }

    @Override
    public Session next() { return items.get(position++); }
}
