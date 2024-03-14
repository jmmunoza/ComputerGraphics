package components.canvas.shapes.text;

import components.canvas.CanvasMapper;
import components.canvas.shapes.BaseShape;
import math.vector.Vector3D;

import java.awt.*;

public class Text3D extends BaseShape {
    public String text;
    private double z;

    public Text3D(double x, double y, double z, String text) {
        super(x, y);

        this.z = z;
        this.text = text;
    }

    public Text3D(String text) {
        this(0, 0, 0, text);
    }

    public Text3D() {
        this(0, 0, 0, "");
    }

    public Text3D(double x, double y, double z) {
        this(x, y, z, "");
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public void draw(Graphics g) {
        if (hidden) return;

        int h = g.getClipBounds().height;
        int w = g.getClipBounds().width;

        Vector3D transformed = camera.transformCoords(x, y, z);

        double mappedX = CanvasMapper.mapXpToXj(transformed.x, w);
        double mappedY = CanvasMapper.mapYpToYj(transformed.y, h);

        g.setColor(color);

        g.drawString(text, (int) mappedX, (int) mappedY);
    }

    @Override
    public double getZ() {
        return z;
    }

    @Override
    public void setZ(double z) {
        this.z = z;

        onMovement();
    }
}
