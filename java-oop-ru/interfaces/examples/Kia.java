package exercise;

public class Kia implements Car {
    @Override
    public void go() {
        System.out.println("Разогналась до 100 км/ч за 12 секнуд");
    }

    @Override
    public void stop() {
        System.out.println("Остановилась со скорости 60 км/ч за 8 секнуд");
    }

    @Override
    public String getName() {
        return "KIA";
    }

    @Override
    public int getMaxSpeed() {
        return 220;
    }
}
