package components.canvas.shapes.pixel;

import components.canvas.CanvasMapper;

import java.awt.*;

public class Pixel {
    public static void setPixel(Graphics g, int x, int y) {
        int width = g.getClipBounds().width;
        int height = g.getClipBounds().height;

        int mappedX = CanvasMapper.mapXpToXj(x, width);
        int mappedY = CanvasMapper.mapYpToYj(y, height);

        g.drawOval(mappedX, mappedY, 1, 1);
    }
}
