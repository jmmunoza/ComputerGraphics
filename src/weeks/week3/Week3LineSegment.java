package weeks.week3;

import components.canvas.Canvas;
import components.canvas.CanvasComponent;
import components.canvas.components.cartesianplane.CartesianPlane;
import components.canvas.components.dimensiontext.DimensionText;
import components.canvas.components.linesegmentvisualizer.LineSegmentVisualizer;
import components.canvas.components.positiontext.PositionText;
import components.frame.Frame;
import math.parametricequation.LineSegment;

import java.util.ArrayList;
import java.util.List;

public class Week3LineSegment {
    public static void main(String[] args) {
        List<CanvasComponent> components = generateCanvasComponents();
        Canvas canvas = new Canvas(components);

        Frame frame = new Frame("Week 3 - Line segment", canvas);
        frame.show();
    }

    public static List<CanvasComponent> generateCanvasComponents() {
        List<CanvasComponent> components = new ArrayList<>();

        LineSegment lineSegment1 = new LineSegment(200, 300, 145, 150);
        LineSegment lineSegment2 = new LineSegment(200, 5, -75, -32);

        components.add(new CartesianPlane());
        components.add(new LineSegmentVisualizer(lineSegment1, lineSegment2));
        components.add(new DimensionText());
        components.add(new PositionText());

        return components;
    }
}