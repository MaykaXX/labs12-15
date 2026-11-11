package cinema12;

public final class Log {
    private static int minutes = 9 * 60;

    private Log() {}

    public static void log(String source, String event) {
        minutes++;
        System.out.printf("[%02d:%02d] [%s] %s%n", minutes / 60 % 24, minutes % 60, source, event);
    }
}
