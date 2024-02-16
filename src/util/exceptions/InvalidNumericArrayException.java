package util.exceptions;

public class InvalidNumericArrayException extends IllegalArgumentException {
    public InvalidNumericArrayException() {
        super("Numeric array is invalid.");
    }
}
