package exercise;

public class GEntry<T> {
    private int value1;
    private T value2;

    public GEntry(int value1, T value2) {
        this.value1 = value1;
        this.value2 = value2;
    }

    public int getValue1() {
        return value1;
    }

    public T getValue2() {
        return value2;
    }
}
