package t3;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {

    public Frame() {

        super("Hello World!");
        setSize(1920, 1080);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void paint(Graphics graphics) {

        graphics.setColor(new Color(255, 1, 100));
    }
}
