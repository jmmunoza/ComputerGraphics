package util.exceptions;

public class InvalidMatrixSizeException extends IllegalArgumentException {
    public InvalidMatrixSizeException(int size) {
        super(String.format("Matrix must be %sx%s ", size, size));
    }
}
