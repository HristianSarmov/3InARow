package inarow3.game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

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
                gameRulesDialog.dispose();
                GameLevelDialog.showGameLevelDialog(frame);
            }
        });
        
        // Game rules, explanation of the game.
        String labelText = " The fruits are trapped in a block and can only be freed by "
            + " placing three of the same fruit in a row. This can be done by changing the "
            + " position of the fruits. When clicking on two fruits, or a fruit and an empty "
            + " tile, these tiles will change "
            + " position. When three of the same fruit are in a row, these fruits are free "
            + " and will disappear from the board. After every move, extra fruits will "
            + " be randomly added to the game. The goal is to save as many fruits as possible, "
            + " before the board is completely filled. Are you ready to play?!";

        // Explanation of the game set to a label.
        JLabel labelRules = new JLabel("<html>" + labelText + "</html>");
        labelRules.setVerticalAlignment(JLabel.TOP);

        labelRules.setOpaque(true);
        labelRules.setBackground(Color.BLACK);
        labelRules.setForeground(Color.WHITE);

        gameRulesDialog.add(labelRules, BorderLayout.CENTER);
        gameRulesDialog.add(startButton, BorderLayout.SOUTH);
        
        // A new panel is created to add a write border around the dialog.
        JPanel borderGRPanel = new JPanel(new BorderLayout());
        borderGRPanel.setBorder(new EmptyBorder(3, 3, 3, 3));
        borderGRPanel.setBackground(Color.WHITE);

        borderGRPanel.add(labelRules, BorderLayout.CENTER);
        borderGRPanel.add(startButton, BorderLayout.SOUTH);

        gameRulesDialog.add(borderGRPanel, BorderLayout.CENTER);
        // Set the size of the dialog and add it to the main frame
        gameRulesDialog.setUndecorated(true);
        gameRulesDialog.setSize(265, 265);
        gameRulesDialog.setLocationRelativeTo(frame);
        gameRulesDialog.setModal(true);
        gameRulesDialog.setVisible(true);
        return gameRulesDialog;
    }
}