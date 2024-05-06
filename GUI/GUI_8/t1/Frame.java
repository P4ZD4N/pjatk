package t1;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {

    public Frame() {

        super("Hello World!");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void paint(Graphics graphics) {

        int currentWidth = getWidth();
        int currentHeight = getHeight();

        graphics.setColor(new Color(255, 1, 100));
        graphics.drawOval(currentWidth / 2, currentHeight / 2, 60, 60);
    }
}
