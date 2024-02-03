package week1;

import javax.swing.*;

public class Frame {
    private final JFrame frame;

    public Frame(JPanel panel) {
        frame = new JFrame("Week 1 - Bresenham's algorithm");
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
    }

    public void show() {
        frame.setVisible(true);
    }
}
