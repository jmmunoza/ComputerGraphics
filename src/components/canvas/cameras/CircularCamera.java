package components.canvas.cameras;

import math.util.DegreesCalculator;
import math.vector.Vector3D;

import java.awt.event.KeyEvent;

public class CircularCamera extends Camera {
    private final double ROTATION_DEGREES = 4;
    private final double ZOOM_FACTOR = 50;
    private double radius;
    private double longitude; // East to west (DEGREES)
    private double latitude; // North to south (DEGREES)

    public CircularCamera() {
        longitude = 90;
        latitude = 90;
        radius = 2000;

        lookAt(0, 0, 0);

        updatePosition();
        calculateM();
    }

    private void updatePosition() {
        double latRadians = Math.toRadians(latitude);
        double lonRadians = Math.toRadians(longitude);

        double x = radius * Math.sin(latRadians) * Math.cos(lonRadians) + lookAt.getX();
        double y = radius * Math.cos(latRadians) + lookAt.getY();
        double z = radius * Math.sin(latRadians) * Math.sin(lonRadians) + lookAt.getZ();

        setPosition(x, y, z);
    }

    @Override
    public void onUpPressed() {
        boolean isZero = false; // when latitude is zero, generates an NaN error

        latitude -= ROTATION_DEGREES;

        if (latitude == 0) {
            latitude -= 0.001; // temporally change
            isZero = true;
        }

        if (latitude < 0) up = new Vector3D(0, -1, 0);

        if (latitude < -180) {
            up = new Vector3D(0, 1, 0);
            latitude += 360;
        }

        updatePosition();
        calculateM();

        if (isZero) latitude = 0;
    }

    @Override
    public void onDownPressed() {
        boolean isZero = false; // when latitude is zero, generates an NaN error

        latitude += ROTATION_DEGREES;

        if (latitude == 0) {
            latitude += 0.001; // temporally change
            isZero = true;
        }

        if (latitude > 0) {
            up = new Vector3D(0, 1, 0);
        }

        if (latitude > 180) {
            up = new Vector3D(0, -1, 0);
            latitude -= 360;
        }

        updatePosition();
        calculateM();

        if (isZero) latitude = 0;
    }

    @Override
    public void onRightPressed() {
        longitude = DegreesCalculator.changeAngle(longitude, ROTATION_DEGREES, 0, 360);

        updatePosition();
        calculateM();
    }

    @Override
    public void onLeftPressed() {
        longitude = DegreesCalculator.changeAngle(longitude, -ROTATION_DEGREES, 0, 360);

        updatePosition();
        calculateM();
    }

    @Override
    public void onKeyPressed(int code) {
        switch (code) {
            case KeyEvent.VK_ADD -> radius -= ZOOM_FACTOR;
            case KeyEvent.VK_SUBTRACT -> radius += ZOOM_FACTOR;
            case KeyEvent.VK_Q -> PROJECTION_DISTANCIE += ZOOM_FACTOR;
            case KeyEvent.VK_E -> PROJECTION_DISTANCIE -= ZOOM_FACTOR;
        }

        updatePosition();
        calculateM();
    }
}