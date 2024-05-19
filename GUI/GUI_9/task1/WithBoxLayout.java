package task1;

import javax.swing.*;

public class WithBoxLayout extends JPanel {

    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;

    public WithBoxLayout() {

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        button1 = new JButton("Button 1");
        button2 = new JButton("Button 2");
        button3 = new JButton("Button 3");
        button4 = new JButton("Button 4");
        button5 = new JButton("Button 5");

        add(button1);
        add(button2);
        add(button3);
        add(button4);
        add(button5);
    }
}
