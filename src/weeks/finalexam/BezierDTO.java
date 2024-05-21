package weeks.finalexam;

import math.point.Point3D;

public class BezierDTO {
    Point3D[][] points;

    int u;
    int v;

    Point3D center;
    
    public BezierDTO(Point3D[][] points, int u, int v, Point3D center) {
        this.points = points;
        this.u = u;
        this.v = v;
        this.center = center;
    }
}
