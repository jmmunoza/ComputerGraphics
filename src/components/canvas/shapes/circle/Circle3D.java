package components.canvas.shapes.circle;

import components.canvas.CanvasMapper;
import math.vector.Vector3D;

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

        Vector3D transformed = camera.transformCoords(x, y, z);

        int h = g.getClipBounds().height;
        int w = g.getClipBounds().width;

        double mappedX = CanvasMapper.mapXpToXj(transformed.x, w);
        double mappedY = CanvasMapper.mapYpToYj(transformed.y, h);

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

        onMovement();
    }
}
