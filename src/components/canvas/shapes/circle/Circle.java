package components.canvas.shapes.circle;

import components.canvas.CanvasMapper;
import components.canvas.CanvasShape;

import java.awt.*;

public class Circle implements CanvasShape {
    private int x;
    private int y;
    private int radius;
    private boolean show;

    public Circle(int x, int y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.show = true;
    }

    public Circle(int radius) {
        this(0, 0, radius);
    }

    public void show() {
        show = true;
    }

    public void hide() {
        show = false;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setCoords(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public void draw(Graphics g) {
        if (!show) return;

        int h = g.getClipBounds().height;
        int w = g.getClipBounds().width;

        int mappedX = CanvasMapper.mapXpToXj(x, w);
        int mappedY = CanvasMapper.mapYpToYj(y, h);

        int centeredX = mappedX - radius / 2;
        int centeredY = mappedY - radius / 2;

        g.drawOval(centeredX, centeredY, radius, radius);
    }
}
