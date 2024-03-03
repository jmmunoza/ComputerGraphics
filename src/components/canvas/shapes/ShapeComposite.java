package components.canvas.shapes;

import components.canvas.transformations.Transformation;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShapeComposite extends BaseShape {
    private final List<Shape> children = new ArrayList<>();

    public ShapeComposite(int x, int y, Color color) {
        super(x, y, color);
    }

    public ShapeComposite(int x, int y) {
        super(x, y);
    }

    public ShapeComposite() {
        super(0, 0);
    }

    public ShapeComposite(Color color) {
        super(0, 0, color);
    }

    public void add(Shape child) {
        children.add(child);
    }

    public void add(Shape... components) {
        children.addAll(Arrays.asList(components));
    }

    public void remove(Shape child) {
        children.remove(child);
    }

    @Override
    public void draw(Graphics g) {
        for (Shape child : children) {
            child.draw(g);
        }
    }

    @Override
    public void transform(Transformation t) {
        for (Shape child : children) {
            child.transform(t);
        }
    }

    @Override
    public int getWidth() {
        return 0;
    }

    @Override
    public int getHeight() {
        return 0;
    }

    @Override
    public int getX() {
        if (children.isEmpty()) return 0;

        int x = children.getFirst().getX();

        for (Shape child : children) {
            if (child.getX() < x) {
                x = child.getX();
            }
        }

        return x;
    }

    @Override
    public int getY() {
        if (children.isEmpty()) return 0;

        int y = children.getFirst().getY();

        for (Shape child : children) {
            if (child.getY() > y) {
                y = child.getY();
            }
        }

        return y;
    }

    @Override
    public void show() {
        for (Shape child : children) {
            child.show();
        }
    }

    @Override
    public void hide() {
        for (Shape child : children) {
            child.hide();
        }
    }

    @Override
    public void setColor(Color color) {
        for (Shape child : children) {
            child.setColor(color);
        }
    }
}
