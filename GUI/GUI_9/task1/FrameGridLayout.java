package task1;

import javax.swing.*;

public class FrameGridLayout extends JFrame {

    private WithGridLayout withGridLayout;

    public FrameGridLayout() {

        super("Frame with FlowLayout");
        setSize(1200, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        withGridLayout = new WithGridLayout();
        add(withGridLayout);
    }
}
