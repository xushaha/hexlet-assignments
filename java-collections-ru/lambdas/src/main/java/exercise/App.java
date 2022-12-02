package exercise;

import java.util.Arrays;

// BEGIN
public class App {

    public static String[] getSymbolTwoTimes(String[] symbols) {
            return Arrays.stream(symbols)
                    .flatMap(symbol -> Arrays.stream(new String[] {symbol, symbol}))
                    .toArray(String[]::new);
    }

    public static String[][] enlargeArrayImage(String[][] image) {

            String[][] doubleImage = Arrays.stream(image)
                    .map(App::getSymbolTwoTimes)
                    .toArray(String[][]::new);


            return Arrays.stream(doubleImage)
                    .flatMap(symbol -> Arrays.stream(new String[][] {symbol, symbol}))
                    .toArray(String[][]::new);
        }
}
// END
