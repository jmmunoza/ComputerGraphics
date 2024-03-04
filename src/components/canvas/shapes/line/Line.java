package components.canvas.shapes.line;

import components.canvas.CanvasMapper;
import components.canvas.shapes.BaseShape;
import components.canvas.transformations.Transformation;
import components.canvas.transformations.TransformationData;
import math.point.Point2D;

import java.awt.*;

public class Line extends BaseShape {
    private final ILineAlgorithm algorithm;
    private double x1;
    private double y1;
    private double x2;
    private double y2;

    public Line(double x1, double y1, double x2, double y2) {
        super(x1, y1);

        algorithm = LineProvider.inject(LineAlgorithm.BRESENHAM);

        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public Line() {
        this(0, 0, 0, 0);
    }

    public Line(Point2D point1, Point2D point2) {
        this(point1.x, point1.y, point2.x, point2.y);
    }

    @Override
    public void draw(Graphics g) {
        if (hidden) return;

        int h = g.getClipBounds().height;
        int w = g.getClipBounds().width;

        double mappedX1 = CanvasMapper.mapXpToXj(x1, w);
        double mappedY1 = CanvasMapper.mapYpToYj(y1, h);
        double mappedX2 = CanvasMapper.mapXpToXj(x2, w);
        double mappedY2 = CanvasMapper.mapYpToYj(y2, h);

        g.setColor(color);

        algorithm.drawLine(g, (int) mappedX1, (int) mappedY1, (int) mappedX2, (int) mappedY2);
    }

    @Override
    public void transform(Transformation t) {
        TransformationData t1 = t.transform(new TransformationData(x1, y1));
        TransformationData t2 = t.transform(new TransformationData(x2, y2));

        x1 = t1.x;
        y1 = t1.y;
        x2 = t2.x;
        y2 = t2.y;
    }

    @Override
    public double getX() {
        return Math.min(x1, x2);
    }

    @Override
    public double getY() {
        return Math.max(y1, y2);
    }

    @Override
    public double getWidth() {
        return Math.abs(Math.max(x1, x2) - Math.min(x1, x2));
    }

    @Override
    public double getHeight() {
        return Math.abs(Math.max(y1, y2) - Math.min(y1, y2));
    }

    public void setY2(double y2) {
        this.y2 = y2;
    }

    public void setY1(double y1) {
        this.y1 = y1;
    }

    public void setX2(double x2) {
        this.x2 = x2;
    }

    public void setX1(double x1) {
        this.x1 = x1;
    }

    @Override
    public double getXCenter() {
        return Math.abs(x2 - x1) / 2;
    }

    @Override
    public double getYCenter() {
        return Math.abs(y2 - y1) / 2;
    }
}
