package math.matrix;

import math.point.Point;
import math.vector.Vector;
import util.exceptions.InvalidMatrixSizeException;

public class SquareMatrix {
    private final int matrixSize;
    public double[][] elements;

    protected SquareMatrix(int matrixSize, double[][] elements) {
        if (!isMatrixSizeValid(matrixSize, elements))
            throw new InvalidMatrixSizeException(matrixSize);

        this.matrixSize = matrixSize;
        this.elements = elements;
    }

    protected static SquareMatrix transpose(SquareMatrix A) {
        double[][] transposedElements = new double[A.matrixSize][A.matrixSize];

        for (int row = 0; row < A.matrixSize; row++) {
            for (int col = 0; col < A.matrixSize; col++) {
                transposedElements[row][col] = A.elements[col][row];
            }
        }

        return new SquareMatrix(A.matrixSize, transposedElements);
    }

    protected static Point times(SquareMatrix A, Point p) {
        double[] timedElements = new double[A.matrixSize];
        double[] B = p.coords;

        for (int row = 0; row < A.matrixSize; row++) {
            for (int col = 0; col < A.matrixSize; col++) {
                double element = 0;

                for (int i = 0; i < A.matrixSize; i++) {
                    element += A.elements[row][i] * B[i];
                }

                timedElements[row] = element;
            }
        }

        return new Point(A.matrixSize, timedElements);
    }

    protected static Vector times(SquareMatrix A, Vector v) {
        Point p = new Point(v.components.length, v.components);

        Point result = times(A, p);

        return new Vector(v.components.length, result.coords);
    }

    protected static SquareMatrix times(SquareMatrix A, SquareMatrix B) {
        double[][] timedElements = new double[A.matrixSize][A.matrixSize];

        for (int row = 0; row < A.matrixSize; row++) {
            for (int col = 0; col < A.matrixSize; col++) {
                double element = 0;

                for (int i = 0; i < A.matrixSize; i++) {
                    element += A.elements[row][i] * B.elements[i][col];
                }

                timedElements[row][col] = element;
            }
        }

        return new SquareMatrix(A.matrixSize, timedElements);
    }

    private static boolean isMatrixSizeValid(int matrixSize, double[][] elements) {
        if (elements.length != matrixSize) return false;

        for (double[] row : elements) {
            if (row.length != matrixSize) return false;
        }

        return true;
    }

    protected static SquareMatrix add(SquareMatrix A, SquareMatrix B) {
        double[][] addedElements = new double[A.matrixSize][A.matrixSize];

        for (int row = 0; row < A.matrixSize; row++) {
            for (int col = 0; col < A.matrixSize; col++) {
                addedElements[row][col] = A.elements[row][col] + B.elements[row][col];
            }
        }

        return new SquareMatrix(A.matrixSize, addedElements);
    }

    protected void transpose() {
        SquareMatrix transposedMatrix = transpose(this);

        this.elements = transposedMatrix.elements;
    }

    @Override
    public String toString() {
        StringBuilder matrixString = new StringBuilder();

        for (int row = 0; row < matrixSize; row++) {
            matrixString.append("| ");
            for (int col = 0; col < matrixSize; col++) {
                matrixString.append(elements[row][col]).append(" | ");
            }
            matrixString.append("\n");
        }

        return matrixString.toString();
    }
}
