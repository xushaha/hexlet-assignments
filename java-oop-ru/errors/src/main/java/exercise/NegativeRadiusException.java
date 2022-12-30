package exercise;

// BEGIN
// Реализуйте класс исключения NegativeRadiusException, который наследуется от Exception, базового класса исключений.
public class NegativeRadiusException extends Exception {
    private String errorText;

    public NegativeRadiusException(String errorText) {
        this.errorText = errorText;
    }

    public String getErrorText() {
        return errorText;
    }

    public static final NegativeRadiusException INVALID_RADIUS =
        new NegativeRadiusException("Не удалось посчитать площадь");

}
// END
