package cinema13.command;


import cinema13.Log;

/** Роль у шаблоні: Receiver (обладнання зали). */
public class Hall {
    private boolean lightOn = false;
    private int volume = 50;
    private boolean paused = false;
    private boolean adsPlaying = false;

    public boolean isLightOn() { return lightOn; }
    public int getVolume() { return volume; }
    public boolean isPaused() { return paused; }
    public boolean isAdsPlaying() { return adsPlaying; }

    public void setLightOn(boolean on) {
        lightOn = on;
        Log.log("Зала", "Світло " + (on ? "увімкнено" : "вимкнено"));
    }

    public void setVolume(int v) {
        volume = v;
        Log.log("Зала", "Гучність: " + v);
    }

    public void setPaused(boolean p) {
        paused = p;
        Log.log("Зала", "Показ " + (p ? "на паузі" : "відновлено"));
    }

    public void setAdsPlaying(boolean a) {
        adsPlaying = a;
        Log.log("Зала", "Реклама " + (a ? "запущена" : "зупинена"));
    }
}
