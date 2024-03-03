package components.canvas.shapes.rectangle;

import components.canvas.shapes.ShapeComposite;
import components.canvas.shapes.line.Line;

public class Rectangle extends ShapeComposite {
    private final Line lineTop;
    private final Line lineRight;
    private final Line lineLeft;
    private final Line lineAbove;

    private final int w;
    private final int h;

    public Rectangle(int x, int y, int w, int h) {
        super(x, y);

        lineAbove = new Line();
        lineLeft = new Line();
        lineRight = new Line();
        lineTop = new Line();

        this.h = h;
        this.w = w;

        add(lineAbove);
        add(lineLeft);
        add(lineRight);
        add(lineTop);

        setCoords();
    }

    private void setCoords() {
        lineAbove.setX1(x);
        lineAbove.setX2(x + w);
        lineAbove.setY1(y);
        lineAbove.setY2(y);

        lineTop.setX1(x);
        lineTop.setX2(x + w);
        lineTop.setY1(y - h);
        lineTop.setY2(y - h);

        lineLeft.setX1(x);
        lineLeft.setX2(x);
        lineLeft.setY1(y - h);
        lineLeft.setY2(y);

        lineRight.setX1(x + w);
        lineRight.setX2(x + w);
        lineRight.setY1(y - h);
        lineRight.setY2(y);
    }

    @Override
    public int getWidth() {
        return w;
    }

    @Override
    public int getHeight() {
        return h;
    }
}
