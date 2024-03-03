package components.canvas;

import components.canvas.observers.CanvasKeyArrowObserver;
import components.canvas.observers.CanvasMouseObserver;
import components.canvas.observers.CanvasResizeObserver;
import components.canvas.shapes.ShapeComposite;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Canvas extends JPanel implements MouseMotionListener, ComponentListener, MouseListener, KeyListener {
    private final ShapeComposite components;

    public Canvas(ShapeComposite components) {
        this.components = components;
        this.setBackground(Color.BLACK);
        this.setFocusable(true);
        this.addMouseMotionListener(this);
        this.addComponentListener(this);
        this.addMouseListener(this);
        this.addKeyListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        components.draw(g);
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

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP -> CanvasKeyArrowObserver.notifyOnUpPressed();
            case KeyEvent.VK_DOWN -> CanvasKeyArrowObserver.notifyOnDownPressed();
            case KeyEvent.VK_RIGHT -> CanvasKeyArrowObserver.notifyOnRightPressed();
            case KeyEvent.VK_LEFT -> CanvasKeyArrowObserver.notifyOnLeftPressed();
        }

        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
