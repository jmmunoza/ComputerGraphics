package components.canvas.observers;

import components.canvas.listeners.CanvasResizeListener;

import java.util.ArrayList;
import java.util.List;

public class CanvasResizeObserver {

    private static List<CanvasResizeListener> listeners;

    private CanvasResizeObserver() {
        listeners = new ArrayList<>();

    }

    public static void attachListener(CanvasResizeListener listener) {
        if (listeners == null) new CanvasResizeObserver();

        if (!listeners.contains(listener))
            listeners.add(listener);
    }

    public static void detachListener(CanvasResizeListener listener) {
        if (listener == null) new CanvasResizeObserver();

        listeners.remove(listener);
    }

    public static void notifyOnResize(double width, double height) {
        if (listeners == null) new CanvasResizeObserver();

        for (CanvasResizeListener listener : listeners) {
            listener.onResize(width, height);
        }
    }
}
