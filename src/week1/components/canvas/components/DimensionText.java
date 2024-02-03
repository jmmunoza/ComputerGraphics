package week1.components.canvas.components;

import week1.components.canvas.CanvasMapper;
import week1.components.canvas.listeners.CanvasPaintListener;
import week1.components.canvas.listeners.CanvasResizeListener;
import week1.components.canvas.observers.CanvasPaintObserver;
import week1.components.canvas.observers.CanvasResizeObserver;

import java.awt.*;

public class DimensionText implements CanvasPaintListener, CanvasResizeListener {
    private int w = 0;
    private int h = 0;

    public DimensionText() {
        CanvasPaintObserver.attachListener(this);
        CanvasResizeObserver.attachListener(this);
    }

    @Override
    public void onPaint(Graphics g) {
        int x = 5;
        int mappedX = CanvasMapper.mapXpToXj(x, w);
        int y = 5;
        int mappedY = CanvasMapper.mapYpToYj(y, h);

        String text = "w=" + w + " h=" + h;

        g.setColor(Color.BLACK);
        g.drawString(text, mappedX, mappedY);
    }

    @Override
    public void onResize(int width, int height) {
        this.w = width;
        this.h = height;
    }
}
