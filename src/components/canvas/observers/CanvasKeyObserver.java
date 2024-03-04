package components.canvas.observers;

import components.canvas.listeners.CanvasKeyListener;

import java.util.ArrayList;
import java.util.List;

public class CanvasKeyObserver {
    private static List<CanvasKeyListener> listeners;

    private CanvasKeyObserver() {
        listeners = new ArrayList<>();

    }

    public static void attachListener(CanvasKeyListener listener) {
        if (listeners == null) new CanvasKeyObserver();

        if (!listeners.contains(listener))
            listeners.add(listener);
    }

    public static void detachListener(CanvasKeyListener listener) {
        if (listener == null) new CanvasKeyObserver();

        listeners.remove(listener);
    }

    public static void notifyOnKeyPressed(int code) {
        if (listeners == null) new CanvasKeyObserver();

        for (CanvasKeyListener listener : listeners) {
            listener.onKeyPressed(code);
        }
    }
}