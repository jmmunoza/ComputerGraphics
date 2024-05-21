package weeks.finalexam;

import components.canvas.Canvas;
import components.canvas.cameras.CircularCamera;
import components.canvas.components.beziersurface.BezierSurface;
import components.canvas.components.cartesianplane.CartesianPlane3D;
import components.canvas.components.dimensiontext.DimensionText;
import components.canvas.components.positiontext.PositionText;
import components.canvas.shapes.ShapeComposite;
import components.frame.Frame;

import java.io.FileNotFoundException;

public class FinalExam {
    public static void main(String[] args) throws FileNotFoundException {
        ShapeComposite composite = new ShapeComposite();

        composite.add(
                new CartesianPlane3D(),
                new BezierSurface(getSurfacePath()),
                new PositionText(),
                new DimensionText());

        Canvas canvas = new Canvas(composite);
        canvas.setCamera(new CircularCamera());

        Frame frame = new Frame("Final Exam - Bezier Surface", canvas);
        frame.show();
    }

    public static String getSurfacePath() {
        return "src/weeks/finalexam/files/surface.txt";
    }
}
