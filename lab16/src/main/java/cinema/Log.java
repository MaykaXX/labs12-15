package cinema;

/** Простий журнал: [час] [джерело] подія. Час умовний (лічильник). */
public class Log {
    private static int tick = 0;

    public static void log(String source, String event) {
        tick++;
        System.out.println("[T" + String.format("%02d", tick) + "] [" + source + "] " + event);
    }

    /** Форматування грошей: 2 знаки після крапки. */
    public static String money(double value) {
        return String.format(java.util.Locale.US, "%.2f", value) + " грн";
    }
}
