package math.vector;

public class Vector4D extends Vector {
    private static final int DIMENSION = 4;
    public double x;
    public double y;
    public double z;
    public double w;

    public Vector4D(double[] components) {
        super(DIMENSION, components);

        this.x = components[0];
        this.y = components[1];
        this.z = components[2];
        this.w = components[3];
    }

    public Vector4D(double x, double y, double z, double w) {
        this(new double[]{x, y, z, w});
    }

    public static Vector4D add(Vector4D v1, Vector4D v2) {
        Vector vector = Vector.add(v1, v2);

        return new Vector4D(vector.components);
    }

    public static Vector4D normalize(Vector4D v) {
        Vector vector = Vector.normalize(v);

        return new Vector4D(vector.components);
    }

    public static double dotProduct(Vector4D v1, Vector4D v2) {
        return Vector.dotProduct(v1, v2);
    }
}
