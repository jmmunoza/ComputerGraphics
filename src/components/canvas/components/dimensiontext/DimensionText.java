package components.canvas.components.dimensiontext;

import components.canvas.CanvasComponent;
import components.canvas.listeners.CanvasPaintListener;
import components.canvas.listeners.CanvasResizeListener;
import components.canvas.observers.CanvasPaintObserver;
import components.canvas.observers.CanvasResizeObserver;
import components.canvas.shapes.text.Text;

import java.awt.*;

public class DimensionText implements CanvasComponent, CanvasPaintListener, CanvasResizeListener {
    private final Text text;
    private int w = 0;
    private int h = 0;

    public DimensionText() {
        text = new Text();
    }

    @Override
    public void onPaint(Graphics g) {
        g.setColor(Color.WHITE);

        String dimensionText = "w=" + w + " h=" + h;
        text.setText(dimensionText);
        text.draw(g);
    }

    @Override
    public void onResize(int width, int height) {
        this.w = width;
        this.h = height;

        int padding = 10;
        text.setX((-w / 2) + padding);
        text.setY((-h / 2) + padding);
    }

    @Override
    public void subscribe() {
        CanvasPaintObserver.attachListener(this);
        CanvasResizeObserver.attachListener(this);
    }
}
