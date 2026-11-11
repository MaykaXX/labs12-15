package cinema12.flyweight;

import cinema13.Log;
import java.util.HashMap;
import java.util.Map;

/** FlyweightFactory: створює категорію лише при першому запиті. */
public class SeatCategoryFactory {
    private static final Map<String, SeatCategory> CACHE = new HashMap<>();

    private SeatCategoryFactory() {}

    public static SeatCategory get(String name) {
        SeatCategory category = CACHE.get(name);
        if (category == null) {
            category = create(name);
            CACHE.put(name, category);
            Log.log("Factory", "Створено об'єкт категорії " + name);
        }
        return category;
    }

    public static int getCreatedCount() {
        return CACHE.size();
    }

    private static SeatCategory create(String name) {
        switch (name) {
            case "Стандарт":
                return new SeatCategory(name, "звичайне крісло", 45, "S.png", 120);
            case "Комфорт":
                return new SeatCategory(name, "широке крісло з підлокітниками", 55, "C.png", 180);
            case "VIP":
                return new SeatCategory(name, "шкіряний диван-реклайнер", 70, "V.png", 300);
            default:
                throw new IllegalArgumentException("Невідома категорія: " + name);
        }
    }
}
