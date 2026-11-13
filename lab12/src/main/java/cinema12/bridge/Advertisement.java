package cinema12.bridge;

/** Abstraction: вид реклами. Знає ЩО показувати, а показ делегує носію (це і є «міст»). */
public abstract class Advertisement {
    protected final AdMedium medium;

    protected Advertisement(AdMedium medium) {
        this.medium = medium;
    }

    public abstract void show();
}