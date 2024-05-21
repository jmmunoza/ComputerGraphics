package math.vector;

public class Vector {
    private final int dimension;
    public double[] components;

    public Vector(int dimension, double[] components) {
        this.dimension = dimension;
        this.components = components;
    }

    public static Vector multiply(Vector v, double scalar) {
        for (int i = 0; i < v.dimension; i++) {
            v.components[i] *= scalar;
        }

        return v;
    }

    public static double dotProduct(Vector v1, Vector v2) {
        double product = 0;

        for (int i = 0; i < v1.dimension; i++) {
            product += v1.components[i] * v2.components[i];
        }

        return product;
    }

    public static Vector normalize(Vector v) {
        double m = v.magnitude();
        double[] normalizedComponents = new double[v.dimension];

        for (int i = 0; i < v.dimension; i++) {
            normalizedComponents[i] = v.components[i] / m;
        }

        return new Vector(v.dimension, normalizedComponents);
    }

    public static Vector add(Vector v1, Vector v2) {
        double[] addedComponents = new double[v1.dimension];

        for (int i = 0; i < v1.dimension; i++) {
            addedComponents[i] = v1.components[i] + v2.components[i];
        }

        return new Vector(v1.dimension, addedComponents);
    }

    public static Vector minus(Vector v) {
        double[] negativeComponents = new double[v.dimension];

        for (int i = 0; i < v.dimension; i++) {
            negativeComponents[i] = -1 * v.components[i];
        }

        return new Vector(v.dimension, negativeComponents);
    }

    public void normalize() {
        Vector normalized = normalize(this);

        this.components = normalized.components;
    }

    public double magnitude() {
        double sumOfSquares = 0;

        for (int i = 0; i < dimension; i++) {
            sumOfSquares += components[i] * components[i];
        }

        return Math.sqrt(sumOfSquares);
    }

    @Override
    public String toString() {
        StringBuilder vectorString = new StringBuilder();

        vectorString.append("[");

        for (int i = 0; i < dimension; i++) {
            vectorString.append(components[i]);

            if (i != dimension - 1) vectorString.append(", ");
        }

        vectorString.append("]");

        return vectorString.toString();
    }
}
