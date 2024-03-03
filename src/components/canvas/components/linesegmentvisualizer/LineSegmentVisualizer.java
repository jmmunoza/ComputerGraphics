package components.canvas.components.linesegmentvisualizer;

import components.canvas.components.coordstext.CoordsText;
import components.canvas.shapes.ShapeComposite;
import components.canvas.shapes.line.Line;
import math.parametricequation.LineSegment;
import math.parametricequation.LineSegmentSolveResult;

import java.awt.*;

public class LineSegmentVisualizer extends ShapeComposite {
    public LineSegmentVisualizer(LineSegment line1, LineSegment line2) {
        CoordsText interceptionPoint = new CoordsText();
        interceptionPoint.setColor(Color.ORANGE);

        Line lineShape1 = new Line((int) line1.x1, (int) line1.y1, (int) line1.x2, (int) line1.y2);
        Line lineShape2 = new Line((int) line2.x1, (int) line2.y1, (int) line2.x2, (int) line2.y2);

        lineShape1.setColor(Color.DARK_GRAY);
        lineShape2.setColor(Color.DARK_GRAY);

        LineSegmentSolveResult result = LineSegment.solve(line1, line2);

        if (result.success) {
            double x = line1.getX(result.u1);
            double y = line1.getY(result.u1);

            interceptionPoint.setCoords((int) x, (int) y);
        } else {
            interceptionPoint.hide();
        }

        add(interceptionPoint, lineShape1, lineShape2);
    }
}
