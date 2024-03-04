package components.canvas.shapes.circle;

import components.canvas.CanvasMapper;
import components.canvas.shapes.BaseShape;

import java.awt.*;

public class Circle extends BaseShape {
    private final double radius;

    public Circle(double x, double y, double radius) {
        super(x, y);

        this.radius = radius;
    }

    public Circle(double radius) {
        this(0, 0, radius);
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public void draw(Graphics g) {
        if (hidden) return;

        int h = g.getClipBounds().height;
        int w = g.getClipBounds().width;

        double mappedX = CanvasMapper.mapXpToXj(x, w);
        double mappedY = CanvasMapper.mapYpToYj(y, h);

        g.setColor(color);
        g.drawOval((int) mappedX, (int) mappedY, (int) radius, (int) radius);
    }

    @Override
    public double getWidth() {
        return radius * 2;
    }

    @Override
    public double getHeight() {
        return radius * 2;
    }

    @Override
    public double getYCenter() {
        return y - radius / 2;

    }

    @Override
    public double getXCenter() {
        return x + radius / 2;
    }
}
