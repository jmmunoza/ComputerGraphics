package components.canvas.components.lineclipping;

import components.canvas.listeners.CanvasMouseListener;
import components.canvas.listeners.CanvasResizeListener;
import components.canvas.observers.CanvasMouseObserver;
import components.canvas.observers.CanvasResizeObserver;
import components.canvas.shapes.ShapeComposite;
import components.canvas.shapes.line.Line;
import components.canvas.shapes.line.clipping.ILineClippingAlgorithm;
import components.canvas.shapes.line.clipping.LineClippingAlgorithm;
import components.canvas.shapes.line.clipping.LineClippingProvider;
import components.canvas.shapes.line.clipping.LineClippingResult;
import components.canvas.shapes.rectangle.Rectangle;
import components.canvas.shapes.text.Text;

import java.awt.*;

public class LineClipping extends ShapeComposite implements CanvasMouseListener, CanvasResizeListener {
    private final Text text;
    private final ILineClippingAlgorithm algorithm;
    private final Line clippedLine;
    private final Line line;
    private final double xMax = 200;
    private final double xMin = -200;
    private final double yMax = 100;
    private final double yMin = -100;
    private double x1 = 0;
    private double y1 = 0;
    private double x2 = 0;
    private double y2 = 0;

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

        LineClippingResult result = algorithm.clip((int) x1, (int) y1, (int) x2, (int) y2, (int) xMin, (int) yMin, (int) xMax, (int) yMax);

        clippedLine.setX1(result.x1);
        clippedLine.setY1(result.y1);
        clippedLine.setX2(result.x2);
        clippedLine.setY2(result.y2);

        if (result.draw) {
            clippedLine.show();
        } else {
            clippedLine.hide();
        }
    }

    @Override
    public void onMouseDragged(double x, double y) {
        x2 = x;
        y2 = y;

        updateLine();
    }

    @Override
    public void onMouseMoved(double x, double y) {

    }

    @Override
    public void onMousePressed(double x, double y) {
        x1 = x;
        y1 = y;
        x2 = x;
        y2 = y;

        updateLine();
    }

    @Override
    public void onMouseReleased(double x, double y) {
        x2 = x;
        y2 = y;

        updateLine();
    }

    @Override
    public void onMouseEntered(double x, double y) {

    }

    @Override
    public void onMousedExited(double x, double y) {

    }

    @Override
    public void onResize(double width, double height) {
        text.setX(-width / 2 + 10);
        text.setY(height / 2 - 20);
    }
}
