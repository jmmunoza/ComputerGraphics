package components.canvas.shapes;

import components.canvas.transformations.Transformation;

import java.awt.*;

public interface Shape {
    void draw(Graphics g);

    void transform(Transformation t);

    int getWidth();

    int getHeight();

    int getX();

    void setX(int x);

    int getY();

    void setY(int y);

    void show();

    void hide();

    void setColor(Color color);
}
