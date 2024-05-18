package task3;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {

    private JPanel panelTop;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JPanel panelCenter;
    private JLabel label;

    public Frame() {

        setTitle("Task3 Frame");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 800);
        setLocationRelativeTo(null);
        setVisible(true);
        setLayout(new BorderLayout());

        panelTop = new JPanel();

        button1 = new JButton("Button 1");
        button1.addActionListener(e -> changeLabel(button1));
        button2 = new JButton("Button 2");
        button2.addActionListener(e -> changeLabel(button2));
        button3 = new JButton("Button 3");
        button3.addActionListener(e -> changeLabel(button3));

        panelTop.add(button1);
        panelTop.add(button2);
        panelTop.add(button3);

        panelCenter = new JPanel();

        label = new JLabel("-");

        panelCenter.add(label);

        add(panelTop, BorderLayout.NORTH);
        add(panelCenter, BorderLayout.CENTER);
    }

    private void changeLabel(JButton button) {

        label.setText(button.getText());
    }
}
