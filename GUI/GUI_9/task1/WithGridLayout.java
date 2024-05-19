package task1;

import javax.swing.*;
import java.awt.*;

public class WithGridLayout extends JPanel {

    public WithGridLayout() {

        setLayout(new GridLayout(3, 3));

        for (int i = 1; i <= 9; i++) {

            add(new JButton("Button" + i));
        }
    }
}
