package components.canvas.components.coordstext;

import components.canvas.shapes.ShapeComposite;
import components.canvas.shapes.circle.Circle;
import components.canvas.shapes.text.Text;

import java.awt.*;

public class CoordsText extends ShapeComposite {
    private final Text text;
    private final Circle circle;

    public CoordsText() {
        super(Color.DARK_GRAY);

        text = new Text();
        circle = new Circle(6);

        add(text);
        add(circle);
    }

    public void setCoords(double x, double y) {
        String positionText = "(" + (int) x + ", " + (int) y + ")";
        int padding = 10;

        text.setText(positionText);
        text.setX(x + padding);
        text.setY(y + padding);

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