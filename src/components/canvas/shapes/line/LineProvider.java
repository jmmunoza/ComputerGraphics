package components.canvas.shapes.line;

import components.canvas.shapes.line.algorithms.Bresenham;

public class LineProvider {
    public static ILineAlgorithm inject(LineAlgorithm algorithm) {
        return switch (algorithm) {
            case BRESENHAM -> new Bresenham();
        };
    }
}
