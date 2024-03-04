package components.canvas.transformations.scaling;

import components.canvas.factories.TransformationMatrixFactory;
import components.canvas.transformations.Transformation;
import components.canvas.transformations.TransformationData;
import math.matrix.Matrix3x3;
import math.vector.Vector3D;

public class ScalingZoom implements Transformation {
    private final double x;
    private final double y;
    private final double sx;
    private final double sy;

    public ScalingZoom(double x, double y, double sx, double sy) {
        this.x = x;
        this.y = y;
        this.sx = sx;
        this.sy = sy;
    }

    public ScalingZoom(double sx, double sy) {
        this(0, 0, sx, sy);
    }

    @Override
    public TransformationData transform(TransformationData data) {
        Matrix3x3 T = TransformationMatrixFactory.translation(x, y);
        Matrix3x3 S = TransformationMatrixFactory.scalingZoom(sx, sy);
        Matrix3x3 Tn = TransformationMatrixFactory.translation(-x, -y);

        Vector3D v = new Vector3D(new double[]{data.x, data.y, 1});

        Matrix3x3 TxS = Matrix3x3.times(T, S);
        Matrix3x3 TSxTn = Matrix3x3.times(TxS, Tn);
        Vector3D result = Matrix3x3.times(TSxTn, v);

        return new TransformationData(result.x, result.y);
    }
}
