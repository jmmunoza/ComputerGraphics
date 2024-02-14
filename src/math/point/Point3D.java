package math.point;

public class Point3D extends Point {
    private static final int DIMENSION = 3;
    public double x;
    public double y;
    public double z;

    public Point3D(double[] coords) {
        super(DIMENSION, coords);

        this.x = coords[0];
        this.y = coords[1];
        this.z = coords[2];
    }
}
