package components.canvas.shapes;

import components.canvas.transformations.Transformation;
import components.canvas.transformations.TransformationData;

import java.awt.*;

public class BaseShape implements Shape {
    public double x;
    public double y;
    public boolean hidden;
    public Color color;

    public BaseShape(double x, double y, Color color) {
        this.x = x;
        this.y = y;
        this.hidden = false;
        this.color = color;
    }

    public BaseShape(double x, double y) {
        this(x, y, Color.WHITE);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
    }

    @Override
    public void transform(Transformation t) {
        TransformationData dataToTransform = TransformationData.create2D(x, y);

        TransformationData result = t.transform(dataToTransform);

        x = result.x;
        y = result.y;
    }

    @Override
    public double getWidth() {
        return 0;
    }

    @Override
    public double getHeight() {
        return 0;
    }

    @Override
    public double getDepth() {
        return 0;
    }

    @Override
    public double getX() {
        return x;
    }

    @Override
    public void setX(double x) {
        this.x = x;
    }

    @Override
    public double getY() {
        return y;
    }

    @Override
    public void setY(double y) {
        this.y = y;
    }

    @Override
    public double getZ() {
        return 0;
    }

    @Override
    public void setZ(double z) {

    }

    @Override
    public void show() {
        hidden = false;
    }

    @Override
    public void hide() {
        hidden = true;
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public double getXCenter() {
        return x;
    }

    @Override
    public double getYCenter() {
        return y;
    }

    @Override
    public double getZCenter() {
        return 0;
    }

    @Override
    public boolean isTransparent() {
        return false;
    }
}
