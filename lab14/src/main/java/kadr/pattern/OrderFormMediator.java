package kadr.pattern;

import kadr.Logger;
import kadr.domain.GlassesToggle;
import kadr.domain.PayButton;
import kadr.domain.SeatMap;
import kadr.domain.Session;
import kadr.domain.SessionSelector;

/** ConcreteMediator: усі правила взаємодії елементів форми зібрані тут. */
public class OrderFormMediator implements FormMediator {
    private final SessionSelector sessionSelector;
    private final SeatMap seatMap;
    private final GlassesToggle glassesToggle;
    private final PayButton payButton;

    public OrderFormMediator(SessionSelector sessionSelector, SeatMap seatMap,
                             GlassesToggle glassesToggle, PayButton payButton) {
        this.sessionSelector = sessionSelector;
        this.seatMap = seatMap;
        this.glassesToggle = glassesToggle;
        this.payButton = payButton;
        sessionSelector.setMediator(this);
        seatMap.setMediator(this);
        glassesToggle.setMediator(this);
        payButton.setMediator(this);
    }

    @Override
    public void notify(FormElement sender, FormEvent event) {
        Logger.log("OrderFormMediator", "отримано " + event + " від " + sender.getName());
        switch (event) {
            case SESSION_CHANGED -> {
                Session session = sessionSelector.getSelected();
                seatMap.reloadFor(session);
                glassesToggle.setVisible(session.is3D());
                if (seatMap.getSelectedCount() > 0) {
                    seatMap.clearSelection();
                }
                payButton.setEnabled(false);
            }
            case SEATS_CHANGED -> payButton.setEnabled(seatMap.getSelectedCount() > 0);
        }
    }
}
