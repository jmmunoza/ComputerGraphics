package weeks.finalexam;

import java.util.Scanner;
import java.io.File;

public class BezierFileReader {

    public static void readObject(String filename) {

        int matrixRows = 0;
        int matrixCols = 0;

        try {
            Scanner in = new Scanner(new File(filename));

            matrixRows= in.nextInt();
            matrixCols = in.nextInt();

            if (matrixRows < 0 || 
                matrixCols < 0 || 
                matrixCols > 3 || 
                matrixRows > 3) { 
                throw new IllegalArgumentException("Invalid matrix dimensions");
            }

            System.out.println("Matrix Rows: " + matrixRows);
            System.out.println("Matrix Rows: " + matrixCols);
  
        } catch (Exception e) {
          System.out.println("Error reading file");
        }
      }
    
}