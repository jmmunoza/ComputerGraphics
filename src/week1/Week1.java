package week1;

import components.canvas.Canvas;
import components.canvas.CanvasComponent;
import components.canvas.components.cartesianplane.CartesianPlane;
import components.canvas.components.dimensiontext.DimensionText;
import components.canvas.components.draggableline.DraggableLine;
import components.canvas.components.positiontext.PositionText;
import components.frame.Frame;

import javax.swing.*;
import java.util.ArrayList;

public class Week1 {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Week1::run);
    }

    public static void run() {
        ArrayList<CanvasComponent> components = new ArrayList<>();
        components.add(new CartesianPlane());
        components.add(new DraggableLine());
        components.add(new PositionText());
        components.add(new DimensionText());

        Canvas canvas = new Canvas(components);

        Frame frame = new Frame("Week 1 - Bresenham's algorithm", canvas);
        frame.show();
    }
}
