package components.canvas.listeners;

public interface ShapePositionListener {
    void onPositionUpdate(double x, double y, double z);

    void onCenterPositionUpdate(double centerX, double centerY, double centerZ);
}
