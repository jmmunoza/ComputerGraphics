package components.canvas.components.car;

import components.canvas.components.coordsdrawer.CoordsDrawer;
import components.canvas.listeners.CanvasKeyArrowListener;
import components.canvas.listeners.CanvasKeyListener;
import components.canvas.observers.CanvasKeyArrowObserver;
import components.canvas.observers.CanvasKeyObserver;
import components.canvas.shapes.ShapeComposite;
import components.canvas.transformations.rotation.RotationAnticlockwise;
import components.canvas.transformations.rotation.RotationClockwise;
import components.canvas.transformations.scaling.ScalingZoom;
import components.canvas.transformations.scaling.ScalingZoomOut;
import components.canvas.transformations.translation.Translation;

import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;

public class Car extends ShapeComposite implements CanvasKeyArrowListener, CanvasKeyListener {
    public Car(String carPath) throws FileNotFoundException {
        add(new CoordsDrawer(carPath));

        CanvasKeyArrowObserver.attachListener(this);
        CanvasKeyObserver.attachListener(this);
    }

    @Override
    public void onUpPressed() {
        transform(new Translation(0, 25));
    }

    @Override
    public void onDownPressed() {
        transform(new Translation(0, -25));
    }

    @Override
    public void onRightPressed() {
        transform(new Translation(25, 0));
    }

    @Override
    public void onLeftPressed() {
        transform(new Translation(-25, 0));
    }

    @Override
    public void onKeyPressed(int code) {
        switch (code) {
            case KeyEvent.VK_ADD -> transform(new ScalingZoom(getXCenter(), getYCenter(), 1.05, 1.05));
            case KeyEvent.VK_SUBTRACT -> transform(new ScalingZoomOut(getXCenter(), getYCenter(), 1.05, 1.05));
            case KeyEvent.VK_A -> transform(new RotationAnticlockwise(getXCenter(), getYCenter(), 15));
            case KeyEvent.VK_D -> transform(new RotationClockwise(getXCenter(), getYCenter(), 15));
        }
    }
}
