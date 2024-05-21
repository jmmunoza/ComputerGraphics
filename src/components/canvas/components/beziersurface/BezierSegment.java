package components.canvas.components.beziersurface;

import components.canvas.shapes.ShapeComposite;
import components.canvas.shapes.line.Line3D;
import math.point.Point3D;

public class BezierSegment extends ShapeComposite {
    public BezierSegment(Point3D p1, Point3D p2, Point3D p3, Point3D p4) {
        add(new Line3D(p1, p2));
        add(new Line3D(p2, p3));
        add(new Line3D(p3, p4));
        add(new Line3D(p4, p1));
        add(new Line3D(p1, p3));
        add(new Line3D(p2, p4));
    }
}