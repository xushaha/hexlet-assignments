package exercise;

import exercise.exception.CustomException;
import exercise.exception.CustomExceptions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Example {
    public static void main(String[] args) {
        // читаем из файла
        File file = new File("./exercises/errors/example.txt");
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            bufferedReader.lines()
                    .forEach(System.out::println);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

//        // приложение по переводу денег
//        String inputCard = "1234 5678 9012 3456";
//        String outputCard = "5678 9012 3456 7890";
//        double value = 100.21;
//        try {
//            transferMoney(inputCard, outputCard, value);
//        } catch (CustomException e) {
//            System.out.println(e.getErrorDescription());
//        }
    }

    private static void transferMoney(String inputCard, String outputCard, double value) throws CustomException {
        System.out.println("Transfer money from " + inputCard + " to " + outputCard + ": " + value);
        if (value < 0.01) {
            throw CustomExceptions.MONEY_VALUE_IS_INCORRECT;
        }
        if (isValidCardNumber(outputCard)) {
            System.out.println("SUCCESS");
        }
        throw CustomExceptions.INVALID_CARD_NUMBER;
    }

    private static boolean isValidCardNumber(String card) {
        System.out.println("Validate card: " + card);
        return false;
    }
}
