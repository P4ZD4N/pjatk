package panels;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    private GamePanelTop gamePanelTop;
    private GamePanelCenter gamePanelCenter;
    private GamePanelBottom gamePanelBottom;

    public GamePanel() {

        setLayout(new BorderLayout());

        gamePanelTop = new GamePanelTop();
        gamePanelCenter = new GamePanelCenter(gamePanelTop);
        gamePanelBottom = new GamePanelBottom(gamePanelCenter);

        add(gamePanelTop, BorderLayout.NORTH);
        add(gamePanelCenter, BorderLayout.CENTER);
        add(gamePanelBottom, BorderLayout.SOUTH);
    }
}
