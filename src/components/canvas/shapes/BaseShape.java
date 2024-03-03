package components.canvas.shapes;

import components.canvas.transformations.Transformation;
import components.canvas.transformations.TransformationData;

import java.awt.*;

public class BaseShape implements Shape {
    public int x;
    public int y;
    public boolean hidden;
    public Color color;

    public BaseShape(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.hidden = false;
        this.color = color;
    }

    public BaseShape(int x, int y) {
        this(x, y, Color.WHITE);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
    }

    @Override
    public void transform(Transformation t) {
        TransformationData dataToTransform = new TransformationData(x, y);

        TransformationData result = t.transform(dataToTransform);

        x = result.x;
        y = result.y;
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
        return x;
    }

    @Override
    public void setX(int x) {
        this.x = x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public void setY(int y) {
        this.y = y;
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
}
