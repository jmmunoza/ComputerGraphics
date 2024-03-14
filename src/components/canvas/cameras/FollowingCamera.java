package components.canvas.cameras;

import components.canvas.listeners.ShapePositionListener;
import components.canvas.shapes.Shape;

public class FollowingCamera extends Camera {
    private final Shape followingShape;

    public FollowingCamera(Shape followingShape) {
        this.followingShape = followingShape;

        lookAt(followingShape.getXCenter(), followingShape.getYCenter(), followingShape.getZCenter());
        setPosition(1000, 1000, 1000);

        calculateM();

        follow();
    }

    private void follow() {
        followingShape.addShapePositionListener(new ShapePositionListener() {
            @Override
            public void onPositionUpdate(double x, double y, double z) {

            }

            @Override
            public void onCenterPositionUpdate(double centerX, double centerY, double centerZ) {
                lookAt(centerX, centerY, centerZ);
                calculateM();
            }
        });
    }
}
