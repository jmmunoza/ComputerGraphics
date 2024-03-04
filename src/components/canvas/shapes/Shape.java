package components.canvas.shapes;

import components.canvas.transformations.Transformation;

import java.awt.*;

public interface Shape {
    void draw(Graphics g);

    void transform(Transformation t);

    double getWidth();

    double getHeight();

    double getX();

    void setX(double x);

    double getY();

    void setY(double y);

    void show();

    void hide();

    void setColor(Color color);

    double getXCenter();

    double getYCenter();

    boolean isTransparent();
}
