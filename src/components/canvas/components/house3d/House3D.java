package components.canvas.components.house3d;

import components.canvas.components.coordsdrawer.CoordsDrawer;
import components.canvas.listeners.CanvasKeyListener;
import components.canvas.observers.CanvasKeyObserver;
import components.canvas.shapes.ShapeComposite;
import components.canvas.transformations.rotation.Rotation3DYClockwise;
import components.canvas.transformations.translation.Translation3D;

import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;

public class House3D extends ShapeComposite implements CanvasKeyListener {
    private static final double ROTATION_DEGREES = 20;
    private static final double TRANSLATION_FACTOR = 50;
    private double angle = 0;

    public House3D(String carPath) throws FileNotFoundException {

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
        double z = TRANSLATION_FACTOR * Math.cos(Math.toRadians(angle));

        transform(new Translation3D(x, 0, z));
    }

    private void moveBack() {
        double x = -TRANSLATION_FACTOR * Math.sin(Math.toRadians(angle));
        double z = -TRANSLATION_FACTOR * Math.cos(Math.toRadians(angle));

        transform(new Translation3D(x, 0, z));
    }

    private void rotateRight() {
        transform(new Rotation3DYClockwise(getXCenter(), getYCenter(), getZCenter(), ROTATION_DEGREES));
        changeAngle(ROTATION_DEGREES);
    }

    private void rotateLeft() {
        transform(new Rotation3DYClockwise(getXCenter(), getYCenter(), getZCenter(), -ROTATION_DEGREES));
        changeAngle(-ROTATION_DEGREES);
    }

    private void changeAngle(double degrees) {
        angle += degrees;

        if (angle > 360) angle -= 360;
        else if (angle < 0) angle += 360;
    }
}
