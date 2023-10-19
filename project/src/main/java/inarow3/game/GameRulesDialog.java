package inarow3.game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.Scrollbar;

import javax.swing.*;

/**
* asd.
*/
public class GameRulesDialog {

    /**
     * asd.
     */
    static JDialog showGameRulesDialog(JFrame frame) {
        JDialog gameRulesDialog = new JDialog(frame, "Game Rules");

        JButton startButton = new JButton("Start Game");
        // startButton.addActionListener();
        
        JLabel labelRules = new JLabel("the goal of the game is to get three in a row"
            + " of the same character. this can be done by swapping two charcters,"
            + " or swapping a character with an empty square."
            + "once you place three of the same charcters in a row they will disappear."
            + "every 3 moves, 3 new random characters will appear, "
            + "making the game harder and harder"
            + "the goal of the game is to keep the game going as long as possible."
            + "once no more squares can be added anymore, the game is over");

        JPanel panelGameRules = new JPanel();
        panelGameRules.add(labelRules);

        gameRulesDialog.add(labelRules, BorderLayout.CENTER);
        gameRulesDialog.add(startButton, BorderLayout.SOUTH);

        gameRulesDialog.setVisible(true);
        gameRulesDialog.setSize(200, 200);
        gameRulesDialog.setLocationRelativeTo(frame);
        return gameRulesDialog;
    }
}