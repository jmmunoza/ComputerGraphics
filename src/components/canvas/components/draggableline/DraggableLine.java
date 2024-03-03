package components.canvas.components.draggableline;

import components.canvas.listeners.CanvasMouseListener;
import components.canvas.observers.CanvasMouseObserver;
import components.canvas.shapes.ShapeComposite;
import components.canvas.shapes.line.Line;

import java.awt.*;

public class DraggableLine extends ShapeComposite implements CanvasMouseListener {
    private final Line line;

    public DraggableLine() {
        line = new Line();

        add(line);
        setColor(Color.LIGHT_GRAY);

        CanvasMouseObserver.attachListener(this);
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
}
