package components.canvas.components.lineclipping;

import components.canvas.components.lineclipping.algorithms.CohenSutherland;
import components.canvas.components.lineclipping.algorithms.LiangBarsky;

public class LineClippingProvider {
    public static ILineClippingAlgorithm inject(LineClippingAlgorithm algorithm) {
        return switch (algorithm) {
            case LIANG_BARSKY -> new LiangBarsky();
            case COHEN_SUTHERLAND -> new CohenSutherland();
        };
    }
}
