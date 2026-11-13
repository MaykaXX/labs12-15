package cinema12.bridge;

import cinema12.Log;

/** ConcreteImplementor: світлодіодний фасад. Новий носій = один новий клас, решта коду не змінюється. */
public class LedFacade implements AdMedium {
    @Override
    public void display(String content) {
        Log.log("LedFacade", "На світлодіодному фасаді будівлі: " + content);
    }
}