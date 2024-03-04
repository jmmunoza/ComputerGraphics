package components.canvas.transformations.translation;

import components.canvas.factories.TransformationMatrixFactory;
import components.canvas.transformations.Transformation;
import components.canvas.transformations.TransformationData;
import math.matrix.Matrix3x3;
import math.vector.Vector3D;

public class Translation implements Transformation {
    private final double dx;
    private final double dy;

    public Translation(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }

    @Override
    public TransformationData transform(TransformationData data) {
        Matrix3x3 T = TransformationMatrixFactory.translation(dx, dy);
        Vector3D v = new Vector3D(new double[]{data.x, data.y, 1});

        Vector3D result = Matrix3x3.times(T, v);

        return new TransformationData(result.x, result.y);
    }
}
