package exercise;

public class Bmw implements Car {
    @Override
    public void go() {
        System.out.println("Разогналась до 100 км/ч за 4 секунды");
    }

    @Override
    public void stop() {
        System.out.println("Остановилась со скорости 60 км/ч за 3 секунды");
    }

    @Override
    public String getName() {
        return "BMW";
    }

    @Override
    public int getMaxSpeed() {
        return 360;
    }
}
