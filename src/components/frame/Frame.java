package components.frame;

import javax.swing.*;

public class Frame {
    private final JFrame frame;

    public Frame(String title, JPanel panel) {
        frame = new JFrame(title);
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
    }

    public void show() {
        frame.setVisible(true);
    }
}
