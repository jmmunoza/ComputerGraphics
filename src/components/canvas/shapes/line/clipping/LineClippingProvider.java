package components.canvas.shapes.line.clipping;

import components.canvas.shapes.line.clipping.algorithms.CohenSutherland;
import components.canvas.shapes.line.clipping.algorithms.LiangBarsky;

public class LineClippingProvider {
    public static ILineClippingAlgorithm inject(LineClippingAlgorithm algorithm) {
        return switch (algorithm) {
            case LIANG_BARSKY -> new LiangBarsky();
            case COHEN_SUTHERLAND -> new CohenSutherland();
        };
    }
}
