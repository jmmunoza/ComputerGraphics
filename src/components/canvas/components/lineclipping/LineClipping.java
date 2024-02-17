package components.canvas.components.lineclipping;

import components.canvas.CanvasComponent;
import components.canvas.listeners.CanvasMouseListener;
import components.canvas.listeners.CanvasPaintListener;
import components.canvas.listeners.CanvasResizeListener;
import components.canvas.observers.CanvasMouseObserver;
import components.canvas.observers.CanvasPaintObserver;
import components.canvas.observers.CanvasResizeObserver;
import components.canvas.shapes.line.Line;
import components.canvas.shapes.rectangle.Rectangle;
import components.canvas.shapes.text.Text;

import java.awt.*;

public class LineClipping implements CanvasComponent, CanvasPaintListener, CanvasMouseListener, CanvasResizeListener {
    private final Rectangle rectangle;
    private final Text text;
    private final ILineClippingAlgorithm algorithm;
    private final Line clippedLine;
    private final int xMax = 200;
    private final int xMin = -200;
    private final int yMax = 100;
    private final int yMin = -100;
    private int x1 = 0;
    private int y1 = 0;
    private int x2 = 0;
    private int y2 = 0;

    public LineClipping(LineClippingAlgorithm algorithmType) {
        rectangle = new Rectangle(xMin, yMax, xMax - xMin, yMax - yMin);
        clippedLine = new Line();
        text = new Text(algorithmType.toString());
        algorithm = LineClippingProvider.inject(algorithmType);
    }

    @Override
    public void subscribe() {
        CanvasMouseObserver.attachListener(this);
        CanvasPaintObserver.attachListener(this);
        CanvasResizeObserver.attachListener(this);
    }

    @Override
    public void onPaint(Graphics g) {
        clippedLine.setX1(x1);
        clippedLine.setY1(y1);
        clippedLine.setX2(x2);
        clippedLine.setY2(y2);
        g.setColor(Color.RED);
        clippedLine.draw(g);

        boolean draw = algorithm.clip(clippedLine, x1, y1, x2, y2, xMin, yMin, xMax, yMax);

        if (draw) {
            g.setColor(Color.GREEN);
            clippedLine.draw(g);
        }

        g.setColor(Color.DARK_GRAY);
        rectangle.draw(g);

        g.setColor(Color.WHITE);
        text.draw(g);
    }


    @Override
    public void onMouseDragged(int x, int y) {
        x2 = x;
        y2 = y;
    }

    @Override
    public void onMouseMoved(int x, int y) {

    }

    @Override
    public void onMousePressed(int x, int y) {
        x1 = x;
        y1 = y;
        x2 = x;
        y2 = y;
    }

    @Override
    public void onMouseReleased(int x, int y) {
        x2 = x;
        y2 = y;
    }

    @Override
    public void onMouseEntered(int x, int y) {

    }

    @Override
    public void onMousedExited(int x, int y) {

    }

    @Override
    public void onResize(int width, int height) {
        text.setY(height / 2 - 20);
        text.setX(-width / 2 + 10);
    }
}
