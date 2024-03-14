package components.canvas.shapes.line;

import components.canvas.CanvasMapper;
import components.canvas.shapes.BaseShape;
import components.canvas.shapes.line.clipping.ILineClippingAlgorithm;
import components.canvas.shapes.line.clipping.LineClippingAlgorithm;
import components.canvas.shapes.line.clipping.LineClippingProvider;
import components.canvas.shapes.line.clipping.LineClippingResult;
import components.canvas.shapes.line.drawing.ILineAlgorithm;
import components.canvas.shapes.line.drawing.LineAlgorithm;
import components.canvas.shapes.line.drawing.LineProvider;
import components.canvas.transformations.Transformation;
import components.canvas.transformations.TransformationData;
import math.point.Point2D;

import java.awt.*;

public class Line extends BaseShape {
    protected final ILineAlgorithm algorithm;
    protected double x1;
    protected double y1;
    protected double x2;
    protected double y2;
    protected ILineClippingAlgorithm clippingAlgorithm;

    public Line(double x1, double y1, double x2, double y2) {
        super(x1, y1);

        algorithm = LineProvider.inject(LineAlgorithm.BRESENHAM);

        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;

        clippingAlgorithm = LineClippingProvider.inject(LineClippingAlgorithm.COHEN_SUTHERLAND);
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

        LineClippingResult result = clippingAlgorithm.clip(
                (int) x1,
                (int) y1,
                (int) x2,
                (int) y2,
                -w / 2,
                -h / 2,
                w / 2,
                h / 2
        );

        double mappedX1 = CanvasMapper.mapXpToXj(result.x1, w);
        double mappedY1 = CanvasMapper.mapYpToYj(result.y1, h);
        double mappedX2 = CanvasMapper.mapXpToXj(result.x2, w);
        double mappedY2 = CanvasMapper.mapYpToYj(result.y2, h);

        g.setColor(color);

        algorithm.drawLine(g, (int) mappedX1, (int) mappedY1, (int) mappedX2, (int) mappedY2);
    }

    @Override
    public void transform(Transformation t) {
        TransformationData t1 = t.transform(TransformationData.create2D(x1, y1));
        TransformationData t2 = t.transform(TransformationData.create2D(x2, y2));

        x1 = t1.x;
        y1 = t1.y;
        x2 = t2.x;
        y2 = t2.y;

        onMovement();
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

        onMovement();
    }

    public void setY1(double y1) {
        this.y1 = y1;

        onMovement();
    }

    public void setX2(double x2) {
        this.x2 = x2;

        onMovement();
    }

    public void setX1(double x1) {
        this.x1 = x1;

        onMovement();
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
