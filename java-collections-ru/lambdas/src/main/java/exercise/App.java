package exercise;

import java.util.Arrays;

// BEGIN
public class App {

    public static String[] getSymbolTwoTimes(String symbol) {
            return new String[] {symbol, symbol};
    }
    public static String[][] getArrayTwoTimes(String[] doubleSymbol) {

            return new String[][] {doubleSymbol, doubleSymbol};
        }
    public static String[][] enlargeArrayImage(String[][] image) {

            String[][] doubleImage = Arrays.stream(image)
                    .flatMap(Arrays::stream)
                    .map(App::getSymbolTwoTimes)
                    .toArray(String[][]::new);

            String[][] enlargedImage = Arrays.stream(doubleImage)
                    .map(App::getArrayTwoTimes)
                    .toArray(String[][]::new);


            System.out.println(Arrays.deepToString(enlargedImage));
            return enlargedImage;
        }
}
// END
