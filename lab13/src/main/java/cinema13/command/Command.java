package cinema13.command;

public interface Command {
    void execute();
    void undo();
    String getName();
}
