package components.canvas.components.linesegmentvisualizer;

import components.canvas.CanvasComponent;
import components.canvas.components.coordstext.CoordsText;
import components.canvas.listeners.CanvasPaintListener;
import components.canvas.observers.CanvasPaintObserver;
import components.canvas.shapes.line.Line;
import math.parametricequation.LineSegment;
import math.parametricequation.LineSegmentSolveResult;

import java.awt.*;

public class LineSegmentVisualizer implements CanvasComponent, CanvasPaintListener {

    private final Line lineShape1;
    private final Line lineShape2;
    private final CoordsText interceptionPoint;

    public LineSegmentVisualizer(LineSegment line1, LineSegment line2) {
        interceptionPoint = new CoordsText();

        lineShape1 = new Line((int) line1.x1, (int) line1.y1, (int) line1.x2, (int) line1.y2);
        lineShape2 = new Line((int) line2.x1, (int) line2.y1, (int) line2.x2, (int) line2.y2);

        LineSegmentSolveResult result = LineSegment.solve(line1, line2);

        if (result.success) {
            double x = line1.getX(result.u1);
            double y = line1.getY(result.u1);

            interceptionPoint.setCoords((int) x, (int) y);
        } else {
            interceptionPoint.hide();
        }
    }


    @Override
    public void onPaint(Graphics g) {
        g.setColor(Color.DARK_GRAY);
        lineShape1.draw(g);
        lineShape2.draw(g);

        g.setColor(Color.ORANGE);
        interceptionPoint.onPaint(g);
    }

    @Override
    public void subscribe() {
        CanvasPaintObserver.attachListener(this);
    }
}
