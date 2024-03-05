package components.canvas.factories;

import math.point.Point;
import math.point.Point2D;
import math.point.Point3D;
import math.point.Point4D;

public class PointFactory {
    public static Point create(double[] coords) {
        switch (coords.length) {
            case 2 -> {
                return new Point2D(coords);
            }
            case 3 -> {
                return new Point3D(coords);
            }
            case 4 -> {
                return new Point4D(coords);
            }
            default -> {
                return new Point(coords.length, coords);
            }
        }
    }
}
