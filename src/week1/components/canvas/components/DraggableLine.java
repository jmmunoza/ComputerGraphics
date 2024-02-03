package week1.components.canvas.components;

import week1.components.canvas.listeners.CanvasMouseListener;
import week1.components.canvas.listeners.CanvasPaintListener;
import week1.components.canvas.observers.CanvasMouseObserver;
import week1.components.canvas.observers.CanvasPaintObserver;
import week1.components.canvas.shapes.line.Line;

import java.awt.*;

public class DraggableLine implements CanvasMouseListener, CanvasPaintListener {
    private final Line line;

    public DraggableLine() {
        line = new Line();

        CanvasMouseObserver.attachListener(this);
        CanvasPaintObserver.attachListener(this);
    }

    @Override
    public void onMouseDragged(int x, int y) {
        line.setX2(x);
        line.setY2(y);
    }

    @Override
    public void onMouseMoved(int x, int y) {

    }

    @Override
    public void onMousePressed(int x, int y) {
        line.setX2(x);
        line.setY2(y);
        line.setX1(x);
        line.setY1(y);
    }

    @Override
    public void onMouseReleased(int x, int y) {
        line.setX2(x);
        line.setY2(y);
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

        line.draw(g);
    }
}
