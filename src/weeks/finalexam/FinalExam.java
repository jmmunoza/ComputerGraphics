package weeks.finalexam;

import components.canvas.Canvas;
import components.canvas.cameras.Camera;
import components.canvas.cameras.CircularCamera;
import components.canvas.components.beziersurface.BezierSurface;
import components.canvas.components.cartesianplane.CartesianPlane3D;
import components.canvas.components.dimensiontext.DimensionText;
import components.canvas.components.positiontext.PositionText;
import components.canvas.shapes.ShapeComposite;
import components.frame.Frame;
import math.bezier.BlendingFunctions;

import java.io.FileNotFoundException;

public class FinalExam {
    public static void main(String[] args) throws FileNotFoundException {
        ShapeComposite composite = new ShapeComposite();

        BlendingFunctions.BezierDTO data = BlendingFunctions.BezierFileReader.readObject(getSurfacePath());

        Camera camera = new CircularCamera();
        camera.lookAt(data.center);

        composite.add(
                new CartesianPlane3D(),
                new BezierSurface(data),
                new PositionText(),
                new DimensionText());

        Canvas canvas = new Canvas(composite);
        canvas.setCamera(camera);

        Frame frame = new Frame("Final Exam - Bezier Surface", canvas);
        frame.show();
    }

    public static String getSurfacePath() {
        return "src/weeks/finalexam/files/surface.txt";
    }
}
