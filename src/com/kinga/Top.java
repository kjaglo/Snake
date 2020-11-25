package com.kinga;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Top extends JPanel implements KeyListener, ActionListener {

    public static int xPos = 290;
    public static int yPos = 350;
    public static int ySpace = 90;

    public static int xButton = 30;
    public static int yButton = 50;
    public static int widthButton = 400;
    public static int heightButton = 77;

    public static int xScore = 200;

    public Rectangle player1 = new Rectangle(xPos-xButton, yPos+ySpace*1-yButton, widthButton, heightButton);
    public Rectangle player2 = new Rectangle(xPos-xButton, yPos+ySpace*2-yButton, widthButton, heightButton);
    public Rectangle player3 = new Rectangle(xPos-xButton, yPos+ySpace*3-yButton, widthButton, heightButton);

    public void paint(Graphics g){

        Graphics2D g2d = (Graphics2D)g;

        g.setColor(Color.WHITE);

        g.setFont(new Font("Aharoni", Font.PLAIN, 50));
        g.drawString("TOP", xPos+120, yPos-20);

        g.setFont(new Font("Aharoni", Font.PLAIN, 30));
        g.drawString("1. "+Game.nicks[0], xPos, yPos+ySpace*1);
        g.drawString("Score: "+Game.scores[0], xPos+xScore, yPos+ySpace*1);

        g.drawString("2. "+Game.nicks[1], xPos, yPos+ySpace*2);
        g.drawString("Score: "+Game.scores[1], xPos+xScore, yPos+ySpace*2);

        g.drawString("3. "+Game.nicks[2], xPos, yPos+ySpace*3);
        g.drawString("Score: "+Game.scores[2], xPos+xScore, yPos+ySpace*3);

        g.setFont(new Font("Aharoni", Font.PLAIN, 30));
        g.drawString("Press M to return to the MENU", 245, yPos+ySpace*4);

        g2d.draw(player1);
        g2d.draw(player2);
        g2d.draw(player3);

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

