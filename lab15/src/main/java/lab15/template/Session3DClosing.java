package main.java.lab15.template;

import main.java.lab15.Logger;

/** ConcreteClass: 3D-сеанс. Додає збір окулярів. */
public class Session3DClosing extends SessionClosing {
    public Session3DClosing(String title) { super(title); }

    @Override
    protected String getName() { return "Закриття 3D"; }

    @Override
    protected void collectGlasses() {
        Logger.log(getName(), "додатковий етап: зібрати 3D-окуляри");
    }
}