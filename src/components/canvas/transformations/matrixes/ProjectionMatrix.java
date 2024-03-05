package components.canvas.transformations.matrixes;

import math.matrix.Matrix4x4;

public class ProjectionMatrix extends Matrix4x4 {

    public ProjectionMatrix(double d) {
        super(new double[][]{
                        {1, 0, 0, 0},
                        {0, 1, 0, 0},
                        {0, 0, 1, 0},
                        {0, 0, 1 / d, 1}
                }

        );
    }
}
