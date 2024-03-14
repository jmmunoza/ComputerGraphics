package components.canvas.shapes.line.clipping;

public interface ILineClippingAlgorithm {
    LineClippingResult clip(int x1, int y1, int x2, int y2, int xMin, int yMin, int xMax, int yMax);
}
