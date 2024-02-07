package components.canvas.components.lineclipping;

import components.canvas.shapes.line.Line;

public interface ILineClippingAlgorithm {
    boolean clip(Line line, int x1, int y1, int x2, int y2, int xMin, int yMin, int xMax, int yMax);
}
