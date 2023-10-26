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
    private boolean[] takenPositions = new boolean[100];
    private int[] toBeAdded = new int[2];
    private int[] toBeAddedRows = new int[2];
    private int[] toBeAddedCols = new int[2];
    private int[] toBeRemovedRow = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
    private int[] toBeRemovedCol = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
    private ImageIcon gifIcon1 = new ImageIcon(
            "project\\src\\main\\java\\inarow3\\game\\icons\\gif-apple.gif");
    private ImageIcon gifIcon2 = new ImageIcon(
            "project\\src\\main\\java\\inarow3\\game\\icons\\gif-banana.gif");
    private ImageIcon gifIcon3 = new ImageIcon(
            "project\\src\\main\\java\\inarow3\\game\\icons\\gif-blueberry.gif");
    private ImageIcon gifIcon4 = new ImageIcon(
            "project\\src\\main\\java\\inarow3\\game\\icons\\gif-cherry.gif");
    private ImageIcon gifIcon5 = new ImageIcon(
            "project\\src\\main\\java\\inarow3\\game\\icons\\gif-grapes.gif");
    private ImageIcon gifIcon6 = new ImageIcon(
            "project\\src\\main\\java\\inarow3\\game\\icons\\gif-kiwi.gif");
    private ImageIcon gifIcon7 = new ImageIcon(
            "project\\src\\main\\java\\inarow3\\game\\icons\\gif-lemon.gif");
    private ImageIcon gifIcon8 = new ImageIcon(
            "project\\src\\main\\java\\inarow3\\game\\icons\\gif-orange.gif");
    private ImageIcon gifIcon9 = new ImageIcon(
            "project\\src\\main\\java\\inarow3\\game\\icons\\gif-pineapple.gif");
    private ImageIcon gifIcon10 = new ImageIcon(
            "project\\src\\main\\java\\inarow3\\game\\icons\\gif-strawberry.gif");
    void editImages() {
        int width = 60;
        int height = 60;
        gifIcon1.setImage(
            gifIcon1.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
        gifIcon2.setImage(
            gifIcon2.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
        gifIcon3.setImage(
            gifIcon3.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
        gifIcon4.setImage(
            gifIcon4.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
        gifIcon5.setImage(
            gifIcon5.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
        gifIcon6.setImage(
            gifIcon6.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
        gifIcon7.setImage(
            gifIcon7.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
        gifIcon8.setImage(
            gifIcon8.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
        gifIcon9.setImage(
            gifIcon9.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
        gifIcon10.setImage(
            gifIcon10.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
    }
        
    /*
     * .
     */
    public InARow3() {

        this.setLayout(gridLayout);
        imageButtons = new JButton[rows][cols];

        int newInitPosition;

        for (int i = 0; i < 15; i++) {
            newInitPosition = rand.nextInt(100);
            takenPositions[newInitPosition] = true;
            initialPositionsRow[i] = newInitPosition / 10;
            initialPositionsCol[i] = newInitPosition % 10;
            // System.out.println(initialPositionsRow[i] + " " + initialPositionsCol[i]);
        }

        editImages();
        createButtons(initialPositionsRow, initialPositionsCol, true);
    }

    public void createButtons(int[] toBeCreatedRow, int[] toBeCreatedCol, boolean initial) {
        // System.out.println("CALL");
        JButton imageButton = new JButton();
        int image;
        // Create and add image buttons to the grid with coordinates
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                imageButton = new JButton();
                if (initial) {
                    imageButtons[row][col] = imageButton;
                }
                for (int i = 0; i < toBeCreatedRow.length; i++) {
                    if (toBeCreatedRow[i] == row && toBeCreatedCol[i] == col) {
                        image = rand.nextInt(10);
                        switch (image) {
                            default: break;
                            case 0: {
                                imageButton = new JButton("1", gifIcon1);
                                break;
                            }
                            case 1: {
                                imageButton = new JButton("2", gifIcon2);
                                break;
                            }
                            case 2: {
                                imageButton = new JButton("3", gifIcon3);
                                break;
                            }
                            case 3: {
                                imageButton = new JButton("4", gifIcon4);
                                break;
                            }
                            case 4: {
                                imageButton = new JButton("5", gifIcon5);
                                break;
                            }
                            case 5: {
                                imageButton = new JButton("6", gifIcon6);
                                break;
                            }
                            case 6: {
                                imageButton = new JButton("7", gifIcon7);
                                break;
                            }
                            case 7: {
                                imageButton = new JButton("8", gifIcon8);
                                break;
                            }
                            case 8: {
                                imageButton = new JButton("9", gifIcon9);
                                break;
                            }
                            case 9: imageButton = new JButton("10", gifIcon10);
                        }
                    }
                }
                imageButton.setBackground(Color.BLACK);
                imageButton.setForeground(Color.BLACK);
                imageButton.setBorder(
                    BorderFactory.createLineBorder(Color.WHITE, 2));
                this.add(imageButton);
                if ("".equals(imageButtons[row][col].getText())) {
                    imageButtons[row][col] = imageButton;
                }
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
                    // System.out.println("Click");
                    if (prevRow != -1 && prevCol != -1) {
                        // System.out.println("Second");
                        swapImages(currentRow, currentCol, prevRow, prevCol);
                        // System.out.println(
                        //    currentRow + " " + currentCol + " " + prevRow + " " + prevCol);
                        prevRow = -1;
                        prevCol = -1;
                        // System.out.println(
                        //    currentRow + " " + currentCol + " " + prevRow + " " + prevCol);
                    } else {
                        // System.out.println("First");
                        // System.out.println(
                        //     currentRow + " " + currentCol + " " + prevRow + " " + prevCol);
                        prevRow = currentRow;
                        prevCol = currentCol;
                        //System.out.println(
                        //    currentRow + " " + currentCol + " " + prevRow + " " + prevCol);
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
        computerMove();
        checkXaxis();
        checkYaxis();
        refreshUI();

        // System.out.println(row1 + " " + col1 + " " + row2 + " " + col2);
    }

    public void computerMove() {
        int newImage; 
        for (int i = 0; i < 2; i++) {
            do {
                newImage = rand.nextInt(100);
            }
            while (takenPositions[newImage]);
            toBeAddedRows[i] = newImage / 10;
            toBeAddedCols[i] = newImage % 10;
        }
        createButtons(toBeAddedRows, toBeAddedCols, false);
    }

    public void checkXaxis() {
        String lastImage = "";
        int count = 0;
        
        // int toBeRemoved;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                // System.out.println(lastImage + " " + imageButtons[j][i].getText() + " " + j + " " + i + " called");
                if (!lastImage.equals("")) {
                    if (lastImage.equals(imageButtons[j][i].getText())) {
                        count++;
                    } else {
                        if (count >= 3) {
                            for (int t = j - 1; t >= j - count; t--) {
                                toBeRemovedRow[t] = t;
                                toBeRemovedCol[t] = i;
                            }
                            removeButtons(toBeRemovedRow, toBeRemovedCol);
                            for (int t = 0; t < 10; t++) {
                                toBeRemovedRow[t] = -1;
                                toBeRemovedCol[t] = -1;
                            }
                            count = 0;
                        }
                        
                        if (!imageButtons[j][i].getText().equals("")) {
                            count = 1;
                        } else {
                            count = 0;
                        }
                    }
                } else {
                    if (!imageButtons[j][i].getText().equals("")) {
                        count = 1;
                    } else {
                        count = 0;
                    }
                }
                lastImage = imageButtons[j][i].getText();
            }
            if (count >= 3) {
                for (int t = 9; t >= 9 - count + 1; t--) {
                    toBeRemovedRow[t] = t;
                    toBeRemovedCol[t] = i;
                }
                removeButtons(toBeRemovedRow, toBeRemovedCol);
                for (int t = 0; t < 10; t++) {
                    toBeRemovedRow[t] = -1;
                    toBeRemovedCol[t] = -1;
                }
                count = 0;
            }
            lastImage = "";
            count = 1;     
        }
        
        
        // return toBeRemoved;
    }

    public void checkYaxis() {
        String lastImage = "";
        int count = 0;
        
        // int toBeRemoved;
        for (int i = 0; i < 10; i++) {
            
            for (int j = 0; j < 10; j++) {
                
                        
                // System.out.println(lastImage + " " + imageButtons[j][i].getText() + " " + j + " " + i + " called");
                if (!lastImage.equals("")) {
                    if (lastImage.equals(imageButtons[i][j].getText())) {
                        count++;
                        System.out.println(count);
                    } else {
                        if (count >= 3) {
                            for (int t = j - 1; t >= j - count; t--) {
                                toBeRemovedRow[t] = i;
                                toBeRemovedCol[t] = t;
                                
                            }
                            
                            removeButtons(toBeRemovedRow, toBeRemovedCol);
                            for (int t = 0; t < 10; t++) {
                                toBeRemovedRow[t] = -1;
                                toBeRemovedCol[t] = -1;
                            }
                            count = 0;
                        }
                        
                        if (!imageButtons[i][j].getText().equals("")) {
                            count = 1;
                        } else {
                            count = 0;
                        }
                    }
                } else {
                    if (!imageButtons[i][j].getText().equals("")) {
                        count = 1;
                    } else {
                        count = 0;
                    }
                }
                lastImage = imageButtons[i][j].getText();
            }
            if (count >= 3) {
                for (int t = 9; t >= 9 - count + 1; t--) {
                    toBeRemovedRow[t] = t;
                    toBeRemovedCol[t] = i;
                    System.out.println(t + " " + i);
                }
                removeButtons(toBeRemovedRow, toBeRemovedCol);
                for (int t = 0; t < 10; t++) {
                    toBeRemovedRow[t] = -1;
                    toBeRemovedCol[t] = -1;
                }
                count = 0;
            }
            lastImage = "";
            count = 1;     
        }
        
        
        // return toBeRemoved;
    }

    public void removeButtons(int[] toBeRemovedRow, int[] toBeRemovedCol) {
        JButton imageButton = new JButton();
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                imageButton = new JButton();
                imageButton.setBackground(Color.BLACK);
                imageButton.setForeground(Color.BLACK);
                imageButton.setBorder(
                    BorderFactory.createLineBorder(Color.WHITE, 2));
                for (int i = 0; i < toBeRemovedRow.length; i++) {
                    if (toBeRemovedRow[i] == row && toBeRemovedCol[i] == col) {
                        imageButtons[row][col] = imageButton;
                        imageButtons[row][col].addActionListener(this);
                    }
                }
            }
        }
    }

    // public int[][] checkYaxis(int currentRow) {
    //     int[][] toBeRemoved = new int[2][];

    //     return toBeRemoved;
    // } 

    public void refreshUI() {
        this.removeAll();
        System.out.println("NEW UI");
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                // if (!imageButtons[row][col].getText().equals("")) {
                //     System.out.println(row + " " + col + " " + imageButtons[row][col].getText());
                // }
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
        // GameRulesDialog.showGameRulesDialog(frame);
        EndGameDialog.showEndGameDialog(frame);  // MAKING END DIALOG VISIBLE
    }

    /*
     * .
     */
    public static void main(String[] args) {
        new InARow3().start();
    }
    
}
