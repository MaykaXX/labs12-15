package cinema.memento;

import cinema.Log;

import java.util.HashMap;
import java.util.Map;

/** Caretaker: зберігає іменовані знімки, але не бачить і не змінює їхній вміст. */
public class SettingsHistory {
    private final Map<String, HallEquipment.Snapshot> snapshots = new HashMap<>();

    public void save(String name, HallEquipment.Snapshot snapshot) {
        snapshots.put(name, snapshot);
        Log.log("Історія", "збережено налаштування '" + name + "'");
    }

    public HallEquipment.Snapshot get(String name) {
        HallEquipment.Snapshot snapshot = snapshots.get(name);
        if (snapshot == null) {
            throw new IllegalArgumentException("Немає налаштування: " + name);
        }
        Log.log("Історія", "видано налаштування '" + name + "'");
        return snapshot;
    }
}