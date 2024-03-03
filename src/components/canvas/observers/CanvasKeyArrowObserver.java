package components.canvas.observers;

import components.canvas.listeners.CanvasKeyArrowListener;

import java.util.ArrayList;
import java.util.List;

public class CanvasKeyArrowObserver {
    private static List<CanvasKeyArrowListener> listeners;

    private CanvasKeyArrowObserver() {
        listeners = new ArrayList<>();

    }

    public static void attachListener(CanvasKeyArrowListener listener) {
        if (listeners == null) new CanvasKeyArrowObserver();

        if (!listeners.contains(listener))
            listeners.add(listener);
    }

    public static void detachListener(CanvasKeyArrowListener listener) {
        if (listener == null) new CanvasKeyArrowObserver();

        listeners.remove(listener);
    }

    public static void notifyOnUpPressed() {
        if (listeners == null) new CanvasKeyArrowObserver();

        for (CanvasKeyArrowListener listener : listeners) {
            listener.onUpPressed();
        }
    }

    public static void notifyOnDownPressed() {
        if (listeners == null) new CanvasKeyArrowObserver();

        for (CanvasKeyArrowListener listener : listeners) {
            listener.onDownPressed();
        }
    }

    public static void notifyOnRightPressed() {
        if (listeners == null) new CanvasKeyArrowObserver();

        for (CanvasKeyArrowListener listener : listeners) {
            listener.onRightPressed();
        }
    }

    public static void notifyOnLeftPressed() {
        if (listeners == null) new CanvasKeyArrowObserver();

        for (CanvasKeyArrowListener listener : listeners) {
            listener.onLeftPressed();
        }
    }
}