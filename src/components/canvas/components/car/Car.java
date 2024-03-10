package components.canvas.components.car;

import components.canvas.components.coordsdrawer.CoordsDrawer;
import components.canvas.listeners.CanvasKeyListener;
import components.canvas.observers.CanvasKeyObserver;
import components.canvas.shapes.ShapeComposite;
import components.canvas.transformations.rotation.RotationAnticlockwise;
import components.canvas.transformations.rotation.RotationClockwise;
import components.canvas.transformations.scaling.ScalingZoom;
import components.canvas.transformations.scaling.ScalingZoomOut;
import components.canvas.transformations.translation.Translation;

import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;

public class Car extends ShapeComposite implements CanvasKeyListener {
    private static final double ROTATION_DEGREES = 20;
    private static final double SCALING_FACTOR = 1.15;
    private static final double TRANSLATION_FACTOR = 50;

    public Car(String carPath) throws FileNotFoundException {
        add(new CoordsDrawer(carPath));

        CanvasKeyObserver.attachListener(this);
    }

    @Override
    public void onKeyPressed(int code) {
        switch (code) {
            case KeyEvent.VK_ADD -> transform(new ScalingZoom(getXCenter(), getYCenter(), SCALING_FACTOR));
            case KeyEvent.VK_SUBTRACT -> transform(new ScalingZoomOut(getXCenter(), getYCenter(), SCALING_FACTOR));
            case KeyEvent.VK_A -> transform(new Translation(-TRANSLATION_FACTOR, 0));
            case KeyEvent.VK_W -> transform(new Translation(0, TRANSLATION_FACTOR));
            case KeyEvent.VK_S -> transform(new Translation(0, -TRANSLATION_FACTOR));
            case KeyEvent.VK_D -> transform(new Translation(TRANSLATION_FACTOR, 0));
            case KeyEvent.VK_Q -> transform(new RotationAnticlockwise(getXCenter(), getYCenter(), ROTATION_DEGREES));
            case KeyEvent.VK_E -> transform(new RotationClockwise(getXCenter(), getYCenter(), ROTATION_DEGREES));
        }
    }
}
