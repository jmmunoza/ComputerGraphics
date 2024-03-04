package components.canvas.components.selection;

import components.canvas.shapes.ShapeComposite;
import components.canvas.shapes.rectangle.Rectangle;

public class Selection extends ShapeComposite {
    public Rectangle selectionRectangle;

    public Selection() {
        selectionRectangle = new Rectangle(0, 0, 0, 0);

        add(selectionRectangle);
    }

    public void set(double x, double y, double w, double h) {
        setX(x);
        setY(y);

        selectionRectangle.setH(h);
        selectionRectangle.setW(w);
        selectionRectangle.setX(x);
        selectionRectangle.setY(y);
    }

    @Override
    public boolean isTransparent() {
        return true;
    }
}
