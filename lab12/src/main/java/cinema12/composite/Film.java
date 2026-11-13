package cinema12.composite;

import cinema12.Log;

/** Leaf: окремий фільм. */
public class Film implements ProgramItem {
    private final String name;
    private final int duration;

    public Film(String name, int duration) {
        this.name = name;
        this.duration = duration;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getDuration() {
        return duration;
    }

    @Override
    public int getFilmCount() {
        return 1;
    }

    @Override
    public void print(String indent) {
        Log.log("Program", indent + "Фільм \"" + name + "\" — " + duration + " хв");
    }
}
