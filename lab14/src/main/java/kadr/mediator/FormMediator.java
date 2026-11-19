package main.java.kadr.mediator;

/** Mediator: єдина точка, через яку елементи форми повідомляють про зміни. */
public interface FormMediator {
    void notify(FormElement sender, FormEvent event);
}
