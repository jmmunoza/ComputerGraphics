package math.vector;

import math.point.Point3D;

public class Vector3D extends Vector {
    private static final int DIMENSION = 3;
    public double x;
    public double y;
    public double z;

    public Vector3D(double[] components) {
        super(DIMENSION, components);

        this.x = components[0];
        this.y = components[1];
        this.z = components[2];
    }

    public Vector3D(double x, double y, double z) {
        this(new double[]{x, y, z});
    }

    public static Vector3D crossProduct(Vector3D v1, Vector3D v2) {
        double ux = v1.y * v2.z - v1.z * v2.y;
        double uy = v1.x * v2.z - v1.z * v2.x;
        double uz = v1.x * v2.y - v1.y * v2.x;

        return new Vector3D(new double[]{ux, -uy, uz});
    }

    public static Vector3D add(Vector3D v1, Vector3D v2) {
        Vector vector = Vector.add(v1, v2);

        return new Vector3D(vector.components);
    }

    public static Vector3D multiply(Vector3D v, double scalar) {
        Vector vector = Vector.multiply(v, scalar);

        return new Vector3D(vector.components);
    }

    public static Vector3D normalize(Vector3D v) {
        Vector vector = Vector.normalize(v);

        return new Vector3D(vector.components);
    }

    public static Vector3D subtract(Point3D p1, Point3D p2) {
        return new Vector3D(p1.getX() - p2.getX(), p1.getY() - p2.getY(), p1.getZ() - p2.getZ());
    }

    public static Vector3D minus(Vector3D v) {
        Vector vector = Vector.minus(v);

        return new Vector3D(vector.components);
    }

    public static double dotProduct(Vector3D v1, Vector3D v2) {
        return Vector.dotProduct(v1, v2);
    }
}
