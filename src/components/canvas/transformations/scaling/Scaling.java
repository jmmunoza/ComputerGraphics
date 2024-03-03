package components.canvas.transformations.scaling;

import components.canvas.transformations.Transformation;
import components.canvas.transformations.TransformationData;
import math.matrix.Matrix3x3;
import math.vector.Vector3D;

public class Scaling implements Transformation {
    private final double sx;
    private final double sy;

    public Scaling(double sx, double sy) {
        this.sx = sx;
        this.sy = sy;
    }

    @Override
    public TransformationData transform(TransformationData data) {
        Matrix3x3 scalingMatrix = new Matrix3x3(new double[][]{
                {sx, 0, 0},
                {0, sy, 0},
                {0, 0, 1}
        });

        Vector3D vectorToTranslate = new Vector3D(new double[]{
                data.x, data.y, 1
        });

        Vector3D result = Matrix3x3.times(scalingMatrix, vectorToTranslate);

        return new TransformationData((int) result.x, (int) result.y);
    }
}
