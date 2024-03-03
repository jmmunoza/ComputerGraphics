package weeks.week3;

import components.canvas.Canvas;
import components.canvas.components.cartesianplane.CartesianPlane;
import components.canvas.components.dimensiontext.DimensionText;
import components.canvas.components.linesegmentvisualizer.LineSegmentVisualizer;
import components.canvas.components.positiontext.PositionText;
import components.canvas.shapes.ShapeComposite;
import components.frame.Frame;
import math.parametricequation.LineSegment;

public class Week3LineSegment {
    public static void main(String[] args) {
        ShapeComposite composite = generateCanvasComponents();
        Canvas canvas = new Canvas(composite);

        Frame frame = new Frame("Week 3 - Line segment", canvas);
        frame.show();
    }

    public static ShapeComposite generateCanvasComponents() {
        ShapeComposite composite = new ShapeComposite();

        LineSegment lineSegment1 = new LineSegment(200, 300, 145, 150);
        LineSegment lineSegment2 = new LineSegment(200, 5, -75, -32);

        composite.add(
                new CartesianPlane(),
                new LineSegmentVisualizer(lineSegment1, lineSegment2),
                new DimensionText(),
                new PositionText());

        return composite;
    }
}