package weeks.week3;

import components.canvas.Canvas;
import components.canvas.CanvasComponent;
import components.canvas.components.cartesianplane.CartesianPlane;
import components.canvas.components.coordsdrawer.CoordsDrawer;
import components.canvas.components.dimensiontext.DimensionText;
import components.canvas.components.positiontext.PositionText;
import components.frame.Frame;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Week3DrawHouse {
    public static void main(String[] args) throws FileNotFoundException {
        List<CanvasComponent> components = generateCanvasComponents();
        Canvas canvas = new Canvas(components);

        Frame frame = new Frame("Week 3 - Drawing", canvas);
        frame.show();
    }

    public static List<CanvasComponent> generateCanvasComponents() throws FileNotFoundException {
        List<CanvasComponent> components = new ArrayList<>();

        components.add(new CartesianPlane());
        components.add(new CoordsDrawer(getClothespinPath()));
        components.add(new CoordsDrawer(getHousePath()));
        components.add(new DimensionText());
        components.add(new PositionText());

        return components;
    }

    public static String getHousePath() {
        return "src/weeks/week3/files/house.txt";
    }

    public static String getClothespinPath() {
        return "src/weeks/week3/files/clothespin.txt";
    }
}