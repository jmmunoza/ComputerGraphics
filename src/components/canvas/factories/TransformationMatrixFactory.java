package components.canvas.factories;

import math.matrix.Matrix3x3;
import math.matrix.Matrix4x4;

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

    public static Matrix4x4 rotation3DZClockwise(double radians) {
        return new Matrix4x4(new double[][]{
                {Math.cos(radians), -Math.sin(radians), 0, 0},
                {Math.sin(radians), Math.cos(radians), 0, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 1}
        });
    }

    public static Matrix4x4 rotation3DXClockwise(double radians) {
        return new Matrix4x4(new double[][]{
                {1, 0, 0, 0},
                {0, Math.cos(radians), -Math.sin(radians), 0},
                {0, Math.sin(radians), Math.cos(radians), 0},
                {0, 0, 0, 1}
        });
    }

    public static Matrix4x4 rotation3DYClockwise(double radians) {
        return new Matrix4x4(new double[][]{
                {Math.cos(radians), 0, Math.sin(radians), 0},
                {0, 1, 0, 0},
                {-Math.sin(radians), 0, Math.cos(radians), 0},
                {0, 0, 0, 1}
        });
    }

    public static Matrix3x3 scalingZoom(double sx, double sy) {
        return new Matrix3x3(new double[][]{
                {sx, 0, 0},
                {0, sy, 0},
                {0, 0, 1}
        });
    }

    public static Matrix4x4 scalingZoom(double sx, double sy, double sz) {
        return new Matrix4x4(new double[][]{
                {sx, 0, 0, 0},
                {0, sy, 0, 0},
                {0, 0, sz, 0},
                {0, 0, 0, 1}
        });
    }

    public static Matrix3x3 scalingZoomOut(double sx, double sy) {
        return new Matrix3x3(new double[][]{
                {1 / sx, 0, 0},
                {0, 1 / sy, 0},
                {0, 0, 1}
        });
    }

    public static Matrix4x4 scalingZoomOut(double sx, double sy, double sz) {
        return new Matrix4x4(new double[][]{
                {1 / sx, 0, 0, 0},
                {0, 1 / sy, 0, 0},
                {0, 0, 1 / sz, 0},
                {0, 0, 0, 1}
        });
    }
}
