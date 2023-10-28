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
 *     In this class the end game dialog is created, which is the screen you see 
 *     when the game is over. You can then choose to play the game again or quit the game.
 */
public class EndGameDialog {
    String highscore = "";

    /**
     * Create the end game dialog, which is a pop-up screen, showing the score of your last game and
     * your highscore. And two buttons to either restart or exit the game. 
     */
    static JDialog showEndGameDialog(final JFrame frame) {

        final JDialog endGameDialog = new JDialog(frame, "Game Over");

        // Button to start the game again.
        JButton replayButton = new JButton(" Replay ");
        replayButton.setBackground(Color.WHITE);
        replayButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        replayButton.setBorderPainted(true);
        replayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { 
                endGameDialog.dispose();
            }
        });

        // Button to quit the game.
        JButton quitButton = new JButton(" Quit Game ");
        quitButton.setBackground(Color.WHITE);
        quitButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        quitButton.setBorderPainted(true);
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { 
                frame.dispose();
            }
        });

        // Icon of a crying pineapple, shown when you are game over.
        ImageIcon gifCryingPineapple = new ImageIcon(
            "project\\src\\main\\java\\inarow3\\game\\icons\\gif-crying-pineapple.gif");
        gifCryingPineapple.setImage(
            gifCryingPineapple.getImage().getScaledInstance(140, 125, Image.SCALE_DEFAULT));

        // Add the buttons to a panel, so that they can be possitioned next to each other.
        JPanel panelButtons = new JPanel();
        panelButtons.add(replayButton);
        panelButtons.add(quitButton);

        String score = "5";
        String highscore = "6";
        
        // Create labels for the four different elements shown in the top panel;
        // game over message, previously created icon, current score, highscore.
        JLabel labelGameOver = new JLabel("too bad, you are game over");
        labelGameOver.setForeground(Color.WHITE);
        JLabel labelGif = new JLabel(" ");
        labelGif.setIcon(gifCryingPineapple);
        JLabel labelCurrentScore = new JLabel("you have saved " + score + " fruits this round!");
        labelCurrentScore.setForeground(Color.WHITE);
        JLabel labelHighScore = new JLabel("your high score is: " + highscore);
        labelHighScore.setForeground(Color.WHITE);

        // Add labels to a panels.
        JPanel panelGameOver = new JPanel();
        panelGameOver.add(labelGameOver);
        panelGameOver.add(labelGif);
        panelGameOver.add(labelCurrentScore);
        panelGameOver.add(labelHighScore);
        panelGameOver.setBackground(Color.BLACK);

        // Add both panels to the dialog.
        endGameDialog.add(panelGameOver, BorderLayout.CENTER);
        endGameDialog.add(panelButtons, BorderLayout.SOUTH);

        // Set the size of the dialog and add it to the main frame.
        endGameDialog.setVisible(true);
        endGameDialog.setSize(265, 265);
        endGameDialog.setLocationRelativeTo(frame);
        return endGameDialog;
    } 
}
