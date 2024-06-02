package panels;

import javax.swing.*;
import java.awt.*;

public class GamePanelBottom extends JPanel {

    private JButton buttonTop;
    private JButton buttonRight;
    private JButton buttonBottom;
    private JButton buttonLeft;

    public GamePanelBottom(GamePanelCenter gamePanelCenter) {

        setBackground(Color.ORANGE);
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();

        buttonTop = new JButton("/\\");
        buttonTop.setBackground(Color.BLACK);
        buttonTop.setForeground(Color.WHITE);
        buttonTop.addActionListener(e -> gamePanelCenter.moveCharacter(-1, 0));

        buttonRight = new JButton(">");
        buttonRight.setBackground(Color.BLACK);
        buttonRight.setForeground(Color.WHITE);
        buttonRight.addActionListener(e -> gamePanelCenter.moveCharacter(0, 1));

        buttonBottom = new JButton("\\/");
        buttonBottom.setBackground(Color.BLACK);
        buttonBottom.setForeground(Color.WHITE);
        buttonBottom.addActionListener(e -> gamePanelCenter.moveCharacter(1, 0));

        buttonLeft = new JButton("<");
        buttonLeft.setBackground(Color.BLACK);
        buttonLeft.setForeground(Color.WHITE);
        buttonLeft.addActionListener(e -> gamePanelCenter.moveCharacter(0, -1));

        gbc.gridx = 1;
        gbc.gridy = 0;
        add(buttonTop, gbc);

        gbc.gridx = 2;
        gbc.gridy = 1;
        add(buttonRight, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        add(buttonBottom, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(buttonLeft, gbc);
    }
}