package weeks.week6;

import components.canvas.Canvas;
import components.canvas.components.car.Car;
import components.canvas.components.cartesianplane.CartesianPlane;
import components.canvas.components.dimensiontext.DimensionText;
import components.canvas.components.positiontext.PositionText;
import components.canvas.shapes.ShapeComposite;
import components.frame.Frame;

import java.io.FileNotFoundException;

public class Week6 {
    public static void main(String[] args) throws FileNotFoundException {
        ShapeComposite composite = new ShapeComposite();
        composite.add(
                new CartesianPlane(),
                new Car(getCarPath()),
                new PositionText(),
                new DimensionText());

        Canvas canvas = new Canvas(composite);

        Frame frame = new Frame("Week 6 - Transformations", canvas);
        frame.show();
    }

    public static String getCarPath() {
        return "src/weeks/week6/files/car.txt";
    }
}