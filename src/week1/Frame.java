package week1;

import javax.swing.*;

public class Frame extends JFrame {
    public Frame(JPanel panel) {
        super("Week 1 - Bresenham's algorithm");

        this.add(panel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
