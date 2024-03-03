package components.canvas.transformations.rotation;

import components.canvas.transformations.Transformation;
import components.canvas.transformations.TransformationData;
import math.matrix.Matrix3x3;
import math.vector.Vector3D;

public class RotationCounterClockwise implements Transformation {
    private final double radians;

    public RotationCounterClockwise(double degrees) {
        this.radians = Math.toRadians(degrees);
    }

    @Override
    public TransformationData transform(TransformationData data) {
        Matrix3x3 rotationMatrix = new Matrix3x3(new double[][]{
                {Math.cos(radians), -Math.sin(radians), 0},
                {Math.sin(radians), Math.cos(radians), 0},
                {0, 0, 1}
        });

        Vector3D vectorToTranslate = new Vector3D(new double[]{
                data.x, data.y, 1
        });

        Vector3D result = Matrix3x3.times(rotationMatrix, vectorToTranslate);

        return new TransformationData((int) result.x, (int) result.y);
    }
}
