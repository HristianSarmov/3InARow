package inarow3.game;

import javax.swing.*;

/**
* asd.
*/
public class GameRulesDialog {

    /**
     * asd.
     */
    JDialog showGameRulesDialog(JFrame frame) {
        JDialog gameRulesDialog = new JDialog(frame, "Game Rules");
        gameRulesDialog.setVisible(true);
        gameRulesDialog.setSize(200, 200);
        gameRulesDialog.setLocationRelativeTo(frame);
        return gameRulesDialog;
    }
}
