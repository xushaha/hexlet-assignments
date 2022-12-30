package exercise;

public class Frog extends Animal {

    public void jump() {
        System.out.println("FROG: I jump.");
    }

    @Override
    public void go() {
        super.go();
        System.out.println("FROG: I go.");
    }

    @Override
    public void eat() {
        System.out.println("FROG: I eat.");
    }
}
