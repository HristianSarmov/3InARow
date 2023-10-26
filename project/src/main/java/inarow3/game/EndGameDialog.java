package inarow3.game;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.*;

/**.
 * @author Fleur Petit
 * @id     1640194
 * @author Hristian Sarmov
 * @id     1924087
 * @data   29-10-2023
 * 
 *     In this class the end game dialog is created, which is the screen you see 
 *     when the game is over. You can then choose to play the game again or quit the game.
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

        // Icon of a crying pineapple, shown when you are game over.
        ImageIcon gifCryingPineapple = new ImageIcon(
            "project\\src\\main\\java\\inarow3\\game\\icons\\gif-crying-pineapple.gif");
        gifCryingPineapple.setImage(
            gifCryingPineapple.getImage().getScaledInstance(140, 125, Image.SCALE_DEFAULT));

        // Add the buttons to a panel, so that they can be possitioned next to each other.
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

        // Set the size of the dialog and add it to the main frame.
        endGameDialog.setVisible(true);
        endGameDialog.setSize(265, 265);
        endGameDialog.setLocationRelativeTo(frame);
        return endGameDialog;
    } 
}