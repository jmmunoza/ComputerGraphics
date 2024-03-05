package components.canvas.transformations.matrixes;

import math.matrix.Matrix4x4;

public class Translation3DMatrix extends Matrix4x4 {
    public Translation3DMatrix(double dx, double dy, double dz) {
        super(new double[][]{
                {1, 0, 0, dx},
                {0, 1, 0, dy},
                {0, 0, 1, dz},
                {0, 0, 0, 1}
        });
    }
}
