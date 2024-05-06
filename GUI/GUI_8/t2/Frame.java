package t2;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {

    private int x;
    private int y;
    private int radius;

    public Frame(int x, int y, int radius) {

        super("Hello World!");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);


        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public void paint(Graphics graphics) {

        graphics.setColor(new Color(255, 1, 100));
        graphics.drawOval(x, y, radius, radius);
    }
}
