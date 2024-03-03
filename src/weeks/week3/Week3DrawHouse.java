package weeks.week3;

import components.canvas.Canvas;
import components.canvas.components.cartesianplane.CartesianPlane;
import components.canvas.components.coordsdrawer.CoordsDrawer;
import components.canvas.components.dimensiontext.DimensionText;
import components.canvas.components.positiontext.PositionText;
import components.canvas.shapes.ShapeComposite;
import components.frame.Frame;

import java.io.FileNotFoundException;

public class Week3DrawHouse {
    public static void main(String[] args) throws FileNotFoundException {
        ShapeComposite composite = generateCanvasComponents();
        Canvas canvas = new Canvas(composite);

        Frame frame = new Frame("Week 3 - Drawing", canvas);
        frame.show();
    }

    public static ShapeComposite generateCanvasComponents() throws FileNotFoundException {
        ShapeComposite composite = new ShapeComposite();

        composite.add(
                new CartesianPlane(),
                new CoordsDrawer(getClothespinPath()),
                new CoordsDrawer(getHousePath()),
                new DimensionText(),
                new PositionText());

        return composite;
    }

    public static String getHousePath() {
        return "src/weeks/week3/files/house.txt";
    }

    public static String getClothespinPath() {
        return "src/weeks/week3/files/clothespin.txt";
    }
}