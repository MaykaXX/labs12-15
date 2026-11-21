package kadr;

/** Консольний журнал подій у форматі [час] [джерело] подія. */
public final class Logger {
    private static int seconds = 0;

    private Logger() {}

    public static void log(String source, String event) {
        seconds++;
        System.out.printf("[19:00:%02d] [%s] %s%n", seconds, source, event);
    }
}