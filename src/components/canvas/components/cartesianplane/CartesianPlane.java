package components.canvas.components.cartesianplane;

import components.canvas.CanvasComponent;
import components.canvas.listeners.CanvasPaintListener;
import components.canvas.listeners.CanvasResizeListener;
import components.canvas.observers.CanvasPaintObserver;
import components.canvas.observers.CanvasResizeObserver;
import components.canvas.shapes.line.Line;
import components.canvas.shapes.line.LineAlgorithm;

import java.awt.*;

public class CartesianPlane implements CanvasComponent, CanvasResizeListener, CanvasPaintListener {
    private final Line xLine;
    private final Line yLine;

    public CartesianPlane() {
        xLine = new Line(LineAlgorithm.BRESENHAM);
        yLine = new Line(LineAlgorithm.BRESENHAM);
    }

    @Override
    public void onResize(int width, int height) {
        int padding = 30;

        // x line
        xLine.setX1((-width / 2) + padding);
        xLine.setX2((width / 2) - padding);
        xLine.setY1(0);
        xLine.setY2(0);

        // y line
        yLine.setX1(0);
        yLine.setX2(0);
        yLine.setY1((-height / 2) + padding);
        yLine.setY2((height / 2) - padding);
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

    @Override
    public void subscribe() {
        CanvasResizeObserver.attachListener(this);
        CanvasPaintObserver.attachListener(this);
    }
}