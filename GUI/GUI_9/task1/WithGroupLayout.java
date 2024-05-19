package task1;

import javax.swing.*;

public class WithGroupLayout extends JPanel {

    public WithGroupLayout() {

        GroupLayout layout = new GroupLayout(this);

        setLayout(layout);

        JButton btn1 = new JButton("Button 1");
        JButton btn2 = new JButton("Button 2");
        JButton btn3 = new JButton("Button 3");

        layout.setHorizontalGroup(
                layout.createSequentialGroup()
                        .addComponent(btn1)
                        .addComponent(btn2)
                        .addComponent(btn3)
        );

        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(btn1)
                        .addComponent(btn2)
                        .addComponent(btn3)
        );
    }
}
