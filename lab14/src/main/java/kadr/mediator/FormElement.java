package main.java.kadr.mediator;

/** Colleague: базовий елемент форми, знає лише посередника. */
public abstract class FormElement {
    protected final String name;
    protected FormMediator mediator;

    protected FormElement(String name) {
        this.name = name;
    }

    public void setMediator(FormMediator mediator) {
        this.mediator = mediator;
    }

    public String getName() {
        return name;
    }
}
