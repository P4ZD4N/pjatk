package t3;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {

    public Frame() {

        super("Shapes");
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(1400, 1000);
        getContentPane().setBackground(Color.BLACK);
    }
}
