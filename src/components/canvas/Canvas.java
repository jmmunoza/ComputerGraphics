package components.canvas;

import components.canvas.observers.CanvasMouseObserver;
import components.canvas.observers.CanvasPaintObserver;
import components.canvas.observers.CanvasResizeObserver;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class Canvas extends JPanel implements MouseMotionListener, ComponentListener, MouseListener {

    public Canvas(List<CanvasComponent> components) {
        for (CanvasComponent component : components) {
            component.subscribe();
        }

        this.addMouseMotionListener(this);
        this.addComponentListener(this);
        this.addMouseListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        CanvasPaintObserver.notifyOnPaint(g);
    }

    @Override
    public void componentResized(ComponentEvent e) {
        Component c = e.getComponent();

        CanvasResizeObserver.notifyOnResize(c.getWidth(), c.getHeight());

        repaint();
    }

    @Override
    public void componentMoved(ComponentEvent e) {

    }

    @Override
    public void componentShown(ComponentEvent e) {

    }

    @Override
    public void componentHidden(ComponentEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        int mappedX = CanvasMapper.mapXjToXp(e.getX(), getWidth());
        int mappedY = CanvasMapper.mapYjToYp(e.getY(), getHeight());

        CanvasMouseObserver.notifyOnMousePressed(mappedX, mappedY);

        repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        int mappedX = CanvasMapper.mapXjToXp(e.getX(), getWidth());
        int mappedY = CanvasMapper.mapYjToYp(e.getY(), getHeight());

        CanvasMouseObserver.notifyOnMouseReleased(mappedX, mappedY);

        repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        int mappedX = CanvasMapper.mapXjToXp(e.getX(), getWidth());
        int mappedY = CanvasMapper.mapYjToYp(e.getY(), getHeight());

        CanvasMouseObserver.notifyOnMouseEntered(mappedX, mappedY);

        repaint();
    }

    @Override
    public void mouseExited(MouseEvent e) {
        int mappedX = CanvasMapper.mapXjToXp(e.getX(), getWidth());
        int mappedY = CanvasMapper.mapYjToYp(e.getY(), getHeight());

        CanvasMouseObserver.notifyOnMouseExited(mappedX, mappedY);

        repaint();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        int mappedX = CanvasMapper.mapXjToXp(e.getX(), getWidth());
        int mappedY = CanvasMapper.mapYjToYp(e.getY(), getHeight());

        CanvasMouseObserver.notifyOnMouseDragged(mappedX, mappedY);

        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        int mappedX = CanvasMapper.mapXjToXp(e.getX(), getWidth());
        int mappedY = CanvasMapper.mapYjToYp(e.getY(), getHeight());

        CanvasMouseObserver.notifyOnMouseMoved(mappedX, mappedY);

        repaint();
    }
}
