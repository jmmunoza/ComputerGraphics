package components.canvas.components.house3d;

import components.canvas.components.coordsdrawer.CoordsDrawer;
import components.canvas.listeners.CanvasKeyArrowListener;
import components.canvas.listeners.CanvasKeyListener;
import components.canvas.observers.CanvasKeyArrowObserver;
import components.canvas.observers.CanvasKeyObserver;
import components.canvas.shapes.ShapeComposite;
import components.canvas.transformations.rotation.Rotation3DXClockwise;
import components.canvas.transformations.rotation.Rotation3DYClockwise;
import components.canvas.transformations.rotation.Rotation3DZClockwise;
import components.canvas.transformations.scaling.Scaling3DZoom;
import components.canvas.transformations.scaling.Scaling3DZoomOut;
import components.canvas.transformations.translation.Translation3D;

import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;

public class House3D extends ShapeComposite implements CanvasKeyArrowListener, CanvasKeyListener {
    private static final double ROTATION_DEGREES = 20;
    private static final double SCALING_FACTOR = 1.15;
    private static final double TRANSLATION_FACTOR = 50;

    public House3D(String carPath) throws FileNotFoundException {

        add(new CoordsDrawer(carPath));

        CanvasKeyArrowObserver.attachListener(this);
        CanvasKeyObserver.attachListener(this);
    }

    @Override
    public void onUpPressed() {
        transform(new Rotation3DXClockwise(getXCenter(), getYCenter(), getZCenter(), -ROTATION_DEGREES));
    }

    @Override
    public void onDownPressed() {
        transform(new Rotation3DXClockwise(getXCenter(), getYCenter(), getZCenter(), ROTATION_DEGREES));
    }

    @Override
    public void onRightPressed() {
        transform(new Rotation3DYClockwise(getXCenter(), getYCenter(), getZCenter(), ROTATION_DEGREES));
    }

    @Override
    public void onLeftPressed() {
        transform(new Rotation3DYClockwise(getXCenter(), getYCenter(), getZCenter(), -ROTATION_DEGREES));
    }

    @Override
    public void onKeyPressed(int code) {
        switch (code) {
            case KeyEvent.VK_ADD ->
                    transform(new Scaling3DZoom(getXCenter(), getYCenter(), getZCenter(), SCALING_FACTOR));
            case KeyEvent.VK_SUBTRACT ->
                    transform(new Scaling3DZoomOut(getXCenter(), getYCenter(), getZCenter(), SCALING_FACTOR));
            case KeyEvent.VK_A -> transform(new Translation3D(-TRANSLATION_FACTOR, 0, 0));
            case KeyEvent.VK_W -> transform(new Translation3D(0, TRANSLATION_FACTOR, 0));
            case KeyEvent.VK_S -> transform(new Translation3D(0, -TRANSLATION_FACTOR, 0));
            case KeyEvent.VK_D -> transform(new Translation3D(TRANSLATION_FACTOR, 0, 0));
            case KeyEvent.VK_Q ->
                    transform(new Rotation3DZClockwise(getXCenter(), getYCenter(), getZCenter(), ROTATION_DEGREES));
            case KeyEvent.VK_E ->
                    transform(new Rotation3DZClockwise(getXCenter(), getYCenter(), getZCenter(), -ROTATION_DEGREES));
        }
    }
}
