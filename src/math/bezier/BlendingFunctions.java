package math.bezier;

import math.point.Point3D;

import java.io.File;
import java.util.Scanner;

public class BlendingFunctions {
    public static double find(int k, int n, double u) {
        double C = BinomialCoefficients.find(n, k);
        return C * Math.pow(u, k) * Math.pow((1 - u), (n - k));
    }

    public static class BezierDTO {
        public Point3D[][] points;

        public int u;
        public int v;

        public Point3D center;

        public BezierDTO(Point3D[][] points, int u, int v, Point3D center) {
            this.points = points;
            this.u = u;
            this.v = v;
            this.center = center;
        }

        @Override
        public String toString() {
            StringBuilder pointsString = new StringBuilder();

            for (Point3D[] point3DS : points) {
                for (Point3D point3D : point3DS) {
                    pointsString.append(point3D).append(" ");
                }
                pointsString.append("\n");
            }

            return "BezierDTO{" +
                    "u=" + u +
                    ", v=" + v +
                    ", center=" + center +
                    '}' + "\n" + pointsString;
        }
    }

    public static class BezierFileReader {

        public static BezierDTO readObject(String filename) {

            Point3D[][] points = null;
            Point3D center = null;
            int matrixRows = 0;
            int matrixCols= 0;
            int u = 0;
            int v = 0;

            try {
                Scanner in = new Scanner(new File(filename));

                matrixRows= in.nextInt() + 1;
                matrixCols = in.nextInt() + 1;

                if (matrixRows < 0 ||
                    matrixCols < 0 ||
                    matrixCols > 3 ||
                    matrixRows > 3) {
                    throw new IllegalArgumentException("Invalid matrix dimensions");
                }

                points = new Point3D[matrixRows][matrixCols];

                for (int i = 0; i < matrixRows; i++) {
                    for (int j = 0; j < matrixCols; j++) {
                        points[i][j] = new Point3D(in.nextDouble(), in.nextDouble(), in.nextDouble());
                    }
                }

                u = in.nextInt();
                v = in.nextInt();

                center = new Point3D(in.nextDouble(), in.nextDouble(), in.nextDouble());
            } catch (Exception e) {
              System.out.println("Error reading file");
            }

            return new BezierDTO(points, u, v, center);
          }

    }
}
