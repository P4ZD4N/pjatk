package panels;

import javax.swing.*;
import java.awt.*;

public class GamePanelTop extends JPanel {

    private int score = 0;
    private int seconds = 0;

    private JLabel scoreLabel;
    private JLabel gameTimeLabel;

    private JButton resetButton;

    private GridBagConstraints gbc;

    private Timer timer;

    public GamePanelTop() {

        setBackground(Color.ORANGE);
        setLayout(new GridBagLayout());

        scoreLabel = new JLabel(score + " points");
        gameTimeLabel = new JLabel(seconds + " seconds");
        resetButton = new JButton("Reset");
        resetButton.setBackground(Color.BLACK);
        resetButton.setForeground(Color.WHITE);
        resetButton.addActionListener(e -> startNewGame());
        gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10);
        add(scoreLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        add(gameTimeLabel, gbc);

        gbc.gridx = 2;
        gbc.gridy = 0;
        add(resetButton, gbc);

        timer = new Timer(1000, e -> gameTimeLabel.setText(seconds++ + " seconds"));
        timer.start();
    }

    public void updateScore() {

        score += 1;
        scoreLabel.setText(score + " points");
    }

    private void startNewGame() {

        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
        frame.getContentPane().removeAll();
        frame.getContentPane().add(new GamePanel());
        frame.revalidate();
        frame.repaint();
    }
}
