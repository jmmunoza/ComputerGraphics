package math.point;

public class Point2D extends Point {
    private static final int DIMENSION = 2;
    public double x;
    public double y;

    public Point2D(double[] coords) {
        super(DIMENSION, coords);

        this.x = coords[0];
        this.y = coords[1];
    }
}
