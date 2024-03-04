package components.canvas.components.cartesianplane;

import components.canvas.listeners.CanvasResizeListener;
import components.canvas.observers.CanvasResizeObserver;
import components.canvas.shapes.ShapeComposite;
import components.canvas.shapes.line.Line;

import java.awt.*;

public class CartesianPlane extends ShapeComposite implements CanvasResizeListener {
    private final Line xLine;
    private final Line yLine;

    public CartesianPlane() {
        xLine = new Line();
        xLine.setColor(Color.RED);

        yLine = new Line();
        yLine.setColor(Color.GREEN);

        add(xLine, yLine);

        CanvasResizeObserver.attachListener(this);
    }

    @Override
    public void onResize(double width, double height) {
        int padding = 30;

        xLine.setX1((-width / 2) + padding);
        xLine.setY1(0);
        xLine.setX2((width / 2) - padding);
        xLine.setY2(0);

        yLine.setX1(0);
        yLine.setY1((-height / 2) + padding);
        yLine.setX2(0);
        yLine.setY2((height / 2) - padding);
    }
}