package cinema12.composite;

public interface ProgramItem {
    String getName();

    int getDuration();

    int getFilmCount();

    void print(String indent);
}
