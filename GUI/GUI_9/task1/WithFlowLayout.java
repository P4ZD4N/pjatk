package task1;

import javax.swing.*;
import java.awt.*;

public class WithFlowLayout extends JPanel {

    public WithFlowLayout() {

        setLayout(new FlowLayout());

        for (int i = 1; i <= 40; i++) {

            add(new JButton("Button" + i));
        }
    }
}
