package cinema.composite;

/** Component: спільний інтерфейс для фільму та будь-якої групи. */
public interface ProgramItem {
    String getName();

    int getDuration();

    int getFilmCount();

    void print(String indent);
}
