package math.point;

public class Point {
    private final int dimension;
    public double[] coords;

    public Point(int dimension, double[] coords) {
        this.coords = coords;
        this.dimension = dimension;
    }

    @Override
    public String toString() {
        StringBuilder pointString = new StringBuilder();

        pointString.append("(");

        for (int i = 0; i < dimension; i++) {
            pointString.append(coords[i]);

            if (i != dimension - 1) pointString.append(", ");
        }

        pointString.append(")");

        return pointString.toString();
    }
}
