package components.canvas.factories;

import math.matrix.Matrix3x3;

public class TransformationMatrixFactory {
    public static Matrix3x3 rotationClockwise(double radians) {
        return new Matrix3x3(new double[][]{
                {Math.cos(radians), Math.sin(radians), 0},
                {-Math.sin(radians), Math.cos(radians), 0},
                {0, 0, 1}
        });
    }

    public static Matrix3x3 rotationAnticlockwise(double radians) {
        return new Matrix3x3(new double[][]{
                {Math.cos(radians), -Math.sin(radians), 0},
                {Math.sin(radians), Math.cos(radians), 0},
                {0, 0, 1}
        });
    }

    public static Matrix3x3 translation(double dx, double dy) {
        return new Matrix3x3(new double[][]{
                {1, 0, dx},
                {0, 1, dy},
                {0, 0, 1}
        });
    }

    public static Matrix3x3 scalingZoom(double sx, double sy) {
        return new Matrix3x3(new double[][]{
                {sx, 0, 0},
                {0, sy, 0},
                {0, 0, 1}
        });
    }

    public static Matrix3x3 scalingZoomOut(double sx, double sy) {
        return new Matrix3x3(new double[][]{
                {1 / sx, 0, 0},
                {0, 1 / sy, 0},
                {0, 0, 1}
        });
    }
}
