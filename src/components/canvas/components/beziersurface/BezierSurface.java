package components.canvas.components.beziersurface;

import components.canvas.shapes.ShapeComposite;
import math.bezier.BlendingFunctions;
import math.bezier.ParametricBezierSurfaces;
import math.point.Point3D;

import java.awt.*;
import java.io.FileNotFoundException;

public class BezierSurface extends ShapeComposite {
    public BezierSurface(String surfacePath) throws FileNotFoundException {
        BlendingFunctions.BezierDTO data = BlendingFunctions.BezierFileReader.readObject(surfacePath);
        generateSurface(data.points, Color.WHITE);

        Point3D[][] surface = new ParametricBezierSurfaces(data.points, data.u, data.v).find();
        generateSurface(surface, Color.PINK);
    }

    private void generateSurface(Point3D[][] surface, Color color) {
        for (int i = 0; i < surface.length-1 ; i++) {
            for (int j = 0; j < surface[i].length-1; j++) {
                BezierSegment segment = new BezierSegment(
                        surface[i][j],
                        surface[i + 1][j],
                        surface[i][j + 1],
                        surface[i + 1][j + 1]
                );

                segment.setColor(color);
                add(segment);
            }
        }
    }
}
