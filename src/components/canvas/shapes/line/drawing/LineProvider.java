package components.canvas.shapes.line.drawing;

import components.canvas.shapes.line.drawing.algorithms.Bresenham;

public class LineProvider {
    public static ILineAlgorithm inject(LineAlgorithm algorithm) {
        return switch (algorithm) {
            case BRESENHAM -> new Bresenham();
        };
    }
}
