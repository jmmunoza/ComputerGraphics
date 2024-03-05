package components.canvas.components.coordsdrawer;

import components.canvas.factories.PointFactory;
import math.point.Point;
import util.exceptions.InvalidNumericArrayException;
import util.exceptions.LinesMustBeNumericException;
import util.numeric.IntegerArrayCaster;
import util.numeric.IntegerChecker;
import util.string.StringArrayCaster;
import util.string.StringSpacesSplitter;

import java.util.ArrayList;
import java.util.List;

public class SequenceCoords {
    private final Point[] coords;
    private final int[][] sequence;

    private SequenceCoords(Point[] coords, int[][] sequence) {
        this.coords = coords;
        this.sequence = sequence;
    }

    public static SequenceCoords generateFromTextLines(List<String> textLines) {
        if (!areAllLinesNumeric(textLines)) {
            throw new LinesMustBeNumericException();
        }

        List<int[][]> numericArray = parseTextLinesToNumericArray(textLines);

        if (!hasNumericArrayCoordsAndSequence(numericArray)) {
            throw new InvalidNumericArrayException();
        }

        int[][] coordsArray = numericArray.get(0);
        Point[] pointCoords = convertNumericArrayToPointArray(coordsArray);

        int[][] sequenceArray = numericArray.get(1);

        return new SequenceCoords(pointCoords, sequenceArray);
    }

    public static boolean areAllLinesNumeric(List<String> lines) {
        for (String line : lines) {
            String[] lineElements = StringSpacesSplitter.split(line);

            for (String element : lineElements) {
                if (!IntegerChecker.isStringAnInteger(element)) {
                    return false;
                }
            }
        }

        return true;
    }

    public static List<int[][]> parseTextLinesToNumericArray(List<String> lines) {
        List<String> linesCopy = new ArrayList<>(lines); // lines could be used after
        List<int[][]> numericArray = new ArrayList<>();

        return parseTextLinesToNumberArray(linesCopy, numericArray);
    }

    public static List<int[][]> parseTextLinesToNumberArray(List<String> lines, List<int[][]> numericArray) {
        if (lines.isEmpty()) {
            return numericArray; // we're done
        }

        int[] numericLine = convertLineToNumericArray(lines.getFirst());

        if (!isNumericLineValid(numericLine)) {
            throw new InvalidNumericArrayException();
        }

        lines.removeFirst();

        if (isNumericLineACoord(numericLine)) {
            return parseTextLinesToNumberArray(lines, numericArray);
        }

        int linesToTake = numericLine[0];
        int[][] coordsArray = new int[linesToTake][2];

        int linesIndex = 0;

        while (linesIndex < linesToTake) {
            String line = lines.removeFirst();

            numericLine = convertLineToNumericArray(line);

            if (!isNumericLineACoord(numericLine)) {
                throw new InvalidNumericArrayException();
            }

            coordsArray[linesIndex] = numericLine;

            linesIndex++;
        }

        numericArray.add(coordsArray);

        return parseTextLinesToNumberArray(lines, numericArray);
    }

    public static int[] convertLineToNumericArray(String line) {
        String[] lineStringArray = StringSpacesSplitter.split(line);

        return StringArrayCaster.castToToIntArray(lineStringArray);
    }

    public static boolean isNumericLineValid(int[] numericLine) {
        return numericLine.length >= 1 && numericLine.length <= 3;
    }

    public static boolean isNumericLineACoord(int[] numericLine) {
        return numericLine.length == 2 || numericLine.length == 3;
    }

    public static boolean hasNumericArrayCoordsAndSequence(List<int[][]> parsedNumericArray) {
        return parsedNumericArray.size() == 2 || parsedNumericArray.size() == 3;
    }

    public static Point[] convertNumericArrayToPointArray(int[][] numericArray) {
        Point[] pointsArray = new Point[numericArray.length];

        for (int i = 0; i < numericArray.length; i++) {
            int[] coords = numericArray[i];
            double[] coordsDouble = IntegerArrayCaster.castToDoubleArray(coords);

            Point point = PointFactory.create(coordsDouble);

            pointsArray[i] = point;
        }

        return pointsArray;
    }

    public int[][] getSequence() {
        return sequence;
    }

    public Point[] getCoords() {
        return coords;
    }
}
