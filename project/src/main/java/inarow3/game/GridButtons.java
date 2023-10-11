package inarow3.game;

import javax.swing.*;
/**
     * asdf.
     */

public class GridButtons {
    
    /**
     * asdf.
     */
    JButton gridButton(int buttonType, int x, int y) {
        ImageIcon icon = new ImageIcon("project\\src\\main\\java\\inarow3\\game\\icons\\pngtree-a-strawberry-image_1144087.jpg");
        JButton button = new JButton(icon);

        button.setName(String.valueOf(x) + String.valueOf(y) + String.valueOf(buttonType));

        return button;
    }
}
