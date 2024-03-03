package components.canvas.components.lineclipping;

import components.canvas.listeners.CanvasMouseListener;
import components.canvas.listeners.CanvasResizeListener;
import components.canvas.observers.CanvasMouseObserver;
import components.canvas.observers.CanvasResizeObserver;
import components.canvas.shapes.ShapeComposite;
import components.canvas.shapes.line.Line;
import components.canvas.shapes.rectangle.Rectangle;
import components.canvas.shapes.text.Text;

import java.awt.*;

public class LineClipping extends ShapeComposite implements CanvasMouseListener, CanvasResizeListener {
    private final Text text;
    private final ILineClippingAlgorithm algorithm;
    private final Line clippedLine;
    private final Line line;
    private final int xMax = 200;
    private final int xMin = -200;
    private final int yMax = 100;
    private final int yMin = -100;
    private int x1 = 0;
    private int y1 = 0;
    private int x2 = 0;
    private int y2 = 0;

    public LineClipping(LineClippingAlgorithm algorithmType) {
        Rectangle rectangle = new Rectangle(xMin, yMax, xMax - xMin, yMax - yMin);
        rectangle.setColor(Color.DARK_GRAY);

        clippedLine = new Line();
        clippedLine.setColor(Color.GREEN);

        line = new Line();
        line.setColor(Color.RED);

        text = new Text(algorithmType.toString());
        text.setColor(Color.WHITE);

        algorithm = LineClippingProvider.inject(algorithmType);

        add(rectangle, line, clippedLine, text);

        CanvasMouseObserver.attachListener(this);
        CanvasResizeObserver.attachListener(this);
    }

    private void updateLine() {
        line.setX1(x1);
        line.setY1(y1);
        line.setX2(x2);
        line.setY2(y2);

        boolean draw = algorithm.clip(clippedLine, x1, y1, x2, y2, xMin, yMin, xMax, yMax);

        if (draw) {
            clippedLine.show();
        } else {
            clippedLine.hide();
        }
    }

    @Override
    public void onMouseDragged(int x, int y) {
        x2 = x;
        y2 = y;

        updateLine();
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

        updateLine();
    }

    @Override
    public void onMouseReleased(int x, int y) {
        x2 = x;
        y2 = y;

        updateLine();
    }

    @Override
    public void onMouseEntered(int x, int y) {

    }

    @Override
    public void onMousedExited(int x, int y) {

    }

    @Override
    public void onResize(int width, int height) {
        text.setX(-width / 2 + 10);
        text.setY(height / 2 - 20);
    }
}
