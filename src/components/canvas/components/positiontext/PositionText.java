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
    public void onMouseDragged(int x, int y) {
        updatePosition(x, y);
    }

    @Override
    public void onMouseMoved(int x, int y) {
        updatePosition(x, y);
    }

    @Override
    public void onMousePressed(int x, int y) {
        setColor(Color.DARK_GRAY);
    }

    @Override
    public void onMouseReleased(int x, int y) {
        setColor(Color.WHITE);
    }

    @Override
    public void onMouseEntered(int x, int y) {
        show();
    }

    @Override
    public void onMousedExited(int x, int y) {
        hide();
    }

    private void updatePosition(int x, int y) {
        String text = "(" + x + ", " + y + ")";
        int padding = 5;

        textShape.setText(text);
        textShape.setX(x + padding);
        textShape.setY(y + padding);

        circle.setX(x);
        circle.setY(y);
    }
}
