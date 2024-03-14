package weeks.week8;

import components.canvas.Canvas;
import components.canvas.cameras.CircularCamera;
import components.canvas.components.cartesianplane.CartesianPlane3D;
import components.canvas.components.dimensiontext.DimensionText;
import components.canvas.components.neighborhood.Neighborhood;
import components.canvas.components.positiontext.PositionText;
import components.canvas.shapes.ShapeComposite;
import components.frame.Frame;

import java.io.FileNotFoundException;

public class Week8 {
    public static void main(String[] args) throws FileNotFoundException {
        ShapeComposite composite = new ShapeComposite();

        composite.add(
                new CartesianPlane3D(),
                new Neighborhood(getHouse3DPath(), 5),
                new PositionText(),
                new DimensionText());

        Canvas canvas = new Canvas(composite);
        canvas.setCamera(new CircularCamera());

        Frame frame = new Frame("Week 8 - 3D Camera", canvas);
        frame.show();
    }

    public static String getHouse3DPath() {
        return "src/weeks/week8/files/house3d.txt";
    }
}