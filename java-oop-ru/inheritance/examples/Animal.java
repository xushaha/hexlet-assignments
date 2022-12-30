package exercise;

public abstract class Animal {
    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void go() {
        System.out.println("I wake up.");
    }

    private void die() {
        System.out.println("ANIMAL: I die.");
    }

    void born() {
        System.out.println("ANIMAL: I have been born.");
    }

    public abstract void eat();
}
