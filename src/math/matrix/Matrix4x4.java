package math.matrix;

import math.point.Point;
import math.point.Point4D;

public class Matrix4x4 extends SquareMatrix {
    private static final int MATRIX_SIZE = 4;

    public Matrix4x4(double[][] elements) {
        super(MATRIX_SIZE, elements);
    }

    public static Matrix4x4 transpose(Matrix4x4 A) {
        SquareMatrix matrix = SquareMatrix.transpose(A);

        return new Matrix4x4(matrix.elements);
    }

    public static Matrix4x4 times(Matrix4x4 A, Matrix4x4 B) {
        SquareMatrix matrix = SquareMatrix.times(A, B);

        return new Matrix4x4(matrix.elements);
    }

    public static Point4D times(Matrix4x4 A, Point4D p) {
        Point point = SquareMatrix.times(A, p);

        return new Point4D(point.coords);
    }

    public static Matrix4x4 add(Matrix4x4 A, Matrix4x4 B) {
        SquareMatrix matrix = SquareMatrix.add(A, B);

        return new Matrix4x4(matrix.elements);
    }
}
