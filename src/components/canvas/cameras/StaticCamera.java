package components.canvas.cameras;

public class StaticCamera extends Camera {


    public StaticCamera() {
        lookAt(0, 0, 0);
        setPosition(
                getProjectionDistance() / 2,
                getProjectionDistance(),
                2 * getProjectionDistance()
        );

        calculateM();
    }
}
