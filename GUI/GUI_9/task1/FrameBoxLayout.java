package task1;

import javax.swing.*;

public class FrameBoxLayout extends JFrame {

    private WithBoxLayout withBoxLayout;

    public FrameBoxLayout() {

        super("Frame with BoxLayout");
        setSize(1200, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        withBoxLayout = new WithBoxLayout();
        add(withBoxLayout);
    }
}
