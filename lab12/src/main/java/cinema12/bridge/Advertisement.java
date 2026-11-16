package cinema12.bridge;

/** Знає ЩО показувати, а показ делегує носію. */
public abstract class Advertisement {
    protected final AdMedium medium;

    protected Advertisement(AdMedium medium) {
        this.medium = medium;
    }

    public abstract void show();
}