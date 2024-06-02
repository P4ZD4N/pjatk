package panels;

import javax.swing.*;
import java.awt.*;

public class MenuPanel extends JPanel {

    private JButton buttonPlay;

    public MenuPanel() {

        setLayout(new BorderLayout());

        buttonPlay = new JButton("Play");
        buttonPlay.setBackground(Color.ORANGE);
        buttonPlay.setForeground(Color.BLACK);
        buttonPlay.setFont(new Font("Arial", Font.BOLD,  96));
        buttonPlay.addActionListener(e -> startGame());

        add(buttonPlay, BorderLayout.CENTER);
    }

    public void startGame() {

        JOptionPane.showMessageDialog(null, "Get ready!");

        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
        frame.getContentPane().removeAll();
        frame.getContentPane().add(new GamePanel());
        frame.revalidate();
        frame.repaint();
    }
}
