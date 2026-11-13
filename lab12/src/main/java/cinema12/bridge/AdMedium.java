package cinema12.bridge;

/** Implementor: носій реклами. Знає лише ЯК показати готовий текст. */
public interface AdMedium {
    void display(String content);
}