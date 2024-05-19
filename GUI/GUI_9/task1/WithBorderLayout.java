package task1;

import javax.swing.*;
import java.awt.*;

public class WithBorderLayout extends JPanel {

    private JButton buttonNorth;
    private JButton buttonWest;
    private JButton buttonCenter;
    private JButton buttonEast;
    private JButton buttonSouth;

    public WithBorderLayout() {

        setLayout(new BorderLayout());

        buttonNorth = new JButton("North");
        buttonWest = new JButton("West");
        buttonCenter = new JButton("Center");
        buttonEast = new JButton("East");
        buttonSouth = new JButton("South");

        add(buttonNorth, BorderLayout.NORTH);
        add(buttonWest, BorderLayout.WEST);
        add(buttonCenter, BorderLayout.CENTER);
        add(buttonEast, BorderLayout.EAST);
        add(buttonSouth, BorderLayout.SOUTH);
    }
}
