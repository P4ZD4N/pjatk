package task1;

import javax.swing.*;

public class FrameFlowLayout extends JFrame {

    private WithFlowLayout withFlowLayout;

    public FrameFlowLayout() {

        super("Frame with FlowLayout");
        setSize(1200, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        withFlowLayout = new WithFlowLayout();
        add(withFlowLayout);
    }
}
