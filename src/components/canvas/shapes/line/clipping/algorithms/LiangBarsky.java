package components.canvas.shapes.line.clipping.algorithms;

import components.canvas.shapes.line.clipping.ILineClippingAlgorithm;
import components.canvas.shapes.line.clipping.LineClippingResult;

public class LiangBarsky implements ILineClippingAlgorithm {
    float maxi(float[] arr, int n) {
        float m = 0;
        for (int i = 0; i < n; ++i)
            if (m < arr[i])
                m = arr[i];
        return m;
    }

    // this function gives the minimum
    float mini(float[] arr, int n) {
        float m = 1;
        for (int i = 0; i < n; ++i)
            if (m > arr[i])
                m = arr[i];
        return m;
    }

    @Override
    public LineClippingResult clip(int x1, int y1, int x2, int y2, int xMin, int yMin, int xMax, int yMax) {
        // defining variables
        float p1 = -(x2 - x1);
        float p2 = -p1;
        float p3 = -(y2 - y1);
        float p4 = -p3;

        float q1 = x1 - xMin;
        float q2 = xMax - x1;
        float q3 = y1 - yMin;
        float q4 = yMax - y1;

        float[] posArray = new float[5], negArray = new float[5];
        int posInd = 1, negInd = 1;
        posArray[0] = 1;
        negArray[0] = 0;

        if ((p1 == 0 && q1 < 0) || (p2 == 0 && q2 < 0) || (p3 == 0 && q3 < 0) || (p4 == 0 && q4 < 0)) {
            return LineClippingResult.onFailure();
        }
        if (p1 != 0) {
            float r1 = q1 / p1;
            float r2 = q2 / p2;
            if (p1 < 0) {
                negArray[negInd++] = r1; // for negative p1, add it to negative array
                posArray[posInd++] = r2; // and add p2 to positive array
            } else {
                negArray[negInd++] = r2;
                posArray[posInd++] = r1;
            }
        }

        if (p3 != 0) {
            float r3 = q3 / p3;
            float r4 = q4 / p4;
            if (p3 < 0) {
                negArray[negInd++] = r3;
                posArray[posInd++] = r4;
            } else {
                negArray[negInd++] = r4;
                posArray[posInd++] = r3;
            }
        }

        float xn1, yn1, xn2, yn2;
        float rn1, rn2;
        rn1 = maxi(negArray, negInd); // maximum of negative array
        rn2 = mini(posArray, posInd); // minimum of positive array

        if (rn1 > rn2) { // reject
            return LineClippingResult.onFailure();
        }

        xn1 = x1 + p2 * rn1;
        yn1 = y1 + p4 * rn1; // computing new points

        xn2 = x1 + p2 * rn2;
        yn2 = y1 + p4 * rn2;

        return LineClippingResult.onSuccess((int) xn1, (int) yn1, (int) xn2, (int) yn2);
    }


}
