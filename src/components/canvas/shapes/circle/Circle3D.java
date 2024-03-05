package components.canvas.shapes.circle;

import components.canvas.CanvasMapper;
import components.canvas.transformations.Transformation;
import components.canvas.transformations.TransformationData;
import components.canvas.transformations.projection.Projection;

import java.awt.*;

public class Circle3D extends Circle {
    private double z;

    public Circle3D(double x, double y, double z, double radius) {
        super(x, y, radius);

        this.z = z;
    }

    public Circle3D(double radius) {
        this(0, 0, 0, radius);
    }

    @Override
    public void draw(Graphics g) {
        if (hidden) return;

        int h = g.getClipBounds().height;
        int w = g.getClipBounds().width;

        Transformation transformation = new Projection(-500);
        TransformationData projection = transformation.transform(TransformationData.create3D(x, y, z));

        double mappedX = CanvasMapper.mapXpToXj(projection.x, w);
        double mappedY = CanvasMapper.mapYpToYj(projection.y, h);

        g.setColor(color);
        g.drawOval((int) mappedX, (int) mappedY, (int) getRadius(), (int) getRadius());
    }

    @Override
    public double getZCenter() {
        return z;
    }

    @Override
    public void setZ(double z) {
        this.z = z;
    }
}
