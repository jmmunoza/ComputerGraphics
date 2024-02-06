package components.canvas.listeners;

public interface CanvasMouseListener {
    void onMouseDragged(int x, int y);

    void onMouseMoved(int x, int y);

    void onMousePressed(int x, int y);

    void onMouseReleased(int x, int y);

    void onMouseEntered(int x, int y);

    void onMousedExited(int x, int y);
}
