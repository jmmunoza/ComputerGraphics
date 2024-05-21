package math.bezier;

import math.point.Point3D;
import math.vector.Vector3D;

public class ParametricBezierSurfaces {
    public Point3D[][] controlPoints;
    public int U;
    public int V;

    public ParametricBezierSurfaces(Point3D[][] controlPoints, int U, int V){
        this.controlPoints = controlPoints;
        this.U = U;
        this.V = V;
    }

    public Point3D[][] find(){
        Point3D[][] surface = new Point3D[U][V];
        double du = (double) 1 / U;
        double dv = (double) 1 / V;
        double u = 0, v;

        for (int i = 0; i < U; i++) {
            v = 0;

            for (int j = 0; j < V; j++) {
                surface[i][j] = P(u, v);
                v += dv;
            }

            u += du;
        }
        return surface;
    }

    private Point3D P(double u, double v){
        Point3D surfacePoint = new Point3D(0, 0, 0);
        int m = controlPoints.length - 1;
        int n = controlPoints[0].length - 1;

        for (int j = 0; j <= m; j++) {
            for (int k = 0; k <= n; k++) {
                Point3D p = controlPoints[j][k];

                double BEZjmu = BlendingFunctions.find(j, m, u);
                double BEZknv = BlendingFunctions.find(k, n, v);

                surfacePoint.setX(surfacePoint.getX() + p.getX() * BEZjmu * BEZknv);
                surfacePoint.setY(surfacePoint.getY() + p.getY() * BEZjmu * BEZknv);
                surfacePoint.setZ(surfacePoint.getZ() + p.getZ() * BEZjmu * BEZknv);
            }
        }

        return surfacePoint;
    }
}
