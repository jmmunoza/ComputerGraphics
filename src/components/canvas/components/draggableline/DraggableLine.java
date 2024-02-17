package components.canvas.components.draggableline;

import components.canvas.CanvasComponent;
import components.canvas.listeners.CanvasMouseListener;
import components.canvas.listeners.CanvasPaintListener;
import components.canvas.observers.CanvasMouseObserver;
import components.canvas.observers.CanvasPaintObserver;
import components.canvas.shapes.line.Line;

import java.awt.*;

public class DraggableLine implements CanvasComponent, CanvasMouseListener, CanvasPaintListener {
    private final Line line;

    public DraggableLine() {
        line = new Line();
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

        g2d.setColor(Color.WHITE);

        line.draw(g);
    }

    @Override
    public void subscribe() {
        CanvasMouseObserver.attachListener(this);
        CanvasPaintObserver.attachListener(this);
    }
}
