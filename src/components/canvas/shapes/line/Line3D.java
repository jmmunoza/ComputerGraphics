package components.canvas.shapes.line;

import components.canvas.CanvasMapper;
import components.canvas.shapes.line.clipping.LineClippingResult;
import components.canvas.transformations.Transformation;
import components.canvas.transformations.TransformationData;
import math.point.Point3D;
import math.vector.Vector3D;

import java.awt.*;

public class Line3D extends Line {
    protected double z1;
    protected double z2;

    public Line3D(double x1, double y1, double z1, double x2, double y2, double z2) {
        super(x1, y1, x2, y2);

        this.z1 = z1;
        this.z2 = z2;
    }

    public Line3D() {
        this(0, 0, 0, 0, 0, 0);
    }

    public Line3D(Point3D point1, Point3D point2) {
        this(point1.getX(), point1.getY(), point1.getZ(), point2.getX(), point2.getY(), point2.getZ());
    }

    @Override
    public void draw(Graphics g) {
        if (hidden) return;

        Vector3D transformed1 = camera.transformCoords(x1, y1, z1);
        Vector3D transformed2 = camera.transformCoords(x2, y2, z2);

        int h = g.getClipBounds().height;
        int w = g.getClipBounds().width;

        LineClippingResult result = clippingAlgorithm.clip(
                (int) transformed1.x,
                (int) transformed1.y,
                (int) transformed2.x,
                (int) transformed2.y,
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
        TransformationData t1 = t.transform(TransformationData.create3D(x1, y1, z1));
        TransformationData t2 = t.transform(TransformationData.create3D(x2, y2, z2));

        x1 = t1.x;
        y1 = t1.y;
        z1 = t1.z;
        x2 = t2.x;
        y2 = t2.y;
        z2 = t2.z;

        onMovement();
    }

    @Override
    public double getZ() {
        return Math.max(z1, z2);
    }

    @Override
    public double getDepth() {
        return Math.abs(Math.max(z1, z2) - Math.min(z1, z2));
    }

    public void setZ2(double z2) {
        this.z2 = z2;

        onMovement();
    }

    public void setZ1(double z1) {
        this.z1 = z1;

        onMovement();
    }

    @Override
    public double getZCenter() {
        return Math.abs(z2 - z1) / 2;
    }
}
