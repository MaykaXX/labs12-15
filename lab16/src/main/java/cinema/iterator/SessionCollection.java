package cinema.iterator;

/** Aggregate: колекція, що вміє створювати ітератори. */
public interface SessionCollection {
    SessionIterator createChronologicalIterator();
    SessionIterator createMovieIterator(String movie);
    SessionIterator createFreeSeatsIterator();
}
