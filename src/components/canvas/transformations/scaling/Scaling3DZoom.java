package components.canvas.transformations.scaling;

import components.canvas.factories.TransformationMatrixFactory;
import components.canvas.transformations.Transformation;
import components.canvas.transformations.TransformationData;
import components.canvas.transformations.matrixes.Translation3DMatrix;
import math.matrix.Matrix4x4;
import math.vector.Vector4D;

public class Scaling3DZoom implements Transformation {
    private final double x;
    private final double y;
    private final double z;
    private final double sx;
    private final double sy;
    private final double sz;

    public Scaling3DZoom(double x, double y, double z, double sx, double sy, double sz) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.sx = sx;
        this.sy = sy;
        this.sz = sz;
    }

    public Scaling3DZoom(double sx, double sy, double sz) {
        this(0, 0, 0, sx, sy, sz);
    }

    public Scaling3DZoom(double x, double y, double z, double s) {
        this(x, y, z, s, s, s);
    }

    public Scaling3DZoom(double s) {
        this(0, 0, 0, s, s, s);
    }

    @Override
    public TransformationData transform(TransformationData data) {
        Matrix4x4 T = new Translation3DMatrix(x, y, z);
        Matrix4x4 S = TransformationMatrixFactory.scalingZoom(sx, sy, sz);
        Matrix4x4 Tn = new Translation3DMatrix(-x, -y, -z);
        Vector4D v = new Vector4D(data.x, data.y, data.z, 1);

        Matrix4x4 TxS = Matrix4x4.times(T, S);
        Matrix4x4 TSxTn = Matrix4x4.times(TxS, Tn);
        Vector4D result = Matrix4x4.times(TSxTn, v);

        return TransformationData.create3D(result.x, result.y, result.z);
    }
}
