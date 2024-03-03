package components.canvas.shapes.line;

import components.canvas.CanvasMapper;
import components.canvas.shapes.BaseShape;
import components.canvas.transformations.Transformation;
import components.canvas.transformations.TransformationData;
import math.point.Point2D;

import java.awt.*;

public class Line extends BaseShape {
    private final ILineAlgorithm algorithm;
    private int x1;
    private int y1;
    private int x2;
    private int y2;

    public Line(int x1, int y1, int x2, int y2) {
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
        this((int) point1.x, (int) point1.y, (int) point2.x, (int) point2.y);
    }

    @Override
    public void draw(Graphics g) {
        if (hidden) return;

        int h = g.getClipBounds().height;
        int w = g.getClipBounds().width;

        int mappedX1 = CanvasMapper.mapXpToXj(x1, w);
        int mappedY1 = CanvasMapper.mapYpToYj(y1, h);
        int mappedX2 = CanvasMapper.mapXpToXj(x2, w);
        int mappedY2 = CanvasMapper.mapYpToYj(y2, h);

        g.setColor(color);
        g.drawLine(mappedX1, mappedY1, mappedX2, mappedY2);
        // algorithm.drawLine(g, x1, y1, x2, y2);
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
    public int getX() {
        return Math.min(x1, x2);
    }

    @Override
    public int getY() {
        return Math.max(y1, y2);
    }

    @Override
    public int getWidth() {
        return Math.abs(x2 - x1);
    }

    @Override
    public int getHeight() {
        return Math.abs(y2 - y1);
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }
}
