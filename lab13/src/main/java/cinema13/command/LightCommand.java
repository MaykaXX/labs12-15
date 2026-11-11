package cinema13.command;

/** Роль у шаблоні: ConcreteCommand. */
public class LightCommand implements Command {
    private final Hall hall;
    private final boolean on;
    private boolean previous;

    public LightCommand(Hall hall, boolean on) {
        this.hall = hall;
        this.on = on;
    }

    public void execute() { previous = hall.isLightOn(); hall.setLightOn(on); }
    public void undo() { hall.setLightOn(previous); }
    public String getName() { return "Світло " + (on ? "ON" : "OFF"); }
}
