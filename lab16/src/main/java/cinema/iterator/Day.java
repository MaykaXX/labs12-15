package cinema.iterator;

import java.util.ArrayList;
import java.util.List;

/** Розклад зали на один день. */
public class Day {
    private final String date;
    private final List<Session> sessions = new ArrayList<>();

    public Day(String date) { this.date = date; }

    public void addSession(Session s) { sessions.add(s); }

    public List<Session> getSessions() { return sessions; }
}
