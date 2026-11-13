package cinema12.bridge;

import cinema12.Log;

/** RefinedAbstraction: реклама партнера. */
public class PartnerAd extends Advertisement {
    private final String partner;

    public PartnerAd(String partner, AdMedium medium) {
        super(medium);
        this.partner = partner;
    }

    @Override
    public void show() {
        Log.log("PartnerAd", "Готую рекламу партнера «" + partner + "»");
        medium.display("Реклама партнера «" + partner + "»");
    }
}
