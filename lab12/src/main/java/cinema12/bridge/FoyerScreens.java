package cinema12.bridge;

import cinema12.Log;

public class FoyerScreens implements AdMedium {
    @Override
    public void display(String content) {
        Log.log("FoyerScreens", "На екранах у фоє: " + content);
    }
}