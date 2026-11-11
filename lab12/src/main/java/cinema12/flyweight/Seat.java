package cinema12.flyweight;

/** Context: місце зберігає лише власні (зовнішні) дані й посилання на flyweight. */
public class Seat {
    private final int row;
    private final int number;
    private boolean sold;
    private final SeatCategory category;

    public Seat(int row, int number, SeatCategory category) {
        this.row = row;
        this.number = number;
        this.category = category;
    }

    public SeatCategory getCategory() {
        return category;
    }

    public void sell() {
        sold = true;
    }

    @Override
    public String toString() {
        return "Місце ряд " + row + ", №" + number + ", " + (sold ? "продано" : "вільне")
                + ", категорія: " + category;
    }
}
