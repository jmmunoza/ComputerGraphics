package components.canvas.shapes.text;

import components.canvas.CanvasMapper;
import components.canvas.CanvasShape;

import java.awt.*;

public class Text implements CanvasShape {
    private int x = 0;
    private int y = 0;
    private String text;

    public Text(String text) {
        this.text = text;
    }

    public Text() {
        text = "";
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public void draw(Graphics g) {
        int h = g.getClipBounds().height;
        int w = g.getClipBounds().width;

        int mappedX = CanvasMapper.mapXpToXj(x, w);
        int mappedY = CanvasMapper.mapYpToYj(y, h);

        g.drawString(text, mappedX, mappedY);
    }
}
