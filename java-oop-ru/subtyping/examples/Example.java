package exercise;

import java.util.List;

public class Example {
    public static void main(String[] args) {
        Device ipad = new IPad();
        Device iphone = new IPhone();
        Device galaxyNote = new GalaxyNote();

        for (Device device: List.of(ipad, iphone, galaxyNote)) {
            device.game();
        }

        // 1
        List.of(ipad, iphone, galaxyNote).stream()
                .filter(device -> device instanceof Smartphoneable)
                .map(device -> (Smartphoneable) device)
                .forEach(Smartphoneable::call);

        //2
        for (Device device: List.of(ipad, iphone)) {
            if (device instanceof Smartphoneable) {
                ((Smartphoneable) device).call();
            }

        }

    }
}
