package components.canvas.cameras;


public class Camera3D extends Camera {
    private final double TRANSLATION_FACTOR = 100;

    @Override
    public void onUpPressed() {
        position.setY(position.getY() + TRANSLATION_FACTOR);

        calculateM();
    }

    @Override
    public void onDownPressed() {
        position.setY(position.getY() - TRANSLATION_FACTOR);

        calculateM();
    }

    @Override
    public void onRightPressed() {
        position.setX(position.getX() + TRANSLATION_FACTOR);

        calculateM();
    }

    @Override
    public void onLeftPressed() {
        position.setX(position.getX() - TRANSLATION_FACTOR);

        calculateM();
    }
}
