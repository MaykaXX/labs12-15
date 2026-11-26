package cinema.iterator;

import java.util.ArrayList;
import java.util.List;

/** ConcreteIterator: усі сеанси в хронологічному порядку з усіх зал. */
public class ChronologicalIterator implements SessionIterator {
    private final List<Session> items;
    private int position = 0; // власна позиція кожного ітератора

    public ChronologicalIterator(Schedule schedule) {
        items = new ArrayList<>(schedule.flatten());
        items.sort((a, b) -> a.getSortKey().compareTo(b.getSortKey()));
    }

    @Override
    public boolean hasNext() { return position < items.size(); }

    @Override
    public Session next() { return items.get(position++); }
}
