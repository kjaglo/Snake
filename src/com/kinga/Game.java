package com.kinga;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class Game extends JPanel implements KeyListener, ActionListener {

    public static enum STATE{
        MENU,
        GAME,
        HELP,
        TOP
    };

    public static STATE State = STATE.MENU;

    private Menu menu = new Menu();
    private Help help = new Help();
    private Top top = new Top();

    private ImageIcon titleImg;

    private int snakeLength = 3;

    private int[] snakeXLength = new int[750];
    private int[] snakeYLength = new int[750];

    static int maxListPlace = 3;
    public static String[] nicks = new String[maxListPlace];
    public static int[] scores = new int[maxListPlace];
    public static String[] nicksNew = new String[maxListPlace];
    public static int playerID = 1;

    public static boolean gameOver = false;
    public static boolean pause = false;
    public static boolean start = true;

    private int presentDirection;

    private boolean left = false;
    private boolean right = false;
    private boolean down = false;
    private boolean up = false;

    private ImageIcon startSnake;
    private ImageIcon sleepSnake;
    private ImageIcon leftSnake;
    private ImageIcon rightSnake;
    private ImageIcon downSnake;
    private ImageIcon upSnake;

    private Timer timer;
    private int delay = 100;

    private ImageIcon bodySnake;

    private int moves = 0; //just started

    //apples

    private ImageIcon apple;

    private int[] appleXArray = {25,50,75,100,125,150,175,200,
                            225,250,275,300,325,350,375,400,
                            425,450,475,500,525,550,575,600,
                            625,650,675,700,725,750,775,800,
                            825,850};
    private int[] appleYArray = {225,250,275,300,325,350,375,400,
                            425,450,475,500,525,550,575,600,
                            625,650,675,700,725,750,775};

    private Random random = new Random();

    private int appleX = random.nextInt(appleXArray.length); // 34 positions
    private int appleY = random.nextInt(appleYArray.length); // 23 positions

    //skulls

    private ImageIcon skull;

    private int[] skullXArray = {25,50,75,100,125,150,175,200,
            225,250,275,300,325,350,375,400,
            425,450,475,500,525,550,575,600,
            625,650,675,700,725,750,775,800,
            825,850};
    private int[] skullYArray = {225,250,275,300,325,350,375,400,
            425,450,475,500,525,550,575,600,
            625,650,675,700,725,750,775};

    private int skullX = random.nextInt(skullXArray.length); // 34 positions
    private int skullY = random.nextInt(skullYArray.length); // 23 positions

    private int score = 0;

    public void clearNicks(){
        for (int i = 0; i < maxListPlace; i++) {

            nicksNew[i]="...";
            nicks[i]="...";

        }
    }

    public Game(){

        clearNicks();
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        timer = new Timer(delay, this);
        timer.start();

    }

    public void restartGame(){
        moves = 0;
        score = 0;
        snakeLength = 3;
        right = false;
        down = false;
        up = false;
        left = false;
        gameOver = false;
        start = true;
        pause = false;
        repaint();
    }

    public void pauseGame(){

        pause = true;
        start = false;

        right = false;
        down = false;
        up = false;
        left = false;

        repaint();
    }

    public void inputName(String nick) {

        int place = maxListPlace;
        int rememberScore = 0;
        String rememberNick = "";
        int[] scoresNew = new int[maxListPlace];
        String[] nicksNew = new String[maxListPlace];

        for (int i = 0; i < maxListPlace; i++) {
            if (score >= scores[i]) {
                place = i;
                rememberScore = scores[i];
                rememberNick = nicks[i];
                scores[i] = score;
                nicks[i] = nick;
                break;
            }
        }

        if (place < maxListPlace) {

            for (int i = 0; i < place; i++) {
                scoresNew[i] = scores[i];
                nicksNew[i] = nicks[i];
            }
            scoresNew[place] = score;
            nicksNew[place] = nick;


            if (place + 1 < maxListPlace) {
                scoresNew[place + 1] = rememberScore;
                nicksNew[place + 1] = rememberNick;
            }
            for (int i = place + 2; i < maxListPlace; i++) {
                scoresNew[i] = scores[i - 1];
                nicksNew[i] = nicks[i - 1];
            }

            nicks = nicksNew;
            scores = scoresNew;

            /*for (int i = 0; i < maxListPlace; i++) {

                System.out.print(scores[i] + " ");

            }

            System.out.println("");

            for (int i = 0; i < maxListPlace; i++) {

                System.out.print(nicks[i] + " ");

            }
            System.out.println("");

            System.out.println("_________________");*/

        }
    }

    public void paint(Graphics g){

        if(State == STATE.MENU) {
            this.addMouseListener(new Mouse());
            repaint();
        }

        if(moves == 0){

            snakeXLength[0]=100;
            snakeXLength[1]=75;
            snakeXLength[2]=50;

            snakeYLength[0]=250;
            snakeYLength[1]=250;
            snakeYLength[2]=250;

        }
        //bcg
        g.setColor(Color.DARK_GRAY);
        g.fillRect(0,0,918,870);

        //title border
        g.setColor(Color.WHITE);
        g.drawRect(24,16,851,188);

        Color myBlue = new Color(80, 187, 230);

        g.setColor(myBlue);
        g.fillRect(25,17,850,187);

        //title image border
        g.setColor(Color.WHITE);
        g.drawRect(224,16,463,188);

        //title image
        titleImg = new ImageIcon("title.png");
        titleImg.paintIcon(this,g,225, 17);

        //game border
        g.setColor(Color.WHITE);
        g.drawRect(24,224,851,577);

        //bcg game
        g.setColor(Color.BLACK);
        g.fillRect(25,225,850,575);

        if(State == STATE.GAME) {

            //scores
            g.setColor(Color.WHITE);
            g.setFont(new Font("Aharoni", Font.PLAIN, 30));
            g.drawString("SCORE: " + score, 710, 100);

            //length
            g.setColor(Color.WHITE);
            g.setFont(new Font("Aharoni", Font.PLAIN, 30));
            g.drawString("LENGTH: " + snakeLength, 705, 150);

            //lvl
            g.setColor(Color.WHITE);
            g.setFont(new Font("Aharoni", Font.PLAIN, 30));
            g.drawString("LEVEL: " + (snakeLength / 10 + 1), 75, 120);

            if(!pause) {
                startSnake = new ImageIcon("start.png");
                startSnake.paintIcon(this, g, snakeXLength[0], snakeYLength[0]);
            } else {
                sleepSnake = new ImageIcon("sleep.png");
                sleepSnake.paintIcon(this, g, snakeXLength[0], snakeYLength[0]);
            }

            for (int i = 0; i < snakeLength; i++) {

                if (i == 0 && right) {
                    rightSnake = new ImageIcon("right.png");
                    rightSnake.paintIcon(this, g, snakeXLength[i], snakeYLength[i]);
                }
                if (i == 0 && left) {
                    leftSnake = new ImageIcon("left.png");
                    leftSnake.paintIcon(this, g, snakeXLength[i], snakeYLength[i]);
                }
                if (i == 0 && up) {
                    upSnake = new ImageIcon("up.png");
                    upSnake.paintIcon(this, g, snakeXLength[i], snakeYLength[i]);
                }
                if (i == 0 && down) {
                    downSnake = new ImageIcon("down.png");
                    downSnake.paintIcon(this, g, snakeXLength[i], snakeYLength[i]);
                }
                if (i != 0) {
                    bodySnake = new ImageIcon("body.png");
                    bodySnake.paintIcon(this, g, snakeXLength[i], snakeYLength[i]);

                }

            }


            //apples
            apple = new ImageIcon("apple.png");

            if ((appleXArray[appleX] == snakeXLength[0]) && (appleYArray[appleY] == snakeYLength[0])) {

                snakeLength++;

                appleX = random.nextInt(appleXArray.length);
                appleY = random.nextInt(appleYArray.length);

                int rand = random.nextInt(10);
                int bonus;

                if(snakeLength > 3) {
                    bonus = 10 * (snakeLength / 10) + 10 * (snakeLength - 3) + rand;
                } else {
                    bonus = 10 * (snakeLength / 10) + 10 * snakeLength + rand;
                }

                score += bonus;

            }

            apple.paintIcon(this, g, appleXArray[appleX], appleYArray[appleY]);

            //skulls
            skull = new ImageIcon("skull.png");

            if ((skullXArray[skullX] == snakeXLength[0]) && (skullYArray[skullY] == snakeYLength[0])) {

                snakeLength--;

                skullX = random.nextInt(skullXArray.length);
                skullY = random.nextInt(skullYArray.length);

                int penalty = 2 * 10 * (snakeLength / 10) + 10 * snakeLength + random.nextInt(10);
                if(score - penalty >= 0) {
                    score -= penalty;
                } else {
                    score = 0;
                }

            }

            skull.paintIcon(this, g, skullXArray[skullX], skullYArray[skullY]);

            if(gameOver==false) {
                if(snakeLength == 0) {

                    gameOver = true;

                    right = false;
                    down = false;
                    up = false;
                    left = false;

                    repaint();
                }

            }

            if(gameOver==false) {
                for (int i = 1; i < snakeLength; i++) {
                    if ((snakeXLength[i] == snakeXLength[0]) && (snakeYLength[i] == snakeYLength[0])) {
                        if (State == STATE.GAME) {

                            gameOver = true;

                            right = false;
                            down = false;
                            up = false;
                            left = false;

                            repaint();

                        }
                    }
                }
            }
            if (gameOver){

                g.setColor(Color.WHITE);
                g.setFont(new Font("Aharoni", Font.PLAIN, 70));
                g.drawString("GAME OVER", 270, 480);
                g.setFont(new Font("Aharoni", Font.PLAIN, 30));
                g.drawString("TOTAL SCORE: " + score, 360, 530);
                g.setFont(new Font("Aharoni", Font.PLAIN, 30));
                g.drawString("Press ENTER to continue", 300, 580);

            } else if (start) {

                g.setColor(Color.WHITE);
                g.setFont(new Font("Aharoni", Font.CENTER_BASELINE, 30));
                g.drawString("Press any ARROW KEY to start", 240, 515);

            }  else if(pause){

                g.setColor(Color.WHITE);

                g.setFont(new Font("Aharoni", Font.PLAIN, 70));
                g.drawString("PAUSE", 350, 510);
                g.setFont(new Font("Aharoni", Font.PLAIN, 30));
                g.drawString("Press TAB or any ARROW KEY to resume", 170, 570);

            }

        } else if (State == STATE.MENU){
            menu.paint(g);
        } else if (State == STATE.HELP) {
            help.paint(g);
        } else if (State == STATE.TOP) {
            top.paint(g);
        }

        g.dispose();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        //exit
        if (e.getKeyCode() == KeyEvent.VK_E) {
            System.exit(1);
        }

        //menu
        if (e.getKeyCode() == KeyEvent.VK_M) {

            State = STATE.MENU;
            if(!start) {
                pauseGame();
            } else {
                repaint();
            }
        }

        //help
        if (e.getKeyCode() == KeyEvent.VK_H) {

            State = STATE.HELP;
            if(!start) {
                pauseGame();
            } else {
                repaint();
            }
        }

        //top
        if (e.getKeyCode() == KeyEvent.VK_T) {

            State = STATE.TOP;
            if(!start) {
                pauseGame();
            } else {
                repaint();
            }
        }

            if (State == STATE.GAME) {
                if(gameOver == true) {
                    if (e.getKeyCode() == KeyEvent.VK_ENTER) {

                        String nick = JOptionPane.showInputDialog(null, "Enter your name:", "GAME OVER", 2);
                        if (nick == "") {
                            nick = "Player " + playerID;
                            playerID++;
                        } else if (nick == null) {
                            nick = "Player " + playerID;
                            playerID++;
                        } else if (nick.isEmpty()) {
                            nick = "Player " + playerID;
                            playerID++;
                        }

                        if (nick.length() > 10) {
                            nick = nick.substring(0, 9);
                        }

                        inputName(nick);
                        restartGame();
                        State = STATE.TOP;

                    }
                }
                if (e.getKeyCode() == KeyEvent.VK_R) {

                    restartGame();

                }

                if (gameOver == false) {

                    //pause
                    if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {

                        if (right == true) {
                            presentDirection = 1;
                        } else if (left == true) {
                            presentDirection = 2;
                        } else if (up == true) {
                            presentDirection = 3;
                        } else if (down == true) {
                            presentDirection = 4;
                        }

                        pauseGame();

                    }

                    //return
                    if(e.getKeyCode() == KeyEvent.VK_TAB) {

                        pause = false;

                        switch (presentDirection) {
                            case 1:
                                right = true;
                                break;
                            case 2:
                                left = true;
                                break;
                            case 3:
                                up = true;
                                break;
                            case 4:
                                down = true;
                                break;
                            default:
                                right = true;
                                break;

                        }
                    }
                    if (e.getKeyCode() == KeyEvent.VK_RIGHT) {

                        pause = false;
                        start = false;

                        if (!left) {
                            right = true;
                        } else {
                            left = true;
                            right = false;

                        }
                        moves++;
                        up = false;
                        down = false;
                    }
                    if (e.getKeyCode() == KeyEvent.VK_LEFT) {

                        pause = false;
                        start = false;

                        if (!right) {
                            left = true;
                        } else {
                            right = true;
                            left = false;

                        }
                        moves++;
                        up = false;
                        down = false;
                    }
                    if (e.getKeyCode() == KeyEvent.VK_UP) {

                        pause = false;
                        start = false;

                        if (!down) {
                            up = true;
                        } else {
                            down = true;
                            up = false;

                        }
                        moves++;
                        left = false;
                        right = false;
                    }
                    if (e.getKeyCode() == KeyEvent.VK_DOWN) {

                        pause = false;
                        start = false;

                        if (!up) {
                            down = true;
                        } else {
                            up = true;
                            down = false;
                        }
                        moves++;
                        right = false;
                        left = false;
                    }
                }
            } else {
                if(e.getKeyCode() == KeyEvent.VK_P)
                State = STATE.GAME;
                repaint();
            }
        }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (State == STATE.GAME) {

            timer.start();
            if (right) {

                for (int i = snakeLength - 1; i >= 0; i--) {
                    snakeYLength[i + 1] = snakeYLength[i];
                }
                for (int i = snakeLength; i >= 0; i--) {

                    if (i == 0) {
                        snakeXLength[i] = snakeXLength[i] + 25;
                    } else {
                        snakeXLength[i] = snakeXLength[i - 1];
                    }

                    if (snakeXLength[i] > 850) {
                        snakeXLength[i] = 25;
                    }

                }

                repaint();

            }
            if (left) {
                for (int i = snakeLength - 1; i >= 0; i--) {
                    snakeYLength[i + 1] = snakeYLength[i];
                }
                for (int i = snakeLength; i >= 0; i--) {

                    if (i == 0) {
                        snakeXLength[i] = snakeXLength[i] - 25;
                    } else {
                        snakeXLength[i] = snakeXLength[i - 1];
                    }

                    if (snakeXLength[i] < 25) {
                        snakeXLength[i] = 850;
                    }

                }

                repaint();

            }
            if (up) {
                for (int i = snakeLength - 1; i >= 0; i--) {
                    snakeXLength[i + 1] = snakeXLength[i];
                }
                for (int i = snakeLength; i >= 0; i--) {

                    if (i == 0) {
                        snakeYLength[i] = snakeYLength[i] - 25;
                    } else {
                        snakeYLength[i] = snakeYLength[i - 1];
                    }

                    if (snakeYLength[i] < 225) {
                        snakeYLength[i] = 775;
                    }

                }

                repaint();

            }
            if (down) {

                for (int i = snakeLength - 1; i >= 0; i--) {
                    snakeXLength[i + 1] = snakeXLength[i];
                }
                for (int i = snakeLength; i >= 0; i--) {

                    if (i == 0) {
                        snakeYLength[i] = snakeYLength[i] + 25;
                    } else {
                        snakeYLength[i] = snakeYLength[i - 1];
                    }

                    if (snakeYLength[i] > 775) {
                        snakeYLength[i] = 225;
                    }

                }

                repaint();

            }
        }
    }
}
