package util.exceptions;

public class LinesMustBeNumericException extends IllegalArgumentException {
    public LinesMustBeNumericException() {
        super("Text lines must be numeric.");
    }
}
