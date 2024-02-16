package components.canvas.shapes.line;

import components.canvas.CanvasShape;
import math.point.Point2D;

import java.awt.*;

public class Line implements CanvasShape {
    private final ILineAlgorithm algorithm;
    private int x1 = 0;
    private int y1 = 0;
    private int x2 = 0;
    private int y2 = 0;

    public Line(LineAlgorithm algorithmType) {
        algorithm = LineProvider.inject(algorithmType);
    }

    public Line(Point2D point1, Point2D point2, LineAlgorithm algorithmType) {
        algorithm = LineProvider.inject(algorithmType);

        x1 = (int) point1.x;
        y1 = (int) point1.y;
        x2 = (int) point2.x;
        y2 = (int) point2.y;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }

    @Override
    public void draw(Graphics g) {
        algorithm.drawLine(g, x1, y1, x2, y2);
    }
}
