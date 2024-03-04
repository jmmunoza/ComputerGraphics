package components.canvas.components.positiontext;

import components.canvas.listeners.CanvasMouseListener;
import components.canvas.observers.CanvasMouseObserver;
import components.canvas.shapes.ShapeComposite;
import components.canvas.shapes.circle.Circle;
import components.canvas.shapes.text.Text;

import java.awt.*;

public class PositionText extends ShapeComposite implements CanvasMouseListener {
    private final Text textShape;
    private final Circle circle;

    public PositionText() {
        textShape = new Text();
        circle = new Circle(5);

        add(textShape, circle);

        CanvasMouseObserver.attachListener(this);

        setColor(Color.WHITE);
        hide();
    }

    @Override
    public void onMouseDragged(double x, double y) {
        updatePosition(x, y);
    }

    @Override
    public void onMouseMoved(double x, double y) {
        updatePosition(x, y);
    }

    @Override
    public void onMousePressed(double x, double y) {
        setColor(Color.DARK_GRAY);
    }

    @Override
    public void onMouseReleased(double x, double y) {
        setColor(Color.WHITE);
    }

    @Override
    public void onMouseEntered(double x, double y) {
        show();
    }

    @Override
    public void onMousedExited(double x, double y) {
        hide();
    }

    private void updatePosition(double x, double y) {
        String text = "(" + (int) x + ", " + (int) y + ")";
        int padding = 5;

        textShape.setText(text);
        textShape.setX(x + padding);
        textShape.setY(y + padding);

        circle.setX(x - circle.getRadius() / 2);
        circle.setY(y + circle.getRadius() / 2);
    }

    @Override
    public double getWidth() {
        return 0;
    }

    @Override
    public double getHeight() {
        return 0;
    }
}
