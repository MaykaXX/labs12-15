package cinema13.command;

/** Роль у шаблоні: ConcreteCommand. */
public class AdsCommand implements Command {
    private final Hall hall;
    private boolean previous;

    public AdsCommand(Hall hall) { this.hall = hall; }

    public void execute() { previous = hall.isAdsPlaying(); hall.setAdsPlaying(true); }
    public void undo() { hall.setAdsPlaying(previous); }
    public String getName() { return "Запуск реклами"; }
}
