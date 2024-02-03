package week1.components.canvas.shapes;

import week1.components.canvas.listeners.CanvasPaintListener;
import week1.components.canvas.listeners.CanvasResizeListener;
import week1.components.canvas.observers.CanvasPaintObserver;
import week1.components.canvas.observers.CanvasResizeObserver;

import java.awt.*;
import java.awt.geom.Line2D;

public class CartesianPlane implements CanvasResizeListener, CanvasPaintListener {
    private final Line2D.Double xLine;
    private final Line2D.Double yLine;

    public CartesianPlane() {
        xLine = new Line2D.Double();
        yLine = new Line2D.Double();

        CanvasResizeObserver.attachListener(this);
        CanvasPaintObserver.attachListener(this);
    }

    @Override
    public void onResize(int width, int height) {
        // x line
        xLine.x1 = 0;
        xLine.x2 = width;
        xLine.y1 = (double) height / 2;
        xLine.y2 = (double) height / 2;

        // y line
        yLine.x1 = (double) width / 2;
        yLine.x2 = (double) width / 2;
        yLine.y1 = 0;
        yLine.y2 = height;
    }

    @Override
    public void onPaint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;


        // x line
        g2d.setColor(Color.RED);
        g2d.draw(xLine);

        // y line
        g2d.setColor(Color.GREEN);
        g2d.draw(yLine);
    }
}