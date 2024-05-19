package task1;

import javax.swing.*;

public class LoginFrame extends JFrame {

    private LoginPanel loginPanel;

    public LoginFrame() {

        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 800);
        setLocationRelativeTo(null);
        setVisible(true);

        loginPanel = new LoginPanel();
        getRootPane().setDefaultButton(loginPanel.getSubmitButton());
        add(loginPanel);
    }
}
