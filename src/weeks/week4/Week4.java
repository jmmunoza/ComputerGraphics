package weeks.week4;

import components.canvas.Canvas;
import components.canvas.components.car.Car;
import components.canvas.components.cartesianplane.CartesianPlane;
import components.canvas.components.dimensiontext.DimensionText;
import components.canvas.shapes.ShapeComposite;
import components.frame.Frame;

import java.io.FileNotFoundException;

public class Week4 {
    public static void main(String[] args) throws FileNotFoundException {
        ShapeComposite composite = new ShapeComposite();
        composite.add(
                new CartesianPlane(),
                new Car(getCarPath()),
                new DimensionText());

        Canvas canvas = new Canvas(composite);

        Frame frame = new Frame("Week 4 - Transformations", canvas);
        frame.show();
    }

    public static String getCarPath() {
        return "src/weeks/week4/files/car.txt";
    }
}