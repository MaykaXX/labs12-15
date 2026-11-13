package cinema12.bridge;

import cinema12.Log;

/** RefinedAbstraction: трейлер. */
public class Trailerad extends Advertisement {
    private final String movie;

    public Trailerad(String movie, AdMedium medium) {
        super(medium);
        this.movie = movie;
    }

    @Override
    public void show() {
        Log.log("TrailerAd", "Готую трейлер фільму «" + movie + "»");
        medium.display("Трейлер «" + movie + "»");
    }
}