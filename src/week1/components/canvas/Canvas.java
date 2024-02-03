package week1.components.canvas;

import week1.components.canvas.observers.CanvasMouseObserver;
import week1.components.canvas.observers.CanvasPaintObserver;
import week1.components.canvas.observers.CanvasResizeObserver;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class Canvas extends JPanel implements MouseMotionListener, ComponentListener, MouseListener {
    private final List<Shape> shapes;

    public Canvas(List<Shape> shapes) {
        this.shapes = shapes;
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
        CanvasMouseObserver.notifyOnMousePressed(e.getX(), e.getY());

        repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        CanvasMouseObserver.notifyOnMouseReleased(e.getX(), e.getY());

        repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        CanvasMouseObserver.notifyOnMouseEntered(e.getX(), e.getY());

        repaint();
    }

    @Override
    public void mouseExited(MouseEvent e) {
        CanvasMouseObserver.notifyOnMouseExited(getX(), e.getY());

        repaint();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        CanvasMouseObserver.notifyOnMouseDragged(e.getX(), e.getY());

        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        CanvasMouseObserver.notifyOnMouseMoved(e.getX(), e.getY());

        repaint();
    }
}
