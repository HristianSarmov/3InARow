package inarow3.game;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Random;

import javax.swing.*;

import org.w3c.dom.events.MouseEvent;

/*
 * adsfsadf.
 */

public class InARow3 extends JPanel implements ActionListener {

    private JFrame frame = new JFrame("3 In a Row");
    private JButton[][] imageButtons;
    private int rows = 10; // Number of rows in the grid
    private int cols = 10; // Number of columns in the grid
    private int prevRow = -1; // Initialize to an invalid value
    private int prevCol = -1;
    private GridLayout gridLayout = new GridLayout(rows, cols);
    Random rand = new Random();
    private int []initialPositionsRow = new int[15];
    private int []initialPositionsCol = new int[15];
    /*
     * .
     */
    public InARow3() {

        this.setLayout(gridLayout);
        imageButtons = new JButton[rows][cols];

        // Load a GIF image
        
        ImageIcon gifIcon1 = new ImageIcon("src\\main\\java\\inarow3\\game\\icons\\gif-apple.gif");
        ImageIcon gifIcon2 = new ImageIcon("src\\main\\java\\inarow3\\game\\icons\\gif-banana.gif");
        ImageIcon gifIcon3 = new ImageIcon(
            "src\\main\\java\\inarow3\\game\\icons\\gif-blueberry.gif");
        ImageIcon gifIcon4 = new ImageIcon("src\\main\\java\\inarow3\\game\\icons\\gif-cherry.gif");
        ImageIcon gifIcon5 = new ImageIcon("src\\main\\java\\inarow3\\game\\icons\\gif-grapes.gif");
        ImageIcon gifIcon6 = new ImageIcon("src\\main\\java\\inarow3\\game\\icons\\gif-kiwi.gif");
        ImageIcon gifIcon7 = new ImageIcon("src\\main\\java\\inarow3\\game\\icons\\gif-lemon.gif");
        ImageIcon gifIcon8 = new ImageIcon("src\\main\\java\\inarow3\\game\\icons\\gif-orange.gif");
        ImageIcon gifIcon9 = new ImageIcon(
            "src\\main\\java\\inarow3\\game\\icons\\gif-pineapple.gif");
        ImageIcon gifIcon10 = new ImageIcon(
            "src\\main\\java\\inarow3\\game\\icons\\gif-strawberry.gif");

        int width = 60;
        int height = 60;
        gifIcon4.setImage(gifIcon4.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));

        int newInitPosition;
        for (int i = 0; i < 15; i++) {
            newInitPosition = rand.nextInt(100);
            initialPositionsRow[i] = newInitPosition / 10;
            initialPositionsCol[i] = newInitPosition % 10;
            // System.out.println(initialPositionsRow[i] + " " + initialPositionsCol[i]);
        }

        // Create and add image buttons to the grid with coordinates
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                JButton imageButton = new JButton(gifIcon4);
                this.add(imageButton);
                imageButtons[row][col] = imageButton;
                imageButton.addActionListener(this);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // if (SwingUtilities.isLeftMouseButton(mouseEvent)) {
        //    // Perform your action here for left mouse button click
        //     JOptionPane.showMessageDialog(frame, "Left Mouse Button Clicked!");
        // }
        int currentRow = -1;
        int currentCol = -1;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (imageButtons[row][col] == e.getSource()) {
                    currentRow = row;
                    currentCol = col;
                    System.out.println("Click");
                    if (prevRow != -1 && prevCol != -1) {
                        System.out.println("Second");
                        swapImages(currentRow, currentCol, prevRow, prevCol);
                        System.out.println(currentRow + " " + currentCol + " " + prevRow + " " + prevCol);
                        prevRow = -1;
                        prevCol = -1;
                        System.out.println(currentRow + " " + currentCol + " " + prevRow + " " + prevCol);
                    } else {
                        System.out.println("First");
                        System.out.println(currentRow + " " + currentCol + " " + prevRow + " " + prevCol);
                        prevRow = currentRow;
                        prevCol = currentCol;
                        System.out.println(currentRow + " " + currentCol + " " + prevRow + " " + prevCol);
                    }
                }
            }
        }
        // System.out.println(e.getSource().toString());
    }

    public void swapImages(int row1, int col1, int row2, int col2) {
        JButton swap = imageButtons[row1][col1];
        imageButtons[row1][col1] = imageButtons[row2][col2];
        imageButtons[row2][col2] = swap;
        refreshUI();
        // System.out.println(row1 + " " + col1 + " " + row2 + " " + col2);
    }

    public void refreshUI() {
        this.removeAll();
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                this.add(imageButtons[row][col]);
            }
        }
        this.revalidate();
        this.repaint();
    }

    public void start() {
        JPanel grid = new InARow3();
        frame.add(grid);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        GameRulesDialog.showGameRulesDialog(frame);
    }

    /*
     * .
     */
    public static void main(String[] args) {
        new InARow3().start();
    }
    
}