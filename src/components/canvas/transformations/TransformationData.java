package components.canvas.transformations;

public class TransformationData {
    public double x;
    public double y;
    public double z;

    private TransformationData(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public static TransformationData create2D(double x, double y) {
        return new TransformationData(x, y, 0);
    }

    public static TransformationData create3D(double x, double y, double z) {
        return new TransformationData(x, y, z);
    }
}
