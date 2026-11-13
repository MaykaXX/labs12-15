package cinema12.bridge;

import cinema12.Log;

/** RefinedAbstraction: соціальна реклама. */
public class SocialAd extends Advertisement {
    private final String message;

    public SocialAd(String message, AdMedium medium) {
        super(medium);
        this.message = message;
    }

    @Override
    public void show() {
        Log.log("SocialAd", "Готую соціальну рекламу: " + message);
        medium.display("Соціальна реклама: " + message);
    }
}