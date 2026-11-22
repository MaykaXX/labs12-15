package main.java.lab15.template;

import main.java.lab15.Logger;

/** ConcreteClass: VIP-сеанс. Додає заміну пледів і збір посуду. */
public class SessionVipClosing extends SessionClosing {
    public SessionVipClosing(String title) { super(title); }

    @Override
    protected String getName() { return "Закриття VIP"; }

    @Override
    protected void replaceBlankets() {
        Logger.log(getName(), "додатковий етап: замінити пледи");
    }

    @Override
    protected void collectDishes() {
        Logger.log(getName(), "додатковий етап: зібрати посуд");
    }
}