package components.canvas.components.cartesianplane;

import components.canvas.shapes.ShapeComposite;
import components.canvas.shapes.line.Line3D;

import java.awt.*;

public class CartesianPlane3D extends ShapeComposite {

    public CartesianPlane3D() {
        double LINES_LENGTH = 1000;

        Line3D xLine = new Line3D();
        xLine.setColor(Color.RED);
        xLine.setX1((-LINES_LENGTH));
        xLine.setX2((LINES_LENGTH));

        Line3D yLine = new Line3D();
        yLine.setColor(Color.GREEN);
        yLine.setY1((-LINES_LENGTH));
        yLine.setY2((LINES_LENGTH));

        Line3D zLine = new Line3D();
        zLine.setColor(Color.BLUE);
        zLine.setZ1((-LINES_LENGTH));
        zLine.setZ2((LINES_LENGTH));

        add(xLine, yLine, zLine);
    }
}