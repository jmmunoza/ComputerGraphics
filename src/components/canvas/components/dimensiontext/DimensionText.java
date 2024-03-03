package components.canvas.components.dimensiontext;

import components.canvas.listeners.CanvasResizeListener;
import components.canvas.observers.CanvasResizeObserver;
import components.canvas.shapes.ShapeComposite;
import components.canvas.shapes.text.Text;

public class DimensionText extends ShapeComposite implements CanvasResizeListener {
    private final Text text;

    public DimensionText() {
        text = new Text();

        add(text);

        CanvasResizeObserver.attachListener(this);
    }

    @Override
    public void onResize(int width, int height) {
        String dimensionText = "w=" + width + " h=" + height;

        int padding = 10;

        text.setText(dimensionText);
        text.setX((-width / 2) + padding);
        text.setY((-height / 2) + padding);
    }
}
