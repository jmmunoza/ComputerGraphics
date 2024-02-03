package week1;

import week1.components.canvas.Canvas;
import week1.components.canvas.components.CartesianPlane;
import week1.components.canvas.components.DimensionText;
import week1.components.canvas.components.DraggableLine;
import week1.components.canvas.components.PositionText;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Week1 {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Week1::run);
    }

    public static void run() {
        ArrayList<Shape> shapes = new ArrayList<>();

        new CartesianPlane();
        new DimensionText();
        new PositionText();
        new DraggableLine();
        Canvas canvas = new Canvas(shapes);

        new Frame(canvas);
    }
}
