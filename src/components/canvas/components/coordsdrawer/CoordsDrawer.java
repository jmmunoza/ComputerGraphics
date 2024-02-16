package components.canvas.components.coordsdrawer;

import components.canvas.CanvasComponent;
import components.canvas.listeners.CanvasPaintListener;
import components.canvas.observers.CanvasPaintObserver;
import components.canvas.shapes.line.Line;
import components.canvas.shapes.line.LineAlgorithm;
import math.point.Point2D;
import util.file.FileReader;
import weeks.week3.SequenceCoords;

import java.awt.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class CoordsDrawer implements CanvasComponent, CanvasPaintListener {

    private final List<Line> lines;

    public CoordsDrawer(String coordsSequenceFilePath) throws FileNotFoundException {
        List<String> textLines = FileReader.read(coordsSequenceFilePath);
        SequenceCoords sequenceCoordsToDraw = SequenceCoords.generateFromTextLines(textLines);

        lines = generateLinesFromSequenceCoords(sequenceCoordsToDraw);
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

            Line line = new Line(fromPoint, toPoint, LineAlgorithm.BRESENHAM);

            lines.add(line);
        }

        return lines;
    }

    @Override
    public void onPaint(Graphics g) {
        g.setColor(Color.DARK_GRAY);
        for (Line line : lines) line.draw(g);
    }

    @Override
    public void subscribe() {
        CanvasPaintObserver.attachListener(this);
    }
}
