package com.kinga;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Mouse implements MouseListener {

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

        int mouseX = e.getX();
        int mouseY = e.getY();

        if (Game.State == Game.STATE.MENU) {

            //public Rectangle playButton = new Rectangle(xPos-xButton, yPos+ySpace*1-yButton, widthButton, heightButton);
            if ((mouseX >= Menu.xPos - Menu.xButton) && (mouseX <= Menu.xPos - Menu.xButton + Menu.widthButton)) {
                if ((mouseY >= Menu.yPos + Menu.ySpace * 1 - Menu.yButton) && (mouseY <= Menu.yPos + Menu.ySpace * 1 - Menu.yButton + Menu.heightButton)) {
                    //pressed button
                    Game.State = Game.STATE.GAME;

                }
            }

            //public Rectangle helpButton = new Rectangle(xPos-xButton, yPos+ySpace*2-yButton, widthButton, heightButton);
            if ((mouseX >= Menu.xPos - Menu.xButton) && (mouseX <= Menu.xPos - Menu.xButton + Menu.widthButton)) {
                if ((mouseY >= Menu.yPos + Menu.ySpace * 2 - Menu.yButton) && (mouseY <= Menu.yPos + Menu.ySpace * 2 - Menu.yButton + Menu.heightButton)) {
                    //pressed button
                    Game.State = Game.STATE.HELP;

                }
            }
            //public Rectangle topButton = new Rectangle(xPos-xButton, yPos+ySpace*3-yButton, widthButton, heightButton);
            if ((mouseX >= Menu.xPos - Menu.xButton) && (mouseX <= Menu.xPos - Menu.xButton + Menu.widthButton)) {
                if ((mouseY >= Menu.yPos + Menu.ySpace * 3 - Menu.yButton) && (mouseY <= Menu.yPos + Menu.ySpace * 3 - Menu.yButton + Menu.heightButton)) {
                    //pressed button
                    Game.State = Game.STATE.TOP;
                }
            }

            //public Rectangle exitButton = new Rectangle(xPos-xButton, yPos+ySpace*4-yButton, widthButton, heightButton);
            if ((mouseX >= Menu.xPos - Menu.xButton) && (mouseX <= Menu.xPos - Menu.xButton + Menu.widthButton)) {
                if ((mouseY >= Menu.yPos + Menu.ySpace * 4 - Menu.yButton) && (mouseY <= Menu.yPos + Menu.ySpace * 4 - Menu.yButton + Menu.heightButton)) {
                    //pressed button
                    System.exit(1);
                }
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
