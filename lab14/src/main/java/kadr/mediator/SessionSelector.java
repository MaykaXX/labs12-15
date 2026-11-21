package main.java.kadr.mediator;

import kadr.Logger;

public class SessionSelector extends FormElement {
    private Session selected;

    public SessionSelector() {
        super("SessionSelector");
    }

    public void select(Session session) {
        this.selected = session;
        Logger.log(name, "користувач обрав сеанс " + session);
        mediator.notify(this, FormEvent.SESSION_CHANGED);
    }

    public Session getSelected() {
        return selected;
    }
}