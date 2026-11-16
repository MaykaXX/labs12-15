package cinema12.bridge;

import cinema12.Log;

public class TrailerAd extends Advertisement {
    private final String movie;

    public TrailerAd(String movie, AdMedium medium) {
        super(medium);
        this.movie = movie;
    }

    @Override
    public void show() {
        Log.log("TrailerAd", "Готую трейлер фільму «" + movie + "»");
        medium.display("Трейлер «" + movie + "»");
    }
}