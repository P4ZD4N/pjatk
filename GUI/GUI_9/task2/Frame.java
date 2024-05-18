package task2;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {

    private JPanel centerPanel;
    private JTextArea textArea1;
    private JTextArea textArea2;
    private JButton submitButton;

    public Frame() {

        setTitle("Task2 Frame");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 800);
        setLocationRelativeTo(null);
        setVisible(true);
        setLayout(new BorderLayout());

        centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.setBackground(Color.ORANGE);

        textArea1 = new JTextArea();
        textArea1.setFont(new Font("Arial", Font.BOLD, 34));
        textArea1.setBackground(Color.green);

        textArea2 = new JTextArea();
        textArea2.setFont(new Font("Arial", Font.BOLD, 34));
        textArea2.setBackground(Color.YELLOW);

        submitButton = new JButton("Submit");
        submitButton.addActionListener(e -> changeFrameTitle());

        textArea1.setAlignmentX(Component.CENTER_ALIGNMENT);
        textArea2.setAlignmentX(Component.CENTER_ALIGNMENT);
        submitButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        centerPanel.add(textArea1);
        centerPanel.add(textArea2);
        centerPanel.add(submitButton);

        add(centerPanel, BorderLayout.CENTER);
    }

    private void changeFrameTitle() {

        int numberFromTextArea1 = Integer.parseInt(textArea1.getText());
        int numberFromTextArea2 = Integer.parseInt(textArea2.getText());
        int sum = numberFromTextArea1 + numberFromTextArea2;

        setTitle(String.valueOf(sum));
    }
}
