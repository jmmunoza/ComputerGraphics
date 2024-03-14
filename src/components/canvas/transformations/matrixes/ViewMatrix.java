package components.canvas.transformations.matrixes;

import math.matrix.Matrix4x4;
import math.point.Point3D;
import math.vector.Vector3D;

public class ViewMatrix extends Matrix4x4 {
    public ViewMatrix(Point3D position, Point3D lookAt, Vector3D up) {
        super(new double[][]{
                        {0, 0, 0, 0},
                        {0, 0, 0, 0},
                        {0, 0, 0, 0},
                        {0, 0, 0, 0}
                }
        );

        Vector3D n = Vector3D.normalize(Vector3D.subtract(position, lookAt));
        Vector3D u = Vector3D.normalize(Vector3D.crossProduct(up, n));
        Vector3D v = Vector3D.crossProduct(n, u);

        Vector3D from = new Vector3D(position.coords);

        double tx = Vector3D.dotProduct(Vector3D.minus(u), from);
        double ty = Vector3D.dotProduct(Vector3D.minus(v), from);
        double tz = Vector3D.dotProduct(Vector3D.minus(n), from);

        this.elements = new double[][]{
                {u.x, u.y, u.z, tx},
                {v.x, v.y, v.z, ty},
                {n.x, n.y, n.z, tz},
                {0, 0, 0, 1},
        };
    }
}
