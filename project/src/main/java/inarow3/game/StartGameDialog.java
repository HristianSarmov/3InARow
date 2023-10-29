package inarow3.game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
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
 *     In this class the start game dialog is created, which is the screen you see first
 *     when opening the game.
 */
public class StartGameDialog {
    /**
     * Create the start game dialog, which is a pop-up screen, introducing the characters and the 
     * goal of the game; 'rescue' the locked up fruits.
     */

    static JDialog showStartGameDialog(final JFrame frame) {

        final JDialog startGameDialog = new JDialog(frame, "Welcome to this game!");

        // Button to start the game.
        JButton startGameButton = new JButton(" Rescue the fruits ");
        startGameButton.setBackground(Color.WHITE);
        startGameButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        startGameButton.setBorderPainted(true);
        startGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { 
                GameRulesDialog.showGameRulesDialog(frame);
                startGameDialog.dispose();
            }
        });

        // Icon of the fruit characters.
        ImageIcon gifDancingFruits = new ImageIcon(
            "project\\src\\main\\java\\inarow3\\game\\icons\\gif-fruits-dance.gif");
        gifDancingFruits.setImage(
            gifDancingFruits.getImage().getScaledInstance(145, 180, Image.SCALE_DEFAULT));
        
        // Create labels for the fruit characters gif and game goal message.
        JLabel labelHelpFruits = new JLabel("These fruits are trapped and need your help!");
        labelHelpFruits.setForeground(Color.WHITE);
        JLabel labelGif = new JLabel(" ");
        labelGif.setIcon(gifDancingFruits);

        // Add labels to a panel.
        JPanel panelStartGame = new JPanel();
        panelStartGame.add(labelGif);
        panelStartGame.add(labelHelpFruits);
        panelStartGame.setBackground(Color.BLACK);

        // Add both panels to the dialog.
        startGameDialog.add(panelStartGame, BorderLayout.CENTER);
        startGameDialog.add(startGameButton, BorderLayout.SOUTH);

        // Set the size of the dialog and add it to the main frame.
        startGameDialog.setSize(265, 265);
        startGameDialog.setLocationRelativeTo(frame);
        startGameDialog.setModal(true);
        startGameDialog.setVisible(true);
        
        return startGameDialog;
    }
}