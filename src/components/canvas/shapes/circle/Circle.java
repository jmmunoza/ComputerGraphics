package components.canvas.shapes.circle;

import components.canvas.CanvasMapper;
import components.canvas.shapes.BaseShape;

import java.awt.*;

public class Circle extends BaseShape {
    private final int radius;

    public Circle(int x, int y, int radius) {
        super(x, y);

        this.radius = radius;
    }

    public Circle(int radius) {
        this(0, 0, radius);
    }

    public int getRadius() {
        return radius;
    }

    @Override
    public void draw(Graphics g) {
        if (hidden) return;

        int h = g.getClipBounds().height;
        int w = g.getClipBounds().width;

        int mappedX = CanvasMapper.mapXpToXj(x, w);
        int mappedY = CanvasMapper.mapYpToYj(y, h);

        int centeredX = mappedX - radius / 2;
        int centeredY = mappedY - radius / 2;

        g.setColor(color);
        g.drawOval(centeredX, centeredY, radius, radius);
    }

    @Override
    public int getWidth() {
        return radius * 2;
    }

    @Override
    public int getHeight() {
        return radius * 2;
    }
}
