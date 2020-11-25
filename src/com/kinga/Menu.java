package com.kinga;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Menu extends JPanel implements KeyListener, ActionListener {

    public static int xPos = 420;
    public static int yPos = 350;
    public static int ySpace = 90;

    public static int xButton = 30;
    public static int yButton = 50;
    public static int widthButton = 130;
    public static int heightButton = 77;

    public Rectangle playButton = new Rectangle(xPos - xButton, yPos + ySpace * 1 - yButton, widthButton, heightButton);
    public Rectangle helpButton = new Rectangle(xPos - xButton, yPos + ySpace * 2 - yButton, widthButton, heightButton);
    public Rectangle topButton = new Rectangle(xPos - xButton, yPos + ySpace * 3 - yButton, widthButton, heightButton);
    public Rectangle exitButton = new Rectangle(xPos - xButton, yPos + ySpace * 4 - yButton, widthButton, heightButton);

    public void paint(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;

        g.setColor(Color.WHITE);

        g.setFont(new Font("Aharoni", Font.PLAIN, 50));
        g.drawString("MENU", xPos - 40, yPos - 20);

        g.setFont(new Font("Aharoni", Font.PLAIN, 30));
        g.drawString("PLAY", xPos, yPos + ySpace * 1);
        g.setFont(new Font("Aharoni", Font.PLAIN, 30));
        g.drawString("HELP", xPos, yPos + ySpace * 2);
        g.setFont(new Font("Aharoni", Font.PLAIN, 30));
        g.drawString("TOP", xPos + 7, yPos + ySpace * 3);
        g.setFont(new Font("Aharoni", Font.PLAIN, 30));
        g.drawString("EXIT", xPos + 7, yPos + ySpace * 4);

        g2d.draw(playButton);
        g2d.draw(helpButton);
        g2d.draw(topButton);
        g2d.draw(exitButton);

        g.dispose();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

}

