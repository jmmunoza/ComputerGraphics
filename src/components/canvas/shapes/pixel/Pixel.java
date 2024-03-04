package components.canvas.shapes.pixel;

import components.canvas.CanvasMapper;
import components.canvas.shapes.BaseShape;

import java.awt.*;

public class Pixel extends BaseShape {
    public Pixel(double x, double y, Color color) {
        super(x, y, color);
    }

    public Pixel(double x, double y) {
        super(x, y);
    }

    @Override
    public void draw(Graphics g) {
        if (hidden) return;

        int width = g.getClipBounds().width;
        int height = g.getClipBounds().height;

        double mappedX = CanvasMapper.mapXpToXj(x, width);
        double mappedY = CanvasMapper.mapYpToYj(y, height);

        g.setColor(color);
        g.drawOval((int) mappedX, (int) mappedY, 1, 1);
    }

    @Override
    public double getHeight() {
        return 1;
    }

    @Override
    public double getWidth() {
        return 1;
    }
}
