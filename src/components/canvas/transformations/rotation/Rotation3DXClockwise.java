package components.canvas.transformations.rotation;

import components.canvas.factories.TransformationMatrixFactory;
import components.canvas.transformations.Transformation;
import components.canvas.transformations.TransformationData;
import components.canvas.transformations.matrixes.Translation3DMatrix;
import math.matrix.Matrix4x4;
import math.vector.Vector4D;

public class Rotation3DXClockwise implements Transformation {
    private final double radians;
    private final double x;
    private final double y;
    private final double z;

    public Rotation3DXClockwise(double x, double y, double z, double degrees) {
        this.radians = Math.toRadians(degrees);
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Rotation3DXClockwise(double degrees) {
        this(0, 0, 0, degrees);
    }

    @Override
    public TransformationData transform(TransformationData data) {
        Matrix4x4 T = new Translation3DMatrix(x, y, z);
        Matrix4x4 R = TransformationMatrixFactory.rotation3DXClockwise(radians);
        Matrix4x4 Tn = new Translation3DMatrix(-x, -y, -z);
        Vector4D v = new Vector4D(data.x, data.y, data.z, 1);

        Matrix4x4 TxR = Matrix4x4.times(T, R);
        Matrix4x4 TRxTn = Matrix4x4.times(TxR, Tn);
        Vector4D result = Matrix4x4.times(TRxTn, v);

        return TransformationData.create3D(result.x, result.y, result.z);
    }
}
