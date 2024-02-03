package week1.components.canvas.shapes;

import week1.components.canvas.listeners.CanvasMouseListener;
import week1.components.canvas.listeners.CanvasPaintListener;
import week1.components.canvas.listeners.CanvasResizeListener;
import week1.components.canvas.observers.CanvasMouseObserver;
import week1.components.canvas.observers.CanvasPaintObserver;
import week1.components.canvas.observers.CanvasResizeObserver;

import java.awt.*;

public class PositionText implements CanvasMouseListener, CanvasPaintListener, CanvasResizeListener {
    private int x = 0;
    private int y = 0;
    private int w = 0;
    private int h = 0;
    private boolean show = false;

    public PositionText() {
        CanvasMouseObserver.attachListener(this);
        CanvasPaintObserver.attachListener(this);
        CanvasResizeObserver.attachListener(this);
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

        g.setColor(Color.BLACK);
        g.drawString("(" + x + ", " + (h - y) + ") w=" + w + " h=" + h, x + 10, y - 10);
    }

    @Override
    public void onResize(int width, int height) {
        this.w = width;
        this.h = height;
    }
}
