package week1.components.canvas.shapes;

import week1.components.canvas.listeners.CanvasMouseListener;
import week1.components.canvas.listeners.CanvasPaintListener;
import week1.components.canvas.observers.CanvasMouseObserver;
import week1.components.canvas.observers.CanvasPaintObserver;

import java.awt.*;
import java.awt.geom.Line2D;

public class DraggableLine implements CanvasMouseListener, CanvasPaintListener {
    private final Line2D.Double line;

    public DraggableLine() {
        line = new Line2D.Double();

        CanvasMouseObserver.attachListener(this);
        CanvasPaintObserver.attachListener(this);
    }

    @Override
    public void onMouseDragged(int x, int y) {
        line.x2 = x;
        line.y2 = y;
    }

    @Override
    public void onMouseMoved(int x, int y) {

    }

    @Override
    public void onMousePressed(int x, int y) {
        line.x2 = x;
        line.y2 = y;
        line.x1 = x;
        line.y1 = y;
    }

    @Override
    public void onMouseReleased(int x, int y) {
        line.x2 = x;
        line.y2 = y;
    }

    @Override
    public void onMouseEntered(int x, int y) {

    }

    @Override
    public void onMousedExited(int x, int y) {

    }

    @Override
    public void onPaint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Color.BLACK);
        g2d.draw(line);
    }
}
