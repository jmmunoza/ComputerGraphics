package weeks.week2;

import components.canvas.Canvas;
import components.canvas.components.dimensiontext.DimensionText;
import components.canvas.components.lineclipping.LineClipping;
import components.canvas.components.positiontext.PositionText;
import components.canvas.shapes.ShapeComposite;
import components.canvas.shapes.line.clipping.LineClippingAlgorithm;
import components.frame.Frame;

public class Week2 {
    public static void main(String[] args) {
        ShapeComposite composite = new ShapeComposite();
        composite.add(
                new LineClipping(LineClippingAlgorithm.COHEN_SUTHERLAND),
                new DimensionText(),
                new PositionText());

        Canvas canvas = new Canvas(composite);

        Frame frame = new Frame("Week 2 - Line clipping", canvas);
        frame.show();
    }
}