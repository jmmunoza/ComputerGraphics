package weeks.week1;

import components.canvas.Canvas;
import components.canvas.components.cartesianplane.CartesianPlane;
import components.canvas.components.dimensiontext.DimensionText;
import components.canvas.components.draggableline.DraggableLine;
import components.canvas.components.positiontext.PositionText;
import components.canvas.shapes.ShapeComposite;
import components.frame.Frame;

import javax.swing.*;

public class Week1 {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Week1::run);
    }

    public static void run() {
        ShapeComposite composite = new ShapeComposite();
        composite.add(
                new CartesianPlane(),
                new DraggableLine(),
                new PositionText(),
                new DimensionText());

        Canvas canvas = new Canvas(composite);

        Frame frame = new Frame("Week 1 - Bresenham's algorithm", canvas);
        frame.show();
    }
}
