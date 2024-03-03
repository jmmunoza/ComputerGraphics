package math.matrix;

import math.point.Point;
import math.point.Point3D;
import math.vector.Vector;
import math.vector.Vector3D;

public class Matrix3x3 extends SquareMatrix {
    private static final int MATRIX_SIZE = 3;

    public Matrix3x3(double[][] elements) {
        super(MATRIX_SIZE, elements);
    }

    public static Matrix3x3 transpose(Matrix3x3 A) {
        SquareMatrix matrix = SquareMatrix.transpose(A);

        return new Matrix3x3(matrix.elements);
    }

    public static Matrix3x3 times(Matrix3x3 A, Matrix3x3 B) {
        SquareMatrix matrix = SquareMatrix.times(A, B);

        return new Matrix3x3(matrix.elements);
    }

    public static Point3D times(Matrix3x3 A, Point3D p) {
        Point point = SquareMatrix.times(A, p);

        return new Point3D(point.coords);
    }

    public static Vector3D times(Matrix3x3 A, Vector3D v) {
        Vector vector = SquareMatrix.times(A, v);

        return new Vector3D(vector.components);
    }


    public static Matrix3x3 add(Matrix3x3 A, Matrix3x3 B) {
        SquareMatrix matrix = SquareMatrix.add(A, B);

        return new Matrix3x3(matrix.elements);
    }
}
