package components.canvas.shapes.text;

import components.canvas.CanvasMapper;
import components.canvas.shapes.BaseShape;

import java.awt.*;

public class Text extends BaseShape {
    public String text;

    public Text(int x, int y, String text) {
        super(x, y);

        this.text = text;
    }

    public Text(String text) {
        this(0, 0, text);
    }

    public Text() {
        this(0, 0, "");
    }

    public Text(int x, int y) {
        this(x, y, "");
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public void draw(Graphics g) {
        if (hidden) return;

        int h = g.getClipBounds().height;
        int w = g.getClipBounds().width;

        int mappedX = CanvasMapper.mapXpToXj(x, w);
        int mappedY = CanvasMapper.mapYpToYj(y, h);

        g.setColor(color);
        g.drawString(text, mappedX, mappedY);
    }
}
