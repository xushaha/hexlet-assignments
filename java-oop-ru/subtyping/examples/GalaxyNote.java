package exercise;

public class GalaxyNote implements Smartphoneable {
    @Override
    public void call() {
        System.out.println("[GALAXY_NOTE]: Call via SIM card");
    }

    @Override
    public void music() {
        System.out.println("[GALAXY_NOTE]: listen music via Yandex music");
    }

    @Override
    public void video() {
        System.out.println("[GALAXY_NOTE]: watch video via Rutube");
    }

    @Override
    public void game() {
        System.out.println("[GALAXY_NOTE]: play Mario game");
    }

    @Override
    public void charge() {
        System.out.println("[GALAXY_NOTE]: I will charge for 30 mins");
    }
}
