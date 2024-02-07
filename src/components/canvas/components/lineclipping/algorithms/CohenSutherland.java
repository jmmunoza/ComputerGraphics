package components.canvas.components.lineclipping.algorithms;

import components.canvas.components.lineclipping.ILineClippingAlgorithm;
import components.canvas.shapes.line.Line;

public class CohenSutherland implements ILineClippingAlgorithm {
    private final int INSIDE = 0; // 0000
    private final int LEFT = 1;   // 0001
    private final int RIGHT = 2;  // 0010
    private final int BOTTOM = 4; // 0100
    private final int TOP = 8;    // 1000

    private int computeOutCode(double x, double y, int xMin, int yMin, int xMax, int yMax) {
        int code = INSIDE;  // initialised as being inside of clip window

        if (x < xMin)           // to the left of clip window
            code |= LEFT;
        else if (x > xMax)      // to the right of clip window
            code |= RIGHT;
        if (y < yMin)           // below the clip window
            code |= BOTTOM;
        else if (y > yMax)      // above the clip window
            code |= TOP;

        return code;
    }

    @Override
    public boolean clip(Line line, int x1, int y1, int x2, int y2, int xMin, int yMin, int xMax, int yMax) {
        int outCode1 = computeOutCode(x1, y1, xMin, yMin, xMax, yMax);
        int outCode2 = computeOutCode(x2, y2, xMin, yMin, xMax, yMax);
        boolean accept = false;

        int xn1 = x1;
        int yn1 = y1;
        int xn2 = x2;
        int yn2 = y2;

        while (true) {
            if ((outCode1 | outCode2) == 0) {
                accept = true;
                break;
            } else if ((outCode1 & outCode2) != 0) {
                break;
            } else {
                int x = 0;
                int y = 0;

                int outCodeOut = Math.max(outCode2, outCode1);

                if ((outCodeOut & TOP) != 0) {
                    x = xn1 + (xn2 - xn1) * (yMax - yn1) / (yn2 - yn1);
                    y = yMax;
                } else if ((outCodeOut & BOTTOM) != 0) {
                    x = xn1 + (xn2 - xn1) * (yMin - yn1) / (yn2 - yn1);
                    y = yMin;
                } else if ((outCodeOut & RIGHT) != 0) {
                    y = yn1 + (yn2 - yn1) * (xMax - xn1) / (xn2 - xn1);
                    x = xMax;
                } else if ((outCodeOut & LEFT) != 0) {
                    y = yn1 + (yn2 - yn1) * (xMin - xn1) / (xn2 - xn1);
                    x = xMin;
                }

                if (outCodeOut == outCode1) {
                    xn1 = x;
                    yn1 = y;
                    outCode1 = computeOutCode(xn1, yn1, xMin, yMin, xMax, yMax);
                } else {
                    xn2 = x;
                    yn2 = y;
                    outCode2 = computeOutCode(xn2, yn2, xMin, yMin, xMax, yMax);
                }
            }
        }

        line.setX1(xn1);
        line.setY1(yn1);
        line.setX2(xn2);
        line.setY2(yn2);

        return accept;
    }
}
