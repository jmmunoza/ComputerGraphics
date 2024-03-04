package components.canvas.listeners;

public interface CanvasMouseListener {
    void onMouseDragged(double x, double y);

    void onMouseMoved(double x, double y);

    void onMousePressed(double x, double y);

    void onMouseReleased(double x, double y);

    void onMouseEntered(double x, double y);

    void onMousedExited(double x, double y);
}
