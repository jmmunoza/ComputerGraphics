package components.canvas.shapes.line;

import components.canvas.CanvasMapper;
import components.canvas.transformations.Transformation;
import components.canvas.transformations.TransformationData;
import components.canvas.transformations.projection.Projection;
import math.point.Point3D;

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
        this(point1.x, point1.y, point1.z, point2.x, point2.y, point2.z);
    }

    @Override
    public void draw(Graphics g) {
        if (hidden) return;

        int h = g.getClipBounds().height;
        int w = g.getClipBounds().width;

        Transformation transformation = new Projection(-500);
        TransformationData projection1 = transformation.transform(TransformationData.create3D(x1, y1, z1));
        TransformationData projection2 = transformation.transform(TransformationData.create3D(x2, y2, z2));

        double mappedX1 = CanvasMapper.mapXpToXj(projection1.x, w);
        double mappedY1 = CanvasMapper.mapYpToYj(projection1.y, h);
        double mappedX2 = CanvasMapper.mapXpToXj(projection2.x, w);
        double mappedY2 = CanvasMapper.mapYpToYj(projection2.y, h);

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
    }

    public void setZ1(double z1) {
        this.z1 = z1;
    }

    @Override
    public double getZCenter() {
        return Math.abs(z2 - z1) / 2;
    }
}
