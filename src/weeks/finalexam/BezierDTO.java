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

    @Override
    public String toString() {
        String pointsString = "";

        for (Point3D[] point3DS : points) {
            for (Point3D point3D : point3DS) {
                pointsString += point3D + " ";
            }
            pointsString += "\n";
        }

        return "BezierDTO{" +
                "u=" + u +
                ", v=" + v +
                ", center=" + center +
                '}' + "\n" + pointsString;
    }
}
