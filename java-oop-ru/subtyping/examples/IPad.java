package exercise;

public class IPad implements Smartphoneable {
    @Override
    public void call() {
        System.out.println("[IPAD]: Call via Viber");
    }

    @Override
    public void charge() {
        System.out.println("[IPAD]: I will charge for 1 hour");
    }

    @Override
    public void music() {
        System.out.println("[IPAD]: listen music via Apple music");
    }

    @Override
    public void video() {
        System.out.println("[IPAD]: watch video via Youtube");
    }

    @Override
    public void game() {
        System.out.println("[IPAD]: play game via Apple Arcade");
    }
}
