package com.kinga;

import javax.swing.*;
import java.awt.*;

public class Main {
   public static JFrame object = new JFrame();

    public static void main(String[] args) {

        Game game = new Game();

        int screenWidth = 918;
        int screenHeight = 870;

        ImageIcon img = new ImageIcon("snake.jpg");

        object.setSize(screenWidth,screenHeight);
        object.setLocationRelativeTo(null);//center the window
        object.setTitle("Hungry Snake 2.0");
        object.setResizable(false); //no resizable window
        object.setBackground(Color.DARK_GRAY);
        object.setIconImage(img.getImage());
        object.add(game);
        object.setVisible(true);
        object.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
