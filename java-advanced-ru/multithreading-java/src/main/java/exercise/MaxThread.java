package exercise;

import java.util.Arrays;

// BEGIN
public class MaxThread extends Thread {

    private static int[] numbers;
    private int max;

    public MaxThread (int[] numbers) {
        this.numbers = numbers;
    }

    public int getMax() {
        return max;
    }

    @Override
    public void run() {
        Arrays.sort(numbers);
        this.max = numbers[numbers.length - 1];
    }
}

// END

/*
    Исходные данные (массив с числами) можно передать в конструктор при создании экземпляра потока
    Чтобы удобно получить результат работы потока, можно создать геттер
*/

/* Создайте поток, который будет находить максимальное число в массиве целых чисел.
Класс потока унаследуйте от класса java.lang.Thread. Переопределите в классе метод run(),
в котором напишите логику поиска максимального числа в массиве. */