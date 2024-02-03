package week1.components.canvas.observers;

import week1.components.canvas.listeners.CanvasPaintListener;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class CanvasPaintObserver {

    private static List<CanvasPaintListener> listeners;

    private CanvasPaintObserver() {
        listeners = new ArrayList<>();

    }

    public static void attachListener(CanvasPaintListener listener) {
        if (listeners == null) new CanvasPaintObserver();

        if (!listeners.contains(listener))
            listeners.add(listener);
    }

    public static void detachListener(CanvasPaintListener listener) {
        if (listener == null) new CanvasPaintObserver();

        listeners.remove(listener);
    }

    public static void notifyOnPaint(Graphics g) {
        if (listeners == null) new CanvasPaintObserver();

        for (CanvasPaintListener listener : listeners) {
            listener.onPaint(g);
        }
    }
}
