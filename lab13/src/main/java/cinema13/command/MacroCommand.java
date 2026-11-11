package cinema13.command;

import java.util.List;

/** Роль у шаблоні: Composite Command (макрокоманда). */
public class MacroCommand implements Command {
    private final String name;
    private final List<Command> commands;

    public MacroCommand(String name, List<Command> commands) {
        this.name = name;
        this.commands = commands;
    }

    public void execute() {
        for (Command c : commands) c.execute();
    }

    public void undo() {
        for (int i = commands.size() - 1; i >= 0; i--) commands.get(i).undo();
    }

    public String getName() { return name; }
}
