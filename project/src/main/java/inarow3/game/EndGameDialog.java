package inarow3.game;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.*;

/**
 * sws.
 */
public class EndGameDialog {
    String highscore = "";

    /**
     * jkd.
     */
    static JDialog showEndGameDialog(JFrame frame) {
        String highscore = "6";

        JDialog endGameDialog = new JDialog(frame, "Game Over");

        JButton replayButton = new JButton("Replay");
        // replayButton.addActionListener();   IMPORTANT TO ADD

        JButton quitButton = new JButton("Quit Game");
        // quitButton.addActionListener();  IMPORTANT TO ADD

        JPanel panelButtons = new JPanel();
        panelButtons.add(replayButton);
        panelButtons.add(quitButton);
        
        JLabel labelGameOver = new JLabel("too bad, you are game over");
        JLabel labelHighScore = new JLabel("your high score is: " + highscore);

        JPanel panelGameOver = new JPanel();
        panelGameOver.add(labelGameOver, BorderLayout.NORTH);
        panelGameOver.add(labelHighScore, BorderLayout.SOUTH);
        panelGameOver.setBackground(Color.GREEN);

        endGameDialog.add(panelGameOver, BorderLayout.CENTER);
        endGameDialog.add(panelButtons, BorderLayout.SOUTH);

        endGameDialog.setVisible(true);
        endGameDialog.setSize(200, 200);
        endGameDialog.setLocationRelativeTo(frame);
        return endGameDialog;
    } 
}
