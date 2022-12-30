package exercise.exception;

public class CustomException extends Exception {
    private static final String EXCEPTION_DESCRIPTION_FORMAT = "[%s]: %s";
    private String errorCode;

    public CustomException(String errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }
    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorDescription() {
        return String.format(EXCEPTION_DESCRIPTION_FORMAT, this.errorCode, this.getMessage());
    }
}
