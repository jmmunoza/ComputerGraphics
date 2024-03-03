package components.canvas.components.coordsdrawer;

import components.canvas.shapes.ShapeComposite;
import components.canvas.shapes.line.Line;
import math.point.Point2D;
import util.file.FileReader;

import java.awt.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class CoordsDrawer extends ShapeComposite {

    public CoordsDrawer(String coordsSequenceFilePath) throws FileNotFoundException {
        List<String> textLines = FileReader.read(coordsSequenceFilePath);
        SequenceCoords sequenceCoordsToDraw = SequenceCoords.generateFromTextLines(textLines);

        List<Line> lines = generateLinesFromSequenceCoords(sequenceCoordsToDraw);

        addLines(lines);
        setColor(Color.DARK_GRAY);
    }

    private static List<Line> generateLinesFromSequenceCoords(SequenceCoords sequenceCoords) {
        List<Line> lines = new ArrayList<>();

        Point2D[] points = sequenceCoords.getCoords();
        int[][] sequence = sequenceCoords.getSequence();

        for (int[] step : sequence) {
            int from = step[0];
            int to = step[1];

            Point2D fromPoint = points[from];
            Point2D toPoint = points[to];

            Line line = new Line(fromPoint, toPoint);

            lines.add(line);
        }

        return lines;
    }

    private void addLines(List<Line> lines) {
        Line[] array = new Line[lines.size()];
        add(lines.toArray(array));
    }
}
