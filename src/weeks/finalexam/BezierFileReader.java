package weeks.finalexam;
import java.util.Scanner;
import math.point.Point3D;
import java.io.File;

public class BezierFileReader {

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
