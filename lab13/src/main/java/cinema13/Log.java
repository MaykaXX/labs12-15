package cinema13;

import java.time.LocalTime;

/** Консольний журнал у форматі [час] [джерело] подія. Час умовний. */
public final class Log {
    private static LocalTime time = LocalTime.of(18, 0);

    private Log() {}

    public static String now() {
        time = time.plusSeconds(10);
        return time.toString();
    }

    public static void log(String source, String event) {
        System.out.println("[" + now() + "] [" + source + "] " + event);
    }
}
