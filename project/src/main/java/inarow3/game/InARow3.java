package inarow3.game;

import java.awt.*;
import java.util.Random;

import javax.swing.*;


/** Start.
 * 
 */ 
public class InARow3 {
    

    static JFrame frame = new JFrame("3 In a Row");
    
    JButton button;

    Random rand = new Random();

    /** .
     * 
     */
    void frame() {
        frame.setLayout(new GridLayout(10, 10));
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                int buttonType = rand.nextInt(0, 11);
                button = new GridButtons().gridButton(buttonType, i, j);
                frame.add(button);
            }
        }
        
        frame.setVisible(true);
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    } 

    /** asdf.
     * 
     */
    public static void main(String[] args) {
        new InARow3().frame();
        new GameRulesDialog().showGameRulesDialog(frame);
    }
}