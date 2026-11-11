package cinema13.command;

/** Роль у шаблоні: ConcreteCommand. */
public class VolumeCommand implements Command {
    private final Hall hall;
    private final int volume;
    private int previous;

    public VolumeCommand(Hall hall, int volume) {
        this.hall = hall;
        this.volume = volume;
    }

    public void execute() { previous = hall.getVolume(); hall.setVolume(volume); }
    public void undo() { hall.setVolume(previous); }
    public String getName() { return "Гучність " + volume; }
}
