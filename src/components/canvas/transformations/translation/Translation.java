package components.canvas.transformations.translation;

import components.canvas.transformations.Transformation;
import components.canvas.transformations.TransformationData;
import math.matrix.Matrix3x3;
import math.vector.Vector3D;

public class Translation implements Transformation {
    private final int dx;
    private final int dy;

    public Translation(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }

    @Override
    public TransformationData transform(TransformationData data) {
        Matrix3x3 translationMatrix = new Matrix3x3(new double[][]{
                {1, 0, dx},
                {0, 1, dy},
                {0, 0, 1}
        });

        Vector3D vectorToTranslate = new Vector3D(new double[]{
                data.x, data.y, 1
        });

        Vector3D result = Matrix3x3.times(translationMatrix, vectorToTranslate);

        return new TransformationData((int) result.x, (int) result.y);
    }
}
