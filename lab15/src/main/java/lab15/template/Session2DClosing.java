package main.java.lab15.template;

/** ConcreteClass: 2D-сеанс. Додаткових етапів немає, використовуються лише базові. */
public class Session2DClosing extends SessionClosing {
    public Session2DClosing(String title) { super(title); }

    @Override
    protected String getName() { return "Закриття 2D"; }
}