package main.java.kadr.mediator;

public record Session(String title, boolean is3D) {
    @Override
    public String toString() {
        return title + " (" + (is3D ? "3D" : "2D") + ")";
    }
}
