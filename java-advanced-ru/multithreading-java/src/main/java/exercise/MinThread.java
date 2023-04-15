package exercise;

import java.util.Arrays;

// BEGIN
public class MinThread extends Thread {

    private int[] numbers;
    private int min;

    public MinThread (int[] numbers) {
        this.numbers = numbers;
    }

    public int getMin() {
        return min;
    }

    // В классе нужно переопределить метод run()
    // В методе содержится логика, которую поток будет выполнять
    @Override
    public void run() {
        Arrays.sort(numbers);
        this.min = numbers[0];
    }
}

// END
