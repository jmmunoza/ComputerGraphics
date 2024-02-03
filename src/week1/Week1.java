package week1;

import week1.components.canvas.Canvas;
import week1.components.canvas.CanvasComponent;
import week1.components.canvas.components.CartesianPlane;
import week1.components.canvas.components.DimensionText;
import week1.components.canvas.components.DraggableLine;
import week1.components.canvas.components.PositionText;

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

        Frame frame = new Frame(canvas);
        frame.show();
    }
}
