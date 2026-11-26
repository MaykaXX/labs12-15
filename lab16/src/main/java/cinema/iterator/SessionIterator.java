package cinema.iterator;

/** Iterator: загальний інтерфейс обходу сеансів. */
public interface SessionIterator {
    boolean hasNext();
    Session next();
}
