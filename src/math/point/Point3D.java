package math.point;

public class Point3D extends Point {
    private static final int DIMENSION = 3;
    private double x;
    private double y;
    private double z;

    public Point3D(double[] coords) {
        super(DIMENSION, coords);

        this.x = coords[0];
        this.y = coords[1];
        this.z = coords[2];
    }

    public Point3D(double x, double y, double z) {
        this(new double[]{x, y, z});
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
        coords[0] = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
        coords[1] = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
        coords[2] = z;
    }
}
