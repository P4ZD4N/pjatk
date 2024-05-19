package task2;

import task1.LoginPanel;

import javax.swing.*;

public class CelsiusConverterFrame extends JFrame {

    private CelsiusConverterPanel celsiusConverterPanel;

    public CelsiusConverterFrame() {

        setTitle("Celsius Converted");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 800);
        setLocationRelativeTo(null);
        setVisible(true);

        celsiusConverterPanel = new CelsiusConverterPanel();
        add(celsiusConverterPanel);
    }
}
