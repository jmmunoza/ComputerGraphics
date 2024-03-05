package components.canvas.transformations.rotation;

import components.canvas.factories.TransformationMatrixFactory;
import components.canvas.transformations.Transformation;
import components.canvas.transformations.TransformationData;
import components.canvas.transformations.matrixes.TranslationMatrix;
import math.matrix.Matrix3x3;
import math.vector.Vector3D;

public class RotationAnticlockwise implements Transformation {
    private final double radians;
    private final double x;
    private final double y;

    public RotationAnticlockwise(double x, double y, double degrees) {
        this.radians = Math.toRadians(degrees);
        this.x = x;
        this.y = y;
    }

    public RotationAnticlockwise(double degrees) {
        this(0, 0, degrees);
    }

    @Override
    public TransformationData transform(TransformationData data) {
        Matrix3x3 T = new TranslationMatrix(x, y);
        Matrix3x3 R = TransformationMatrixFactory.rotationAnticlockwise(radians);
        Matrix3x3 Tn = new TranslationMatrix(-x, -y);
        Vector3D v = new Vector3D(data.x, data.y, 1);

        Matrix3x3 TxR = Matrix3x3.times(T, R);
        Matrix3x3 TRxTn = Matrix3x3.times(TxR, Tn);
        Vector3D result = Matrix3x3.times(TRxTn, v);

        return TransformationData.create2D(result.x, result.y);
    }
}
