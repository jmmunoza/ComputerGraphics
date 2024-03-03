package components.canvas.components.car;

import components.canvas.components.coordsdrawer.CoordsDrawer;
import components.canvas.listeners.CanvasKeyArrowListener;
import components.canvas.observers.CanvasKeyArrowObserver;
import components.canvas.shapes.ShapeComposite;
import components.canvas.transformations.rotation.RotationClockwise;
import components.canvas.transformations.rotation.RotationCounterClockwise;
import components.canvas.transformations.translation.Translation;

import java.io.FileNotFoundException;

public class Car extends ShapeComposite implements CanvasKeyArrowListener {
    public Car(String carPath) throws FileNotFoundException {
        add(new CoordsDrawer(carPath));

        CanvasKeyArrowObserver.attachListener(this);
    }

    @Override
    public void onUpPressed() {
        transform(new Translation(0, 5));
    }

    @Override
    public void onDownPressed() {
        transform(new Translation(0, -5));
    }

    @Override
    public void onRightPressed() {
        transform(new RotationClockwise(1));
    }

    @Override
    public void onLeftPressed() {
        transform(new RotationCounterClockwise(1));
    }
}
