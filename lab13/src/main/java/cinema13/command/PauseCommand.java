package cinema13.command;

/** Роль у шаблоні: ConcreteCommand. */
public class PauseCommand implements Command {
    private final Hall hall;
    private boolean previous;

    public PauseCommand(Hall hall) { this.hall = hall; }

    public void execute() { previous = hall.isPaused(); hall.setPaused(true); }
    public void undo() { hall.setPaused(previous); }
    public String getName() { return "Пауза"; }
}
