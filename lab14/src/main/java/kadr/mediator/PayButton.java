package main.java.kadr.mediator;

import kadr.Logger;

public class PayButton extends FormElement {
    private boolean enabled = false;

    public PayButton() {
        super("PayButton");
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
        Logger.log(name, enabled ? "кнопку оплати активовано" : "кнопку оплати деактивовано");
    }

    public boolean isEnabled() {
        return enabled;
    }
}
