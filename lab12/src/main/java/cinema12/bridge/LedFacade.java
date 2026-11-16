package cinema12.bridge;

import cinema12.Log;

public class LedFacade implements AdMedium {
    @Override
    public void display(String content) {
        Log.log("LedFacade", "На світлодіодному фасаді будівлі: " + content);
    }
}