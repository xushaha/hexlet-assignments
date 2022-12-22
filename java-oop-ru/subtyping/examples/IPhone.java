package exercise;

public class IPhone implements Smartphoneable {
    @Override
    public void call() {
        System.out.println("[IPHONE]: Call via SIM card");
    }

    @Override
    public void music() {
        System.out.println("[IPHONE]: listen music via Yandex music");
    }

    @Override
    public void video() {
        System.out.println("[IPHONE]: watch video via Rutube");
    }

    @Override
    public void game() {
        System.out.println("[IPHONE]: play Mario game");
    }

    @Override
    public void charge() {
        System.out.println("[IPHONE]: I will charge for 30 mins");
    }
}
