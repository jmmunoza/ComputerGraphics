package components.canvas.transformations.translation;

import components.canvas.transformations.Transformation;
import components.canvas.transformations.TransformationData;
import components.canvas.transformations.matrixes.Translation3DMatrix;
import math.matrix.Matrix4x4;
import math.vector.Vector4D;

public class Translation3D implements Transformation {
    private final double dx;
    private final double dy;
    private final double dz;

    public Translation3D(double dx, double dy, double dz) {
        this.dx = dx;
        this.dy = dy;
        this.dz = dz;
    }

    @Override
    public TransformationData transform(TransformationData data) {
        Matrix4x4 T = new Translation3DMatrix(dx, dy, dz);
        Vector4D v = new Vector4D(data.x, data.y, data.z, 1);
        Vector4D result = Matrix4x4.times(T, v);

        return TransformationData.create3D(result.x, result.y, result.z);
    }
}
