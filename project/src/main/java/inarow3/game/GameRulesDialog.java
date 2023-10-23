package inarow3.game;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.*;

/**
* In this class the game rules dialog is created, which is the first screen you see when opening
* the game. The rest of the game will not start until the start button on this screen is pressed.
*/
public class GameRulesDialog {

    /**
     * Create the game rules dialog, which is a pop-up screen that provides a short 
     * explanation of how the game works. When the button on the bottom of the screen is pressed
     * the game starts. The fruits are added to the playingfield after this.
     */
    static JDialog showGameRulesDialog(JFrame frame) {
        // Button to start the game.
        JButton startButton = new JButton("Start Game");
        startButton.setBackground(Color.WHITE);
        startButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        startButton.setBorderPainted(true);
        // TOdo startButton.addActionListener();

        JDialog gameRulesDialog = new JDialog(frame, "Game Rules");
        
        // Game rules, explanation of the game.
        String labelText = "When clicking on two tiles these tiles will change position. "
            + "When you possition three of the same fruit in a row, these fruits will disappear. "
            + "After every 3 moves, 3 extra fruits will be randomly added to the game. "
            + "The goal is to keep the game going as long as possible. "
            + "Once no more fruits can be added, you are game over. Are you ready to play?!";

        // Explanation of the game set to a label.
        JLabel labelRules = new JLabel("<html>" + labelText + "</html>");
        labelRules.setVerticalAlignment(JLabel.TOP);

        labelRules.setOpaque(true);
        labelRules.setBackground(Color.BLACK);
        labelRules.setForeground(Color.WHITE);

        // Add the label with the game rules and the start button to the dialog, with the button
        // positioned at the bottom and the text above the button.
        gameRulesDialog.add(labelRules, BorderLayout.CENTER);
        gameRulesDialog.add(startButton, BorderLayout.SOUTH);

        // Set the size of the dialog and adding it to the main frame
        gameRulesDialog.setVisible(true);
        gameRulesDialog.setSize(225, 225);
        gameRulesDialog.setLocationRelativeTo(frame);
        return gameRulesDialog;
    }
}
