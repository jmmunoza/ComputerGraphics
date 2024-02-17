package components.canvas.components.coordstext;

import components.canvas.CanvasComponent;
import components.canvas.listeners.CanvasPaintListener;
import components.canvas.observers.CanvasPaintObserver;
import components.canvas.shapes.circle.Circle;
import components.canvas.shapes.text.Text;

import java.awt.*;

public class CoordsText implements CanvasComponent, CanvasPaintListener {
    private final Text text;
    private final Circle circle;
    private boolean show;

    public CoordsText() {
        int radius = 6;

        this.text = new Text();
        this.circle = new Circle(radius);
        show = true;
    }

    public void setCoords(int x, int y) {
        String positionText = "(" + x + ", " + y + ")";

        int padding = 10;
        text.setCoords(x + padding, y + padding);
        text.setText(positionText);

        circle.setCoords(x, y);
    }

    public void show() {
        show = true;
    }

    public void hide() {
        show = false;
    }

    @Override
    public void onPaint(Graphics g) {
        if (!show) return;

        text.draw(g);
        circle.draw(g);
    }

    @Override
    public void subscribe() {
        CanvasPaintObserver.attachListener(this);
    }
}