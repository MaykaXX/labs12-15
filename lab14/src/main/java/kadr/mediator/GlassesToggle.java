package main.java.kadr.mediator;

import kadr.Logger;

public class GlassesToggle extends FormElement {
    private boolean visible = false;

    public GlassesToggle() {
        super("GlassesToggle");
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
        Logger.log(name, visible ? "перемикач «3D-окуляри» показано" : "перемикач «3D-окуляри» сховано");
    }

    public boolean isVisible() {
        return visible;
    }
}
