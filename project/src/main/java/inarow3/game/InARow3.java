package inarow3.game;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*;

/**.
 * @author Fleur Petit
 * @id     1640194
 * @author Hristian Sarmov
 * @id     1924087
 * @data   29-10-2023
 * 
 */
public class InARow3 extends JPanel implements ActionListener, FruitRemovalRueles {

    public JFrame frame = new JFrame("3 In a Row");
    private JButton[][] imageButtons;
    private int rows = 10; // Number of rows in the grid
    private int cols = 10; // Number of columns in the grid
    private int prevRow = -1; // Initialize to an invalid value
    private int prevCol = -1; // Initialize to an invalid value
    private int moveAmount = 0; // Initialize at the start of the game
    public static int score = 0; // Initialize to an invalid value
    private int takenPositionsCount = 0; // Initialize to an invalid value
    private GridLayout gridLayout = new GridLayout(rows, cols);
    Random rand = new Random();
    private int []initialPositionsRow = new int[15];
    private int []initialPositionsCol = new int[15];
    private boolean[] takenPositions = new boolean[100];
    private int[] toBeAddedRows = new int[1000];
    private int[] toBeAddedCols = new int[1000];
    private int[] toBeRemovedRow = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
    private int[] toBeRemovedCol = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
    private Timer imageTimer;

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
    
    /**
     * Scale images down to the buttons' size. 
     */
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
        
    /**
     * Constructor that creates the layout and images.
     */
    public InARow3() {

        this.setLayout(gridLayout);
        imageButtons = new JButton[rows][cols];

        int newInitPosition;

        for (int i = 0; i < 15; i++) {
            newInitPosition = rand.nextInt(100);
            takenPositions[newInitPosition] = true;
            takenPositionsCount++;
            initialPositionsRow[i] = newInitPosition / 10;
            initialPositionsCol[i] = newInitPosition % 10;
        }

        editImages();
        createButtons(initialPositionsRow, initialPositionsCol, true);
    }

    /**
     * Always called at the start of the game and when the computer makes a move.
     */
    public void createButtons(int[] toBeCreatedRow, int[] toBeCreatedCol, boolean initial) {
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
    
    /*
     * Called on button clicked 
     * If called for the first time saves the clicked button
     * If called for the second time swaps the current with the previous button
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        int currentRow = -1;
        int currentCol = -1;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (imageButtons[row][col] == e.getSource()) {
                    if ((prevRow != -1 && prevCol != -1) 
                        || !imageButtons[row][col].getText().equals("")) {
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
                            imageButtons[prevRow][prevCol].setBorder(
                                BorderFactory.createLineBorder(Color.BLUE, 3));
                            //System.out.println(
                            //    currentRow + " " + currentCol + " " + prevRow + " " + prevCol);
                        }
                    }
                    
                }
            }
        }
    }

    /**
     * Swaps the state of two chosen buttons.
     */
    public void swapImages(int row1, int col1, int row2, int col2) {
        imageButtons[row2][col2].setBorder(
            BorderFactory.createLineBorder(Color.WHITE, 2));
        JButton swap = imageButtons[row1][col1];
        if (imageButtons[row1][col1].getText().equals("") 
            && !imageButtons[row2][col2].getText().equals("")) {
            takenPositions[row1 * 10 + col1] = true;
            takenPositions[row2 * 10 + col2] = false;
        } else if (!imageButtons[row1][col1].getText().equals("") 
                   && imageButtons[row2][col2].getText().equals("")) {
            takenPositions[row1 * 10 + col1] = false;
            takenPositions[row2 * 10 + col2] = true;
        }
        imageButtons[row1][col1] = imageButtons[row2][col2];
        imageButtons[row2][col2] = swap;
        computerMove();
        checkEnd();
        checkXaxis();
        checkYaxis();
        refreshUI();
    }
    /*
     * Checks for game over conditions. 
     */
    public void checkEnd() {
        int filled = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (!imageButtons[i][j].getText().equals("")) {
                    filled++;
                }
            }
        }
        if (filled >= 98) {
            EndGameDialog.showEndGameDialog(frame, String.valueOf(score));
        }
    }
    /**
     * The computer spawns fruit scaling with the difficulty and move count.
     */
    public void computerMove() {
        int newImage; 
        for (int i = 0; i < moveAmount; i++) {
            if (takenPositionsCount < 100) {
                do {
                    newImage = rand.nextInt(100);
                } while (takenPositions[newImage]);
                toBeAddedRows[i] = newImage / 10;
                toBeAddedCols[i] = newImage % 10;
                takenPositions[newImage] = true;
                takenPositionsCount++;
            } else {
                break;
            }
        }
        if (GameLevelDialog.difficulty == "easy") {
            moveAmount++;
        } else if (GameLevelDialog.difficulty == "medium") {
            moveAmount += 2;
        } else {
            moveAmount += 3;
        }
        createButtons(toBeAddedRows, toBeAddedCols, false);
    }

    /**
     * Checks for combinations of fruit ready to be removed.
     */
    public void checkXaxis() {
        String lastImage = "";
        int count = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
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
                            score += count;
                            takenPositionsCount -= count;
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
                score += count;
                takenPositionsCount -= count;
                count = 0;
            }
            lastImage = "";
            count = 1;     
        }
    }

    /**
     * Checks for combinations of fruit ready to be removed.
     */
    public void checkYaxis() {
        String lastImage = "";
        int count = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (!lastImage.equals("")) {
                    if (lastImage.equals(imageButtons[i][j].getText())) {
                        count++;
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
                            score += count;
                            takenPositionsCount -= count;
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
                    toBeRemovedRow[t] = i;
                    toBeRemovedCol[t] = t;
                }
                removeButtons(toBeRemovedRow, toBeRemovedCol);
                for (int t = 0; t < 10; t++) {
                    toBeRemovedRow[t] = -1;
                    toBeRemovedCol[t] = -1;
                }
                score += count;
                takenPositionsCount -= count;
                count = 0;
            }
            lastImage = "";
            count = 1;     
        }
    }

    /**
     * Removes the given buttons whenever the conditions are met.
     */
    public void removeButtons(int[] toBeRemovedRow, int[] toBeRemovedCol) {
        JButton imageButton = new JButton();

        final JDialog freeDialog = FreedomDialog.showFreedomDialog(frame);

        imageTimer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                freeDialog.dispose();
            }
        });

        imageTimer.setRepeats(false);
        imageTimer.start();

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
                        takenPositions[row * 10 + col] = false;
                        imageButtons[row][col].addActionListener(this);
                    }
                }
            }
        }
    } 

    /**
     * Refreshes the grid whenever new fruit are added or freed.
     */
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

    /**
     * Called at the start of the program. Creates the grid and starts the game.
     */
    public void start() {
        JPanel grid = new InARow3();
        frame.add(grid);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        StartGameDialog.showStartGameDialog(frame);
    }

    public static void main(String[] args) {
        new InARow3().start();
    }   
}