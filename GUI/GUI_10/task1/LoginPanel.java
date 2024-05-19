package task1;

import javax.swing.*;
import java.awt.*;

public class LoginPanel extends JPanel {

    private Font font;
    private Dimension textFieldSize;
    private JPanel panelCenter;
    private JLabel loginLabel;
    private JTextField loginField;
    private JLabel passwordLabel;
    private JPasswordField passwordField;
    private JButton submitButton;

    public LoginPanel() {

        setLayout(new BorderLayout());

        font = new Font("Arial", Font.BOLD, 28);

        textFieldSize = new Dimension(300, 50);

        panelCenter = new JPanel();
        panelCenter.setLayout(new BoxLayout(panelCenter, BoxLayout.Y_AXIS));

        loginLabel = new JLabel("Login");
        loginLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        loginField = new JTextField();
        loginField.setPreferredSize(textFieldSize);
        loginField.setMinimumSize(textFieldSize);
        loginField.setMaximumSize(textFieldSize);
        loginField.setAlignmentX(Component.CENTER_ALIGNMENT);
        loginField.setFont(font);

        passwordLabel = new JLabel("Password");
        passwordLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        passwordField = new JPasswordField();
        passwordField.setPreferredSize(textFieldSize);
        passwordField.setMinimumSize(textFieldSize);
        passwordField.setMaximumSize(textFieldSize);
        passwordField.setAlignmentX(Component.CENTER_ALIGNMENT);
        passwordField.setFont(font);

        submitButton = new JButton("Submit");
        submitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        submitButton.addActionListener(e -> checkCredentials());
        submitButton.setFont(font);

        panelCenter.add(Box.createRigidArea(new Dimension(0, 10)));
        panelCenter.add(loginLabel);
        panelCenter.add(loginField);
        panelCenter.add(Box.createRigidArea(new Dimension(0, 10)));
        panelCenter.add(passwordLabel);
        panelCenter.add(passwordField);
        panelCenter.add(Box.createRigidArea(new Dimension(0, 10)));
        panelCenter.add(submitButton);

        add(panelCenter, BorderLayout.CENTER);
    }

    private void checkCredentials() {

        String enteredLogin = loginField.getText();
        String enteredPassword = new String(passwordField.getPassword());

        if (enteredLogin.equals(User.getLogin()) && enteredPassword.equals(User.getPassword())) {

            JOptionPane.showMessageDialog(null, "Success!");
        } else {

            JOptionPane.showMessageDialog(null, "Incorrect credentials!");
        }
    }

    public JButton getSubmitButton() {
        return submitButton;
    }
}
