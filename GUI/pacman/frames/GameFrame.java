package frames;

import panels.MenuPanel;

import javax.swing.*;

public class GameFrame extends JFrame {

    private MenuPanel menuPanel;

    public GameFrame() {

        super("Pacman");
        setSize(1200, 800);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        menuPanel = new MenuPanel();
        add(menuPanel);
    }
}
