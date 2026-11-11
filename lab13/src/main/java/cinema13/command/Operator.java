package cinema13.command;

import cinema13.Log;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/** Роль у шаблоні: Invoker (оператор зали). */
public class Operator {
    private final Deque<Command> history = new ArrayDeque<>();
    private final List<String> journal = new ArrayList<>();

    public void run(Command command) {
        Log.log("Оператор", "Виконує: " + command.getName());
        command.execute();
        history.push(command);
        journal.add("[" + Log.now() + "] Виконано: " + command.getName());
    }

    public void undoLast() {
        if (history.isEmpty()) {
            Log.log("Оператор", "Немає команд для скасування");
            return;
        }
        Command command = history.pop();
        Log.log("Оператор", "Скасовує: " + command.getName());
        command.undo();
        journal.add("[" + Log.now() + "] Скасовано: " + command.getName());
    }

    public void printJournal() {
        System.out.println("--- Журнал команд ---");
        journal.forEach(System.out::println);
    }
}
