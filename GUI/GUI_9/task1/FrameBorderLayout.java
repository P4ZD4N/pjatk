package task1;

import javax.swing.*;

public class FrameBorderLayout extends JFrame {

    private WithBorderLayout withBorderLayout;

    public FrameBorderLayout() {

        super("Frame with BorderLayout");
        setSize(1200, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        withBorderLayout = new WithBorderLayout();
        add(withBorderLayout);
    }
}
