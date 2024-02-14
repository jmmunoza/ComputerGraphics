package math.point;

public class Point4D extends Point {
    private static final int DIMENSION = 4;
    public double x;
    public double y;
    public double z;
    public double w;

    public Point4D(double[] coords) {
        super(DIMENSION, coords);

        this.x = coords[0];
        this.y = coords[1];
        this.z = coords[2];
        this.w = coords[3];
    }
}
