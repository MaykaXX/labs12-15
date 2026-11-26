package cinema.iterator;

import java.util.ArrayList;
import java.util.List;

/** Зала, в якій розклад зберігається по днях. */
public class Hall {
    private final String name;
    private final List<Day> days = new ArrayList<>();

    public Hall(String name) { this.name = name; }

    public String getName() { return name; }

    public void addDay(Day d) { days.add(d); }

    public List<Day> getDays() { return days; }
}
