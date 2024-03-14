package components.canvas.components.coordstext;

import components.canvas.listeners.ShapePositionListener;
import components.canvas.shapes.Shape;
import components.canvas.shapes.ShapeComposite;
import components.canvas.shapes.circle.Circle3D;
import components.canvas.shapes.text.Text3D;

import java.awt.*;

public class FollowingCoordsText3D extends ShapeComposite {
    private final Text3D text;
    private final Circle3D circle;
    private final Shape followingShape;

    public FollowingCoordsText3D(Shape followingShape) {
        super(Color.DARK_GRAY);

        this.followingShape = followingShape;

        text = new Text3D();
        circle = new Circle3D(6);

        add(text);
        add(circle);

        follow();

        setCoords(
                followingShape.getXCenter(),
                followingShape.getYCenter(),
                followingShape.getZCenter()
        );
    }

    private void follow() {
        followingShape.addShapePositionListener(new ShapePositionListener() {
            @Override
            public void onPositionUpdate(double x, double y, double z) {

            }

            @Override
            public void onCenterPositionUpdate(double centerX, double centerY, double centerZ) {
                setCoords(centerX, centerY, centerZ);
            }
        });
    }

    public void setCoords(double x, double y, double z) {
        String positionText = "(" + (int) x + ", " + (int) y + ", " + (int) z + ")";

        int padding = 10;

        text.setText(positionText);
        text.setX(x + padding);
        text.setY(y + padding);
        text.setZ(z + padding);

        circle.setX(x - circle.getRadius() / 2);
        circle.setY(y + circle.getRadius() / 2);
        circle.setZ(z + circle.getRadius() / 2);
    }

    @Override
    public double getWidth() {
        return 0;
    }

    @Override
    public double getHeight() {
        return 0;
    }

    @Override
    public double getDepth() {
        return 0;
    }
}