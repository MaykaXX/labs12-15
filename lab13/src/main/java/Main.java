import cinema13.Log;
import cinema13.command.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        volumeUndo();
        sessionStart();
        emergency();
    }

    private static void volumeUndo() {
        System.out.println("\n=== Зміна гучності і скасування ===");
        Hall hall = new Hall();
        Operator operator = new Operator();
        operator.run(new VolumeCommand(hall, 0));
        operator.undoLast();
        Log.log("Main", "Гучність після скасування: " + hall.getVolume());
    }

    private static void sessionStart() {
        System.out.println("\n=== Набір «Початок сеансу» ===");
        Hall hall = new Hall();
        Operator operator = new Operator();
        operator.run(new MacroCommand("Початок сеансу", List.of(
                new LightCommand(hall, false),
                new VolumeCommand(hall, 40),
                new AdsCommand(hall))));
    }

    private static void emergency() {
        System.out.println("\n=== Набір «Аварійна ситуація» ===");
        Hall hall = new Hall();
        Operator operator = new Operator();
        operator.run(new MacroCommand("Аварійна ситуація", List.of(
                new PauseCommand(hall),
                new LightCommand(hall, true),
                new VolumeCommand(hall, 20))));
        operator.printJournal();
    }
}
