package main.java.lab15.strategy;

import main.java.lab15.Logger;

import java.util.Locale;

/** Код продажу: працює лише з Screening і не знає жодного конкретного правила. */
public class TicketOffice {
    public double sellTicket(Screening screening) {
        Logger.log("TicketOffice", "запит ціни квитка на сеанс «" + screening.getTitle() + "»");
        double price = screening.calculatePrice();
        Logger.log("TicketOffice", String.format(Locale.US, "ціна квитка: %.2f грн", price));
        return price;
    }
}
