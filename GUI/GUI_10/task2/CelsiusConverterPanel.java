package task2;

import javax.swing.*;
import java.awt.*;

public class CelsiusConverterPanel extends JPanel {

    private Font font;
    private Dimension textFieldSize;
    private JPanel panelCenter;
    private JLabel celsiusLabel;
    private JLabel fahrenheitLabel;
    private JTextField celsiusTextField;
    private JButton convertButton;

    public CelsiusConverterPanel() {

        setLayout(new BorderLayout());

        font = new Font("Verdana", Font.BOLD, 28);

        textFieldSize = new Dimension(300, 50);

        panelCenter = new JPanel();
        panelCenter.setLayout(new BoxLayout(panelCenter, BoxLayout.Y_AXIS));

        celsiusLabel = new JLabel("Celsius");
        celsiusLabel.setFont(font);
        celsiusLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        celsiusTextField = new JTextField();
        celsiusTextField.setPreferredSize(textFieldSize);
        celsiusTextField.setMinimumSize(textFieldSize);
        celsiusTextField.setMaximumSize(textFieldSize);
        celsiusTextField.setFont(font);
        celsiusTextField.setAlignmentX(Component.CENTER_ALIGNMENT);

        convertButton = new JButton("Convert");
        convertButton.setFont(font);
        convertButton.addActionListener(e -> convert());
        convertButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        fahrenheitLabel = new JLabel("Fahrenheit");
        fahrenheitLabel.setFont(font);
        fahrenheitLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        panelCenter.add(Box.createRigidArea(new Dimension(0, 10)));
        panelCenter.add(celsiusLabel);
        panelCenter.add(celsiusTextField);
        panelCenter.add(Box.createRigidArea(new Dimension(0, 10)));
        panelCenter.add(convertButton);
        panelCenter.add(Box.createRigidArea(new Dimension(0, 30)));
        panelCenter.add(fahrenheitLabel);

        add(panelCenter, BorderLayout.CENTER);
    }

    private void convert() {

        try {
            int fahrenheits = (int) ((Double.parseDouble(celsiusTextField.getText())) * 1.8 + 32);

            fahrenheitLabel.setText(fahrenheits + " Fahrenheit");
        } catch (NumberFormatException e) {

            fahrenheitLabel.setText("Invalid argument!");
        }
    }
}
