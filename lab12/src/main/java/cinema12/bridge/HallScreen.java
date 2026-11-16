package cinema12.bridge;

import cinema12.Log;

public class HallScreen implements AdMedium {
    @Override
    public void display(String content) {
        Log.log("HallScreen", "На великому екрані зали: " + content);
    }
}