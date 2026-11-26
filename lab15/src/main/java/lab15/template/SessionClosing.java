package main.java.lab15.template;

import main.java.lab15.Logger;

/**
 * Він final, тому види сеансів не можуть змінити порядок. Вони лише додають свої етапи через хуки.
 */
public abstract class SessionClosing {
    protected final String title;

    protected SessionClosing(String title) {
        this.title = title;
    }

    public final void close() {
        Logger.log(getName(), "=== закриття сеансу «" + title + "» ===");
        turnOnLights();
        releaseAudience();
        checkHall();
        collectGlasses();   // хук: лише 3D
        replaceBlankets();  // хук: VIP
        collectDishes();    // хук: VIP
        cleanUp();
        prepareForNext();
        buildReport();
    }

    protected abstract String getName();

    // ---- обов'язкові етапи
    private void turnOnLights() { Logger.log(getName(), "етап: увімкнути світло"); }

    private void releaseAudience() { Logger.log(getName(), "етап: випустити глядачів"); }

    private void checkHall() { Logger.log(getName(), "етап: перевірити зал"); }

    private void cleanUp() { Logger.log(getName(), "етап: прибрати зал"); }

    private void prepareForNext() { Logger.log(getName(), "етап: підготувати зал до наступного сеансу"); }

    /** Звіт формується однаково для всіх, тому метод private і не перевизначається. */
    private void buildReport() {
        Logger.log(getName(), "етап: сформовано звіт по сеансу «" + title + "» (єдиний формат)");
    }

    // ---- необов'язкові етапи (хуки)
    protected void collectGlasses() { }

    protected void replaceBlankets() { }

    protected void collectDishes() { }
}