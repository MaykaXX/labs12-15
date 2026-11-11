package cinema12.flyweight;

import java.util.ArrayList;
import java.util.List;

/** Сеанс зі схемою зали. */
public class Session {
    private final int id;
    private final List<Seat> seats = new ArrayList<>();

    public Session(int id, int rows, int seatsPerRow) {
        this.id = id;
        for (int r = 1; r <= rows; r++) {
            String category = r > rows - 2 ? "VIP" : (r > rows * 0.6 ? "Комфорт" : "Стандарт");
            for (int n = 1; n <= seatsPerRow; n++) {
                seats.add(new Seat(r, n, SeatCategoryFactory.get(category)));
            }
        }
    }

    public int getId() {
        return id;
    }

    public List<Seat> getSeats() {
        return seats;
    }
}
