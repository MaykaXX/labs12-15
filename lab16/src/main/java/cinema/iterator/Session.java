package cinema.iterator;

/** Сеанс кінотеатру. */
public class Session {
    private final String movie;
    private final String hall;
    private final String date;   // наприклад 2026-11-26
    private final String time;   // наприклад 18:30
    private final int freeSeats;

    public Session(String movie, String hall, String date, String time, int freeSeats) {
        this.movie = movie;
        this.hall = hall;
        this.date = date;
        this.time = time;
        this.freeSeats = freeSeats;
    }

    public String getMovie() { return movie; }
    public String getHall() { return hall; }
    public String getDate() { return date; }
    public String getTime() { return time; }
    public int getFreeSeats() { return freeSeats; }

    /** Ключ для хронологічного порівняння. */
    public String getSortKey() { return date + " " + time; }

    @Override
    public String toString() {
        return date + " " + time + " | " + hall + " | " + movie + " | вільних місць: " + freeSeats;
    }
}
