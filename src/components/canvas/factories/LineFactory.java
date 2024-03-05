package components.canvas.factories;

import components.canvas.shapes.line.Line;
import components.canvas.shapes.line.Line3D;
import math.point.Point;
import math.point.Point2D;
import math.point.Point3D;

public class LineFactory {
    public static Line generate(Point p1, Point p2) {
        if (p1 instanceof Point2D && p2 instanceof Point2D) {
            return new Line((Point2D) p1, (Point2D) p2);
        }

        if (p1 instanceof Point3D && p2 instanceof Point3D) {
            return new Line3D((Point3D) p1, (Point3D) p2);
        }

        return new Line();
    }
}
