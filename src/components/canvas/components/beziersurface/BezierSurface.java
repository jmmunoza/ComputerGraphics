package components.canvas.components.beziersurface;

import components.canvas.components.coordsdrawer.CoordsDrawer;
import components.canvas.listeners.CanvasKeyListener;
import components.canvas.observers.CanvasKeyObserver;
import components.canvas.shapes.ShapeComposite;
import components.canvas.transformations.rotation.RotationAnticlockwise;
import components.canvas.transformations.rotation.RotationClockwise;
import components.canvas.transformations.translation.Translation;
import math.util.DegreesCalculator;

import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;

public class BezierSurface extends ShapeComposite implements CanvasKeyListener {
    private static final double ROTATION_DEGREES = 20;
    private static final double TRANSLATION_FACTOR = 50;
    private double angle = 0;

    public BezierSurface(String carPath) throws FileNotFoundException {
        add(new CoordsDrawer(carPath));

        CanvasKeyObserver.attachListener(this);
    }

    @Override
    public void onKeyPressed(int code) {
        switch (code) {
            case KeyEvent.VK_A -> rotateLeft();
            case KeyEvent.VK_W -> moveForward();
            case KeyEvent.VK_S -> moveBack();
            case KeyEvent.VK_D -> rotateRight();
        }
    }

    private void moveForward() {
        double x = TRANSLATION_FACTOR * Math.sin(Math.toRadians(angle));
        double y = TRANSLATION_FACTOR * Math.cos(Math.toRadians(angle));

        transform(new Translation(x, y));
    }

    private void moveBack() {
        double x = -TRANSLATION_FACTOR * Math.sin(Math.toRadians(angle));
        double y = -TRANSLATION_FACTOR * Math.cos(Math.toRadians(angle));

        transform(new Translation(x, y));
    }

    private void rotateRight() {
        transform(new RotationClockwise(getXCenter(), getYCenter(), ROTATION_DEGREES));

        angle = DegreesCalculator.changeAngle(angle, ROTATION_DEGREES);
    }

    private void rotateLeft() {
        transform(new RotationAnticlockwise(getXCenter(), getYCenter(), ROTATION_DEGREES));

        angle = DegreesCalculator.changeAngle(angle, -ROTATION_DEGREES);
    }
}
