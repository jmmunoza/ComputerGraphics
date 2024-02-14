package weeks.week2;

import components.canvas.Canvas;
import components.canvas.CanvasComponent;
import components.canvas.components.dimensiontext.DimensionText;
import components.canvas.components.lineclipping.LineClipping;
import components.canvas.components.lineclipping.LineClippingAlgorithm;
import components.canvas.components.positiontext.PositionText;
import components.frame.Frame;

import java.util.ArrayList;

public class Week2 {
    public static void main(String[] args) {
        ArrayList<CanvasComponent> components = new ArrayList<>();
        components.add(new LineClipping(LineClippingAlgorithm.COHEN_SUTHERLAND));
        components.add(new DimensionText());
        components.add(new PositionText());

        Canvas canvas = new Canvas(components);

        Frame frame = new Frame("Week 2 - Line clipping", canvas);
        frame.show();
    }
}