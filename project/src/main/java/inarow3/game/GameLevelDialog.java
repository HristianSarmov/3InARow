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
 * @date   29-10-2023
 * 
 *     In this class the game level dialog is created, which is the third screen you see 
 *     in the game and the last before you start playing. Here you can choose the level of the game.
 */
public class GameLevelDialog {
    /**
     * Create the game level dialog, which is a pop-up screen, showing three buttons
     * to choose the level of difficulty you want to play the game in.
     */

    public static String difficulty;
    static JDialog showGameLevelDialog(JFrame frame) {

        final JDialog gameLevelDialog = new JDialog(frame, "Game level");

        // Button to start the game on easy level.
        JButton level1Button = new JButton("      Easy      ");
        level1Button.setBackground(Color.WHITE);
        level1Button.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        level1Button.setBorderPainted(true);
        level1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { 
                difficulty = "easy";
                gameLevelDialog.dispose();
            }
        });

        // Button to start the game on medium difficulty level.
        JButton level2Button = new JButton("   Medium   ");
        level2Button.setBackground(Color.WHITE);
        level2Button.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        level2Button.setBorderPainted(true);
        level2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { 
                gameLevelDialog.dispose();
                difficulty = "medium";
            }
        });

        // Button to start the game on hard level.
        JButton level3Button = new JButton("      Hard      ");
        level3Button.setBackground(Color.WHITE);
        level3Button.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        level3Button.setBorderPainted(true);
        level3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { 
                gameLevelDialog.dispose();
                difficulty = "hard";
            }
        });
    
        // Create choose level message
        JLabel labelChooseLevel = new JLabel("Choose your level of difficulty");
        labelChooseLevel.setForeground(Color.WHITE);

        // Create panel for the choose level message
        JPanel panelLevels = new JPanel();
        panelLevels.add(labelChooseLevel);
        panelLevels.setBackground(Color.BLACK);

        // Create panel for the different level buttons
        JPanel panelButtons = new JPanel();
        panelButtons.add(level1Button, BorderLayout.NORTH);
        panelButtons.add(level2Button, BorderLayout.CENTER);
        panelButtons.add(level3Button, BorderLayout.SOUTH);
        panelButtons.setBackground(Color.BLACK);

        // Add both panels to the dialog.
        gameLevelDialog.add(panelLevels);
        gameLevelDialog.add(panelButtons, BorderLayout.SOUTH);

        // A new panel is created to add a write border around the dialog.
        JPanel borderGLPanel = new JPanel(new BorderLayout());
        borderGLPanel.setBorder(new EmptyBorder(3, 3, 3, 3));
        borderGLPanel.setBackground(Color.WHITE);

        borderGLPanel.add(panelLevels);
        borderGLPanel.add(panelButtons, BorderLayout.SOUTH);

        gameLevelDialog.add(borderGLPanel, BorderLayout.CENTER);

        // Set the size of the dialog and add it to the main frame.
        gameLevelDialog.setUndecorated(true);
        gameLevelDialog.setSize(265, 100);
        gameLevelDialog.setLocationRelativeTo(frame);
        gameLevelDialog.setModal(true);
        gameLevelDialog.setVisible(true);
        return gameLevelDialog;
    } 
}