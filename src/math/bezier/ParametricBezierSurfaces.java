package math.bezier;

import math.point.Point3D;
import math.vector.Vector3D;

public class ParametricBezierSurfaces {
    public int m;
    public int n;
    public Point3D[][] controlPoints;
    public int U;
    public int V;

    public ParametricBezierSurfaces(int m, int n, Point3D[][] controlPoints, int U, int V){
        this.m = m;
        this.n = n;
        this.controlPoints = controlPoints;
        this.U = U;
        this.V = V;
    }
    public Point3D SurfacePoint(double u, double v){
        Point3D surfacePoint = new Point3D(0, 0, 0);
        for (int j = 0; j <= m; j++) {
            for (int k = 0; k <= n; k++) {
                Point3D p = controlPoints[j][k];

                double BEZjmu = new BlendingFunctions(j, m, u).BEZ();
                double BEZknv = new BlendingFunctions(k, n, v).BEZ();

                surfacePoint.setX(surfacePoint.getX() + p.getX()*BEZjmu * BEZknv);
                surfacePoint.setY(surfacePoint.getY() + p.getY()*BEZjmu * BEZknv);
                surfacePoint.setZ(surfacePoint.getZ() + p.getZ()*BEZjmu * BEZknv);
            }
        }
        return surfacePoint;
    }
    public Point3D[][] Surface(){
        Point3D[][] surface = new Point3D[U][V];
        double deltaU = 1/U;
        double deltaV = 1/V;
        double u = 0;
        double v = 0;

        for (int i = 0; i <= 1; i++) {
            for (int j = 0; j <= 1; j++) {
                surface[i][j] = SurfacePoint(u, v);
                u += deltaU;
                v += deltaV;
            }
        }
        return surface;
    }
}
