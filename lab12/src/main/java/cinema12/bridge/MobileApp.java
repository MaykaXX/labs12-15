package cinema12.bridge;

import cinema12.Log;

public class MobileApp implements AdMedium {
    @Override
    public void display(String content) {
        Log.log("MobileApp", "Push-банер у мобільному застосунку: " + content);
    }
}