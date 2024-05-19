package task1;

import javax.swing.*;

public class FrameGroupLayout extends JFrame {

    private WithGroupLayout withGroupLayout;

    public FrameGroupLayout() {

        super("Frame with FlowLayout");
        setSize(1200, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        withGroupLayout = new WithGroupLayout();
        add(withGroupLayout);
    }
}
