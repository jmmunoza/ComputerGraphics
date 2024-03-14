package components.canvas.shapes;

import components.canvas.cameras.Camera;
import components.canvas.transformations.Transformation;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShapeComposite extends BaseShape {
    private final List<Shape> children = new ArrayList<>();

    public ShapeComposite(double x, double y, Color color) {
        super(x, y, color);
    }

    public ShapeComposite(double x, double y) {
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

        onMovement();
    }

    @Override
    public double getWidth() {
        double xMax = children.getFirst().getWidth() + children.getFirst().getX();

        for (Shape child : children) {
            if (child.isTransparent()) continue;

            double x = child.getWidth() + child.getX();

            if (xMax < x) {
                xMax = x;
            }
        }

        double xMin = getX();

        return Math.abs(Math.max(xMin, xMax) - Math.min(xMin, xMax));
    }

    @Override
    public double getHeight() {
        double yMin = children.getFirst().getY() - children.getFirst().getHeight();

        for (Shape child : children) {
            if (child.isTransparent()) continue;

            double y = (child.getY() - child.getHeight());

            if (yMin > y) {
                yMin = y;
            }
        }

        double yMax = getY();

        return Math.abs(Math.max(yMax, yMin) - Math.min(yMax, yMin));
    }

    @Override
    public double getDepth() {
        double zMin = children.getFirst().getZ() - children.getFirst().getDepth();

        for (Shape child : children) {
            if (child.isTransparent()) continue;

            double z = (child.getZ() - child.getDepth());

            if (zMin > z) {
                zMin = z;
            }
        }

        double zMax = getZ();

        return Math.abs(Math.max(zMax, zMin) - Math.min(zMax, zMin));
    }

    @Override
    public double getX() {
        if (children.isEmpty()) return 0;

        double x = children.getFirst().getX();

        for (Shape child : children) {
            if (child.isTransparent()) continue;

            if (child.getX() < x) {
                x = child.getX();
            }
        }

        return x;
    }

    @Override
    public double getY() {
        if (children.isEmpty()) return 0;

        double y = children.getFirst().getY();

        for (Shape child : children) {
            if (child.isTransparent()) continue;

            if (child.getY() > y) {
                y = child.getY();
            }
        }

        return y;
    }

    @Override
    public double getZ() {
        if (children.isEmpty()) return 0;

        double z = children.getFirst().getZ();

        for (Shape child : children) {
            if (child.isTransparent()) continue;

            if (child.getZ() > z) {
                z = child.getZ();
            }
        }

        return z;
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

    @Override
    public double getXCenter() {
        return getX() + getWidth() / 2;
    }

    @Override
    public double getYCenter() {
        return getY() - getHeight() / 2;
    }

    @Override
    public double getZCenter() {
        return getZ() - getDepth() / 2;
    }

    @Override
    public void setCamera(Camera camera) {
        for (Shape child : children) {
            child.setCamera(camera);
        }
    }


}
