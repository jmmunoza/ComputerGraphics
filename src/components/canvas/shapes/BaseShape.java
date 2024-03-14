package components.canvas.shapes;

import components.canvas.cameras.Camera;
import components.canvas.listeners.ShapePositionListener;
import components.canvas.transformations.Transformation;
import components.canvas.transformations.TransformationData;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class BaseShape implements Shape {
    public double x;
    public double y;
    public boolean hidden;
    public Color color;
    public Camera camera;
    public List<ShapePositionListener> positionListeners;

    public BaseShape(double x, double y, Color color) {
        this.x = x;
        this.y = y;
        this.hidden = false;
        this.color = color;
        this.positionListeners = new ArrayList<>();
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

        onMovement();
    }

    @Override
    public double getY() {
        return y;
    }

    @Override
    public void setY(double y) {
        this.y = y;

        onMovement();
    }

    @Override
    public double getZ() {
        return 0;
    }

    @Override
    public void setZ(double z) {
        onMovement();
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

    @Override
    public void setCamera(Camera camera) {
        this.camera = camera;
    }

    @Override
    public void onMovement() {
        for (ShapePositionListener listener : positionListeners) {
            listener.onCenterPositionUpdate(getXCenter(), getYCenter(), getZCenter());
            listener.onPositionUpdate(getX(), getY(), getZ());
        }
    }

    @Override
    public void addShapePositionListener(ShapePositionListener listener) {
        if (!positionListeners.contains(listener)) {
            positionListeners.add(listener);
        }
    }

    @Override
    public void removeShapePositionListener(ShapePositionListener listener) {
        positionListeners.remove(listener);
    }
}
