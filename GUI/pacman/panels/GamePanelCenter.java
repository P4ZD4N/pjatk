package panels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Random;

public class GamePanelCenter extends JPanel {

    private final int ROWS = 20;
    private final int COLS = 30;

    private int characterRow;
    private int characterCol;
    private int pointRow;
    private int pointCol;

    private JLabel[][] labels;

    private GamePanelTop gamePanelTop;

    private Random random;

    public GamePanelCenter(GamePanelTop gamePanelTop) {

        setLayout(new GridLayout(ROWS, COLS));
        setBackground(Color.ORANGE);

        this.gamePanelTop = gamePanelTop;
        labels = new JLabel[ROWS][COLS];
        characterRow = ROWS / 2;
        characterCol = COLS / 2;
        random = new Random();

        for (int row = 0; row < ROWS; row++) {

            for (int col = 0; col < COLS; col++) {

                JLabel label;

                if (row == characterRow && col == characterCol) {
                    label = new JLabel("X", SwingConstants.CENTER);
                } else {
                    label = new JLabel("O", SwingConstants.CENTER);
                }

                label.setFont(new Font("Serif", Font.BOLD, 24));
                labels[row][col] = label;

                add(label);
            }
        }

        setupKeyBindings();
        determinePointLocation();
    }

    public void moveCharacter(int row, int col) {

        int newRow = characterRow + row;
        int newCol = characterCol + col;

        if (newRow >= 0 && newRow < ROWS && newCol >= 0 && newCol < COLS) {

            labels[characterRow][characterCol].setText("O");
            characterRow = newRow;
            characterCol = newCol;

            if (characterRow == pointRow && characterCol == pointCol) {

                gamePanelTop.updateScore();
                determinePointLocation();
            }

            labels[characterRow][characterCol].setText("X");
        }
    }

    private void setupKeyBindings() {

        InputMap inputMap = getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap actionMap = getActionMap();

        inputMap.put(KeyStroke.getKeyStroke("UP"), "moveUp");
        inputMap.put(KeyStroke.getKeyStroke("DOWN"), "moveDown");
        inputMap.put(KeyStroke.getKeyStroke("LEFT"), "moveLeft");
        inputMap.put(KeyStroke.getKeyStroke("RIGHT"), "moveRight");

        actionMap.put("moveUp", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                moveCharacter(-1, 0);
            }
        });

        actionMap.put("moveDown", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                moveCharacter(1, 0);
            }
        });

        actionMap.put("moveLeft", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                moveCharacter(0, -1);
            }
        });

        actionMap.put("moveRight", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                moveCharacter(0, 1);
            }
        });
    }

    private void determinePointLocation() {

        do {

            pointRow = random.nextInt(ROWS);
            pointCol = random.nextInt(COLS);
        } while (pointRow == characterRow && pointCol == characterCol);

        labels[pointRow][pointCol].setText("@");
    }
}
