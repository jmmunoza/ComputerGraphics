package components.canvas.transformations.scaling;

import components.canvas.factories.TransformationMatrixFactory;
import components.canvas.transformations.Transformation;
import components.canvas.transformations.TransformationData;
import components.canvas.transformations.matrixes.TranslationMatrix;
import math.matrix.Matrix3x3;
import math.vector.Vector3D;

public class ScalingZoomOut implements Transformation {
    private final double x;
    private final double y;
    private final double sx;
    private final double sy;

    public ScalingZoomOut(double x, double y, double sx, double sy) {
        this.x = x;
        this.y = y;
        this.sx = sx;
        this.sy = sy;
    }

    public ScalingZoomOut(double sx, double sy) {
        this(0, 0, sx, sy);
    }

    public ScalingZoomOut(double s) {
        this(0, 0, s, s);
    }

    public ScalingZoomOut(double x, double y, double s) {
        this(x, y, s, s);
    }

    @Override
    public TransformationData transform(TransformationData data) {
        Matrix3x3 T = new TranslationMatrix(x, y);
        Matrix3x3 S = TransformationMatrixFactory.scalingZoomOut(sx, sy);
        Matrix3x3 Tn = new TranslationMatrix(-x, -y);
        Vector3D v = new Vector3D(data.x, data.y, 1);

        Matrix3x3 TxS = Matrix3x3.times(T, S);
        Matrix3x3 TSxTn = Matrix3x3.times(TxS, Tn);
        Vector3D result = Matrix3x3.times(TSxTn, v);

        return TransformationData.create2D(result.x, result.y);
    }
}