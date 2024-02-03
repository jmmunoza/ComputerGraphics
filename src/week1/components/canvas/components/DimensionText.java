package week1.components.canvas.components;

import week1.components.canvas.CanvasComponent;
import week1.components.canvas.listeners.CanvasPaintListener;
import week1.components.canvas.listeners.CanvasResizeListener;
import week1.components.canvas.observers.CanvasPaintObserver;
import week1.components.canvas.observers.CanvasResizeObserver;
import week1.components.canvas.shapes.text.Text;

import java.awt.*;

public class DimensionText implements CanvasComponent, CanvasPaintListener, CanvasResizeListener {
    private final Text text;
    private int w = 0;
    private int h = 0;

    public DimensionText() {
        text = new Text();
        text.setX(5);
        text.setY(5);
    }

    @Override
    public void onPaint(Graphics g) {
        g.setColor(Color.BLACK);

        String dimensionText = "w=" + w + " h=" + h;
        text.setText(dimensionText);
        text.draw(g);
    }

    @Override
    public void onResize(int width, int height) {
        this.w = width;
        this.h = height;
    }

    @Override
    public void subscribe() {
        CanvasPaintObserver.attachListener(this);
        CanvasResizeObserver.attachListener(this);
    }
}
