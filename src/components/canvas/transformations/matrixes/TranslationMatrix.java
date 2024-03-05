package components.canvas.transformations.matrixes;

import math.matrix.Matrix3x3;

public class TranslationMatrix extends Matrix3x3 {
    public TranslationMatrix(double dx, double dy) {
        super(new double[][]{
                {1, 0, dx},
                {0, 1, dy},
                {0, 0, 1}
        });
    }
}
