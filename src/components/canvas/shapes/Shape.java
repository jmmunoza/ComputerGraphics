package components.canvas.shapes;

import components.canvas.cameras.Camera;
import components.canvas.listeners.ShapePositionListener;
import components.canvas.transformations.Transformation;

import java.awt.*;

public interface Shape {
    void draw(Graphics g);

    void transform(Transformation t);

    double getWidth();

    double getHeight();

    double getDepth();

    double getX();

    void setX(double x);

    double getY();

    void setY(double y);

    double getZ();

    void setZ(double z);

    void show();

    void hide();

    void setColor(Color color);

    double getXCenter();

    double getYCenter();

    double getZCenter();

    boolean isTransparent();

    void setCamera(Camera camera);

    void onMovement();

    void addShapePositionListener(ShapePositionListener listener);

    void removeShapePositionListener(ShapePositionListener listener);
}
