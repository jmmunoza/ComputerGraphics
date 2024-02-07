package components.canvas.shapes.rectangle;

import components.canvas.CanvasShape;
import components.canvas.shapes.line.Line;
import components.canvas.shapes.line.LineAlgorithm;

import java.awt.*;

public class Rectangle implements CanvasShape {
    private final Line lineTop;
    private final Line lineRight;
    private final Line lineLeft;
    private final Line lineAbove;

    private int x;
    private int y;
    private int w ;
    private int h;

    public Rectangle(int x, int y, int w, int h) {
        lineAbove = new Line(LineAlgorithm.BRESENHAM);
        lineLeft = new Line(LineAlgorithm.BRESENHAM);
        lineRight = new Line(LineAlgorithm.BRESENHAM);
        lineTop = new Line(LineAlgorithm.BRESENHAM);

        this.x = x;
        this.y = y;
        this.h = h;
        this.w = w;
    }

    public void setH(int h) {
        this.h = h;
    }

    public void setW(int w) {
        this.w = w;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public void draw(Graphics g) {
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

        lineTop.draw(g);
        lineRight.draw(g);
        lineLeft.draw(g);
        lineAbove.draw(g);
    }
}
