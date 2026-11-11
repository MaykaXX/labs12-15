package cinema.composite;

import cinema.Log;
import java.util.ArrayList;
import java.util.List;

/** Composite: збірка, блок, фестиваль — будь-яка група елементів програми. */
public class ProgramGroup implements ProgramItem {
    private final String name;
    private final List<ProgramItem> children = new ArrayList<>();

    public ProgramGroup(String name) {
        this.name = name;
    }

    public ProgramGroup add(ProgramItem item) {
        children.add(item);
        Log.log("Program", "\"" + name + "\" ← додано \"" + item.getName() + "\"");
        return this;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getDuration() {
        int sum = 0;
        for (ProgramItem c : children) {
            sum += c.getDuration();
        }
        return sum;
    }

    @Override
    public int getFilmCount() {
        int sum = 0;
        for (ProgramItem c : children) {
            sum += c.getFilmCount();
        }
        return sum;
    }

    @Override
    public void print(String indent) {
        Log.log("Program", indent + "[" + name + "] — " + getDuration() + " хв, фільмів: " + getFilmCount());
        for (ProgramItem c : children) {
            c.print(indent + "    ");
        }
    }
}
