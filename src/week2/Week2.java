package week2;

import components.canvas.Canvas;
import components.canvas.CanvasComponent;
import components.canvas.components.CartesianPlane;
import components.canvas.components.DimensionText;
import components.canvas.components.DraggableLine;
import components.canvas.components.PositionText;
import components.frame.Frame;

import java.util.ArrayList;

public class Week2 {
    public static void main(String[] args) {
        ArrayList<CanvasComponent> components = new ArrayList<>();
        components.add(new CartesianPlane());
        components.add(new DraggableLine());
        components.add(new PositionText());
        components.add(new DimensionText());

        Canvas canvas = new Canvas(components);

        Frame frame = new Frame("Week 2 - Line Clipping", canvas);
        frame.show();
    }
}