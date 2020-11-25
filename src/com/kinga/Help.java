package com.kinga;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Help extends JPanel implements KeyListener, ActionListener {


    public static int xPosHELP = 420;
    public static int xPos = 220;

    public static int xPosRight = 520;

    public static int yPos = 340;
    public static int ySpace = 85;

    public static int yBottomStrings = yPos+ySpace*(-1)+490;
    public static int xBottomStrings = xPos-100;
    public static int xBottomStrings2 = xBottomStrings + 155;
    public static int xBottomStrings3 = xBottomStrings2 + 325;

    public void paint(Graphics g){

        g.setColor(Color.WHITE);

        g.setFont(new Font("Aharoni", Font.PLAIN, 50));
        g.drawString("HELP", xPosHELP-30, yPos-10);

        g.setFont(new Font("Aharoni", Font.PLAIN, 30));
        g.drawString("M - MENU", xPos, yPos+ySpace*1);
        g.setFont(new Font("Aharoni", Font.PLAIN, 30));
        g.drawString("H - HELP", xPos, yPos+ySpace*2);
        g.setFont(new Font("Aharoni", Font.PLAIN, 30));
        g.drawString("T - TOP", xPos, yPos+ySpace*3);

        g.setFont(new Font("Aharoni", Font.PLAIN, 20));
        g.drawString("ESC - PAUSE", xPos-180, yPos+ySpace*(-1));

        g.setFont(new Font("Aharoni", Font.PLAIN, 30));
        g.drawString("P - PLAY", xPosRight, yPos+ySpace*1);
        g.setFont(new Font("Aharoni", Font.PLAIN, 30));
        g.drawString("R - RESTART", xPosRight, yPos+ySpace*2);
        g.setFont(new Font("Aharoni", Font.PLAIN, 30));
        g.drawString("E - EXIT", xPosRight, yPos+ySpace*3);
        g.setFont(new Font("Aharoni", Font.PLAIN, 30));

        g.setFont(new Font("Aharoni", Font.PLAIN, 35));
        g.drawString("ARROW KEYS - DIRECT THE SNAKE", xPos-45, yPos+ySpace*4);

        //bottom

        g.setColor(Color.GREEN);

        g.setFont(new Font("Aharoni", Font.PLAIN, 25));
        g.drawString("EAT APPLES", xBottomStrings, yBottomStrings);

        g.setColor(Color.GRAY);

        g.setFont(new Font("Aharoni", Font.PLAIN, 25));
        g.drawString("GO THROUGH THE WALLS", xBottomStrings2, yBottomStrings);

        g.setColor(Color.RED);

        g.setFont(new Font("Aharoni", Font.PLAIN, 25));
        g.drawString("AVOID SKULLS", xBottomStrings3, yBottomStrings);

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

