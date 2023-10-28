package inarow3.game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**.
 * @author Fleur Petit
 * @id     1640194
 * @author Hristian Sarmov
 * @id     1924087
 * @data   29-10-2023
* 
*      In this class the game rules dialog is created, which is the first screen you see when 
*      opening the game. The rest of the game will not start until the start button on this 
*      screen is pressed.
*/
public class GameRulesDialog {

    /**
     * asd.
     */
    static JDialog showGameRulesDialog(final JFrame frame) {

        final JDialog gameRulesDialog = new JDialog(frame, "Game Rules");

        // Button to start the game, the button opens the game level dialog
        JButton startButton = new JButton("Start Game");
        startButton.setBackground(Color.WHITE);
        startButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        startButton.setBorderPainted(true);
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent f) { 
                GameLevelDialog.showGameLevelDialog(frame);
                gameRulesDialog.dispose();
            }
        });
        
        // Game rules, explanation of the game.
        String labelText = " The fruits are trapped in a block and can only be freed by "
            + " placing three of the same fruit in a row. This can be done switching tiles "
            + " by clicking on them. When clicking on two tiles these tiles will change "
            + " position. When three of the same fruit are in a row, these fruits are free "
            + " and will disappear from the board. After every 3 moves, 3 extra fruits will "
            + " be randomly added to the game. The goal is to save as many fruits as possible "
            + " before the board is completely filled. "
            + " Once no more fruits can be added, you are game over. Are you ready to play?!";

        // Explanation of the game set to a label.
        JLabel labelRules = new JLabel("<html>" + labelText + "</html>");
        labelRules.setVerticalAlignment(JLabel.TOP);

        labelRules.setOpaque(true);
        labelRules.setBackground(Color.BLACK);
        labelRules.setForeground(Color.WHITE);

        gameRulesDialog.add(labelRules, BorderLayout.CENTER);
        gameRulesDialog.add(startButton, BorderLayout.SOUTH);

        // Set the size of the dialog and add it to the main frame
        gameRulesDialog.setVisible(true);
        gameRulesDialog.setSize(265, 265);
        gameRulesDialog.setLocationRelativeTo(frame);
        return gameRulesDialog;
    }
}