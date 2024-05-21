package components.canvas.components.beziersurface;

import components.canvas.shapes.ShapeComposite;
import math.bezier.ParametricBezierSurfaces;
import math.point.Point3D;
import weeks.finalexam.BezierDTO;
import weeks.finalexam.BezierFileReader;

import java.awt.*;
import java.io.FileNotFoundException;

public class BezierSurface extends ShapeComposite {
    public BezierSurface(String surfacePath) throws FileNotFoundException {

        BezierDTO data = BezierFileReader.readObject(surfacePath);

        for (int i = 0; i < data.points.length-1 ; i++) {
            for (int j = 0; j < data.points[i].length-1; j++) {
                add(new BezierSegment(data.points[i][j], data.points[i + 1][j], data.points[i][j + 1], data.points[i + 1][j + 1]));
            }
        }
        setColor(Color.WHITE);
        Point3D[][] surface = new ParametricBezierSurfaces(2,2,data.points, data.u, data.v).Surface();

        for (int i = 0; i < surface.length-1 ; i++) {
            for (int j = 0; j < surface[i].length-1; j++) {
                add(new BezierSegment(surface[i][j], surface[i + 1][j], surface[i][j + 1], surface[i + 1][j + 1]));
            }
        }
        setColor(Color.DARK_GRAY);
    }
}
