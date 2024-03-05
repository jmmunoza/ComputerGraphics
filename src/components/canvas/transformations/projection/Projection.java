package components.canvas.transformations.projection;

import components.canvas.transformations.Transformation;
import components.canvas.transformations.TransformationData;
import components.canvas.transformations.matrixes.ProjectionMatrix;
import math.matrix.Matrix4x4;
import math.vector.Vector4D;

public class Projection implements Transformation {
    private final double d;

    public Projection(double d) {
        this.d = d;
    }

    @Override
    public TransformationData transform(TransformationData data) {
        Matrix4x4 P = new ProjectionMatrix(d);
        Vector4D v = new Vector4D(data.x, data.y, data.z, 1);
        Vector4D Pxv = Matrix4x4.times(P, v);
        Vector4D result = normalizeW(Pxv);

        return TransformationData.create3D(result.x, result.y, result.z);
    }

    private Vector4D normalizeW(Vector4D v) {
        return new Vector4D(new double[]{
                v.x / v.w, v.y / v.w, v.z / v.w, 1,
        });

    }
}
