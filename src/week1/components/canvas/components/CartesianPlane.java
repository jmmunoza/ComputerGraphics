package week1.components.canvas.components;

import week1.components.canvas.listeners.CanvasPaintListener;
import week1.components.canvas.listeners.CanvasResizeListener;
import week1.components.canvas.observers.CanvasPaintObserver;
import week1.components.canvas.observers.CanvasResizeObserver;
import week1.components.canvas.shapes.line.Line;

import java.awt.*;

public class CartesianPlane implements CanvasResizeListener, CanvasPaintListener {
    private final Line xLine;
    private final Line yLine;

    public CartesianPlane() {
        xLine = new Line();
        yLine = new Line();

        CanvasResizeObserver.attachListener(this);
        CanvasPaintObserver.attachListener(this);
    }

    @Override
    public void onResize(int width, int height) {
        // x line
        xLine.setX1(0);
        xLine.setX2(width);
        xLine.setY1(height / 2);
        xLine.setY2(height / 2);

        // y line
        yLine.setX1(width / 2);
        yLine.setX2(width / 2);
        yLine.setY1(0);
        yLine.setY2(height);
    }

    @Override
    public void onPaint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        // x line
        g2d.setColor(Color.RED);
        xLine.draw(g);

        // y line
        g2d.setColor(Color.GREEN);
        yLine.draw(g);
    }
}