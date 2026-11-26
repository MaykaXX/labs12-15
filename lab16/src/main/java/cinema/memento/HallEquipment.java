package cinema.memento;

import cinema.Log;

import java.util.Arrays;

/** Originator: обладнання зали. Стан закритий, гетерів на поля немає. */
public class HallEquipment {
    private int[] volume = {50, 50, 50};   // канали: лівий, центр, правий
    private int[] equalizer = {0, 0, 0};   // низькі, середні, високі
    private int brightness = 50;
    private int contrast = 50;

    public void setVolume(int left, int center, int right) {
        volume = new int[] {left, center, right};
    }

    public void setEqualizer(int low, int mid, int high) {
        equalizer = new int[] {low, mid, high};
    }

    public void setPicture(int brightness, int contrast) {
        this.brightness = brightness;
        this.contrast = contrast;
    }

    /** Створює знімок поточного стану. */
    public Snapshot save() {
        return new Snapshot(volume, equalizer, brightness, contrast);
    }

    /** Відновлює стан зі знімка. */
    public void restore(Snapshot s) {
        volume = s.volume.clone();
        equalizer = s.equalizer.clone();
        brightness = s.brightness;
        contrast = s.contrast;
    }

    public void print(String label) {
        Log.log("Зала", label + ": гучність=" + Arrays.toString(volume)
                + ", еквалайзер=" + Arrays.toString(equalizer)
                + ", яскравість=" + brightness + ", контраст=" + contrast);
    }

    /**
     * Memento: незмінний знімок. Усі поля й конструктор приватні,
     * тому прочитати його може лише HallEquipment.
     */
    public static final class Snapshot {
        private final int[] volume;
        private final int[] equalizer;
        private final int brightness;
        private final int contrast;

        private Snapshot(int[] volume, int[] equalizer, int brightness, int contrast) {
            this.volume = volume.clone();
            this.equalizer = equalizer.clone();
            this.brightness = brightness;
            this.contrast = contrast;
        }
    }
}