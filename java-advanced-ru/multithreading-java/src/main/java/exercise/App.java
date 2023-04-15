package exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;
import java.util.logging.Level;

class App {
    private static final Logger LOGGER = Logger.getLogger("AppLogger");

    // BEGIN
    public static Map<String, Integer> getMinMax(int[] numbers) {

        MaxThread maxThread = new MaxThread(numbers);
        MinThread minThread = new MinThread(numbers);

        maxThread.start();
        minThread.start();

        try {
            minThread.join();
        } catch (InterruptedException e) {
            System.out.println("Поток был прерван");
        }


        try {
            maxThread.join();
        } catch (InterruptedException e) {
            System.out.println("Поток был прерван");
        }


        LOGGER.info("Thread " + maxThread.getName() + " started");
        LOGGER.info("Thread " + minThread.getName() + " started");

        Map<String, Integer> result = new HashMap<>();
        result.put("min", minThread.getMin());
        result.put("max", maxThread.getMax());

        LOGGER.info("Thread " + maxThread.getName() + " finished");
        LOGGER.info("Thread " + minThread.getName() + " finished");

        return result;
    }
    // END
}


/*
    В классе создайте публичный статический метод getMinMax().
    Метод принимает в качестве аргумента массив целых чисел.
    Условимся, что массив содержит минимум один элемент.
    Метод должен возвращать максимальный и минимальный элемент массива в виде словаря Map<String, Integer>:

  int[] numbers = {10, -4, 67, 100, -100, 8};

  System.out.println(App.getMinMax(numbers)); // => {min=-100, max=100}

Реализуйте метод так, чтобы вычисления производились в два потока. Первый поток ищет максимальное число в массиве,
второй – минимальное. Используйте для этого созданные классы потоков.

Чтобы наглядно отследить старт и окончание работы потока, добавьте в метод логгирование.
Пример вывода лога:
  INFO: Thread Thread-3 started
  INFO: Thread Thread-3 finished

*/