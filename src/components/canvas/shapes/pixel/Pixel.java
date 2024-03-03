package components.canvas.shapes.pixel;

import components.canvas.CanvasMapper;
import components.canvas.shapes.BaseShape;

import java.awt.*;

public class Pixel extends BaseShape {
    public Pixel(int x, int y, Color color) {
        super(x, y, color);
    }

    public Pixel(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw(Graphics g) {
        if (hidden) return;

        int width = g.getClipBounds().width;
        int height = g.getClipBounds().height;

        int mappedX = CanvasMapper.mapXpToXj(x, width);
        int mappedY = CanvasMapper.mapYpToYj(y, height);

        g.setColor(color);
        g.drawOval(mappedX, mappedY, 1, 1);
    }

    @Override
    public int getHeight() {
        return 1;
    }

    @Override
    public int getWidth() {
        return 1;
    }
}
