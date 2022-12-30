package exercise;

public final class Dog extends Animal {
    public void bite() {
        System.out.println("DOG: I bite.");
    }

    @Override
    public void go() {
        super.go();
        System.out.println("Dog: I go.");
    }

    @Override
    public void eat() {
        System.out.println("DOG: I eat.");
    }
}
