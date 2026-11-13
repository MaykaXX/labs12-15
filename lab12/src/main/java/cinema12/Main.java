package cinema12;

import cinema12.bridge.Advertisement;
import cinema12.bridge.FoyerScreens;
import cinema12.bridge.HallScreen;
import cinema12.bridge.LedFacade;
import cinema12.bridge.MobileApp;
import cinema12.bridge.PartnerAd;
import cinema12.bridge.SocialAd;
import cinema12.bridge.Trailerad;
import cinema12.composite.Film;
import cinema12.composite.ProgramGroup;
import cinema12.flyweight.Seat;
import cinema12.flyweight.SeatCategoryFactory;
import cinema12.flyweight.Session;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        situation1Composite();
        situation2Flyweight();
        situation3Bridge();
    }

    private static void situation1Composite() {
        Log.log("Runner", "=== Ситуація 1: програма кінофестивалю (Composite) ===");

        ProgramGroup shorts = new ProgramGroup("Збірка короткометражок");
        shorts.add(new Film("Світанок", 12)).add(new Film("Місто", 18)).add(new Film("Лист", 9));

        ProgramGroup block1 = new ProgramGroup("Блок «Драма»");
        block1.add(new Film("Тиша", 105)).add(new Film("Межа", 98)).add(shorts);

        ProgramGroup block2 = new ProgramGroup("Блок «Комедія»");
        block2.add(new Film("Сусіди", 90)).add(new Film("Відпустка", 85));

        ProgramGroup festival = new ProgramGroup("Фестиваль «Кадр»");
        festival.add(block1).add(block2);

        festival.print("");

        Log.log("Runner", "Тривалість фестивалю: " + festival.getDuration() + " хв");
        Log.log("Runner", "Тривалість блоку «Драма»: " + block1.getDuration() + " хв");
    }

    private static void situation2Flyweight() {
        System.out.println();
        Log.log("Runner", "=== Ситуація 2: схема місць на сеансах (Flyweight) ===");

        int[][] halls = {{15, 10}, {20, 10}, {25, 10}, {30, 10}}; // 150, 200, 250, 300 місць
        List<Session> sessions = new ArrayList<>();
        long seatCount = 0;
        for (int i = 1; i <= 200; i++) {
            int[] hall = halls[i % 4];
            Session s = new Session(i, hall[0], hall[1]);
            sessions.add(s);
            seatCount += s.getSeats().size();
        }

        Log.log("Runner", "Сеансів: " + sessions.size() + ", об'єктів місць: " + seatCount);
        Log.log("Runner", "Об'єктів категорій: " + SeatCategoryFactory.getCreatedCount());

        Seat vip1 = lastSeat(sessions.get(0));
        Seat vip2 = lastSeat(sessions.get(199));
        vip2.sell();
        Log.log("Runner", "Сеанс 1: " + vip1);
        Log.log("Runner", "Сеанс 200: " + vip2);
        Log.log("Runner", "Той самий об'єкт категорії: " + (vip1.getCategory() == vip2.getCategory()));
    }

    private static Seat lastSeat(Session s) {
        return s.getSeats().get(s.getSeats().size() - 1); // останній ряд — VIP
    }

    private static void situation3Bridge() {
        System.out.println();
        Log.log("Runner", "=== Ситуація 3: реклама перед сеансом (Bridge) ===");

        HallScreen hallScreen = new HallScreen();
        FoyerScreens foyerScreens = new FoyerScreens();
        MobileApp mobileApp = new MobileApp();

        // 1) Один вид реклами (трейлер) на двох різних носіях
        Log.log("Runner", "--- Трейлер на екрані зали і на екранах у фоє ---");
        Advertisement trailerInHall = new Trailerad("Дюна", hallScreen);
        Advertisement trailerInFoyer = new Trailerad("Дюна", foyerScreens);
        trailerInHall.show();
        trailerInFoyer.show();

        // 2) Соціальна реклама в мобільному застосунку
        Log.log("Runner", "--- Соціальна реклама в мобільному застосунку ---");
        new SocialAd("Бережіть природу", mobileApp).show();

        // 3) Новий носій одним класом (LedFacade) і реклама партнера на ньому
        Log.log("Runner", "--- Новий носій «світлодіодний фасад» + реклама партнера ---");
        new PartnerAd("Кав'ярня «Зерно»", new LedFacade()).show();
    }
}