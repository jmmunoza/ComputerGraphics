package components.canvas.observers;

import components.canvas.listeners.CanvasMouseListener;

import java.util.ArrayList;
import java.util.List;

public class CanvasMouseObserver {
    private static List<CanvasMouseListener> listeners;

    private CanvasMouseObserver() {
        listeners = new ArrayList<>();

    }

    public static void attachListener(CanvasMouseListener listener) {
        if (listeners == null) new CanvasMouseObserver();

        if (!listeners.contains(listener))
            listeners.add(listener);
    }

    public static void detachListener(CanvasMouseListener listener) {
        if (listener == null) new CanvasMouseObserver();

        listeners.remove(listener);
    }

    public static void notifyOnMouseMoved(int x, int y) {
        if (listeners == null) new CanvasMouseObserver();

        for (CanvasMouseListener listener : listeners) {
            listener.onMouseMoved(x, y);
        }
    }

    public static void notifyOnMouseDragged(int x, int y) {
        if (listeners == null) new CanvasMouseObserver();

        for (CanvasMouseListener listener : listeners) {
            listener.onMouseDragged(x, y);
        }
    }

    public static void notifyOnMousePressed(int x, int y) {
        if (listeners == null) new CanvasMouseObserver();

        for (CanvasMouseListener listener : listeners) {
            listener.onMousePressed(x, y);
        }
    }

    public static void notifyOnMouseReleased(int x, int y) {
        if (listeners == null) new CanvasMouseObserver();

        for (CanvasMouseListener listener : listeners) {
            listener.onMouseReleased(x, y);
        }
    }

    public static void notifyOnMouseEntered(int x, int y) {
        if (listeners == null) new CanvasMouseObserver();

        for (CanvasMouseListener listener : listeners) {
            listener.onMouseEntered(x, y);
        }
    }

    public static void notifyOnMouseExited(int x, int y) {
        if (listeners == null) new CanvasMouseObserver();

        for (CanvasMouseListener listener : listeners) {
            listener.onMousedExited(x, y);
        }
    }
}
