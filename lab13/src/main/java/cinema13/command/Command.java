package cinema13.command;

/** Роль у шаблоні: Command. */
public interface Command {
    void execute();
    void undo();
    String getName();
}
