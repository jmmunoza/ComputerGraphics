package week1;

import week1.components.canvas.Canvas;
import week1.components.canvas.shapes.CartesianPlane;
import week1.components.canvas.shapes.DraggableLine;
import week1.components.canvas.shapes.PositionText;

import java.awt.*;
import java.util.ArrayList;

public class Week1 {

    public static void main(String[] args) {
        ArrayList<Shape> shapes = new ArrayList<>();

        new CartesianPlane();
        new PositionText();
        new DraggableLine();
        Canvas canvas = new Canvas(shapes);

        new Frame(canvas);
    }
}
