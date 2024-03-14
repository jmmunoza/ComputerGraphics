package weeks.week7;

import components.canvas.Canvas;
import components.canvas.components.cartesianplane.CartesianPlane3D;
import components.canvas.components.dimensiontext.DimensionText;
import components.canvas.components.house3d.House3D;
import components.canvas.components.positiontext.PositionText;
import components.canvas.shapes.ShapeComposite;
import components.frame.Frame;

import java.io.FileNotFoundException;

public class Week7 {
    public static void main(String[] args) throws FileNotFoundException {
        ShapeComposite composite = new ShapeComposite();
        composite.add(
                new CartesianPlane3D(),
                new House3D(getHouse3DPath()),
                new PositionText(),
                new DimensionText());

        Canvas canvas = new Canvas(composite);

        Frame frame = new Frame("Week 7 - 3D Transformations", canvas);
        frame.show();
    }

    public static String getHouse3DPath() {
        return "src/weeks/week7/files/house3d.txt";
    }
}