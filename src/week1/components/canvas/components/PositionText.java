package week1.components.canvas.components;

import week1.components.canvas.CanvasComponent;
import week1.components.canvas.listeners.CanvasMouseListener;
import week1.components.canvas.listeners.CanvasPaintListener;
import week1.components.canvas.observers.CanvasMouseObserver;
import week1.components.canvas.observers.CanvasPaintObserver;
import week1.components.canvas.shapes.text.Text;

import java.awt.*;

public class PositionText implements CanvasComponent, CanvasMouseListener, CanvasPaintListener {
    private final Text text;
    private int x = 0;
    private int y = 0;
    private boolean show = false;

    public PositionText() {
        text = new Text();
    }

    @Override
    public void onMouseDragged(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void onMouseMoved(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void onMousePressed(int x, int y) {

    }

    @Override
    public void onMouseReleased(int x, int y) {

    }

    @Override
    public void onMouseEntered(int x, int y) {
        show = true;
    }

    @Override
    public void onMousedExited(int x, int y) {
        show = false;
    }

    @Override
    public void onPaint(Graphics g) {
        if (!show) return;

        int padding = 5;

        text.setX(x + padding);
        text.setY(y + padding);

        String positionText = "(" + x + ", " + y + ")";
        g.setColor(Color.BLACK);

        text.setText(positionText);
        text.draw(g);
    }

    @Override
    public void subscribe() {
        CanvasMouseObserver.attachListener(this);
        CanvasPaintObserver.attachListener(this);
    }
}
