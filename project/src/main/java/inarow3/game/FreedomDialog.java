package inarow3.game;

import java.awt.BorderLayout;
import java.awt.Image;
import javax.swing.*;

/**.
 * @author Fleur Petit
 * @id     1640194
 * @author Hristian Sarmov
 * @id     1924087
 * @data   29-10-2023
 */
public class FreedomDialog {

    /**
     * Create the end game dialog, which is a pop-up screen, showing the score of your last game and
     * your highscore. And two buttons to either restart or exit the game. 
     */
    static JDialog showFreedomDialog(final JFrame frame) {

        final JDialog freedomDialog = new JDialog(frame, "Well done!");

        // Icon of a crying pineapple, shown when you are game over.
        ImageIcon imageIcon = new ImageIcon(
            "project\\src\\main\\java\\inarow3\\game\\icons\\gif-freedom.gif");
        imageIcon.setImage(
            imageIcon.getImage().getScaledInstance(265, 180, Image.SCALE_DEFAULT));
        
        JLabel labelFreedom = new JLabel(imageIcon);
        labelFreedom.setHorizontalAlignment(JLabel.CENTER);

        freedomDialog.add(labelFreedom, BorderLayout.CENTER);

        // Set the size of the dialog and add it to the main frame.
        freedomDialog.setVisible(true);
        freedomDialog.setSize(265, 265);
        freedomDialog.setLocationRelativeTo(frame);
        return freedomDialog;
    }
}