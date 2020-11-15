package brickBracker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class GamePlay extends JPanel  implements KeyListener, ActionListener {
    private boolean play = false;
    private int score = 0;
    private Random rand = new Random();
    private int totalBricks = 21;
    private Timer timer;
    private int delay;

    private int playerX = 310;
    private int ballPositionX = rand.nextInt(690);
    private int ballPositionY = 350;
    private int ballXdir = -1;
    private int ballYdir = -2;

    private MapGenerator map;

    public GamePlay(int delay){
        map = new MapGenerator(3,7);
        this.delay = delay;
        addKeyListener(this);
        setFocusable(true );
        setFocusTraversalKeysEnabled(false);
        timer = new Timer(delay, this);
        timer.start();


    }




    public void paint(Graphics g){
        // Back ground
        g.setColor(Color.black);
        g.fillRect(1,1,692,592);

        //draw map
        map.draw((Graphics2D)g);

        //border
        g.setColor(Color.yellow);
        g.fillRect(0,0,3,592);
        g.fillRect(0,0,692,2);
        g.fillRect(691,0,3,592);

        //scores
        g.setColor(Color.white);
        g.setFont(new Font("serif", Font.BOLD, 25));
        g.drawString("" + score,590,30);

        //The Paddle
        g.setColor(Color.green);
        g.fillRect(playerX, 550,100,8);

        //the ball
        g.setColor(Color.yellow);
        g.fillOval(ballPositionX, ballPositionY,20,20);

        if(totalBricks <= 0){
            play = false;
            ballXdir = 0;
            ballYdir = 0;
            g.setColor(Color.red);
            g.setFont(new Font("serif", Font.BOLD, 30));
            g.drawString("YOU WON!!!, Scores: " + score, 190,300);

            g.setFont(new Font("serif", Font.BOLD, 30));
            g.drawString("Press Enter to Restart: " , 230,350);

        }

        if (ballPositionY > 570){
            play = false;
            ballXdir = 0;
            ballYdir = 0;
            g.setColor(Color.red);
            g.setFont(new Font("serif", Font.BOLD, 30));
            g.drawString("Game Over, Scores: " + score, 190,300);

            g.setFont(new Font("serif", Font.BOLD, 30));
            g.drawString("Press Enter to Restart: " + score, 230,350);
        }

        g.dispose();


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        timer.start();

        if(play) {
            if(new Rectangle(ballPositionX,ballPositionY,20,20).intersects(new Rectangle(playerX,550,100,8))){
                ballYdir = -ballYdir;

            }
            A:for(int i = 0; i < map.map.length; i ++){
                for(int j = 0; j < map.map[0].length; j ++){
                    if(map.map[i][j] > 0){
                        int brickX = j * map.brickWidth + 80;
                        int brickY = i * map.brickHeight + 50;
                        int brickWidth = map.brickWidth;
                        int brickHeigth = map.brickHeight;

                        Rectangle rect = new Rectangle(brickX,brickY,brickWidth,brickHeigth);
                        Rectangle ballRect = new Rectangle(ballPositionX,ballPositionY,20,20);
                        Rectangle brickRect = rect;

                        if(ballRect.intersects(brickRect)){
                            map.setBrickValue(0,i,j);
                            totalBricks --;
                            score += 5;

                            if(ballPositionX + 19 <= brickRect.x || ballPositionX + 1 >= brickRect.x + brickRect.width){
                                ballXdir = - ballXdir;
                            }else{
                                ballYdir = -ballYdir;
                            }
                            break A;
                        }

                    }

                }
            }

            ballPositionX += ballXdir;
            ballPositionY += ballYdir;
            if (ballPositionX < 0) {
                ballXdir = -ballXdir;
            }
            if (ballPositionY < 0) {
                ballYdir = -ballYdir;
            }
            if (ballPositionX > 670) {
                ballXdir = -ballXdir;
            }
        }
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {}
    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            if(playerX >= 600){
                playerX = 600;
            }else{
                moveRight();
            }

        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            if(playerX <= 10){
                playerX = 10;
            }else{
                moveLeft();
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_ENTER){
            if(!play){
                play = true;
                ballPositionX = rand.nextInt(690);
                ballPositionY = 350;
                ballXdir = -1;
                ballYdir = -2;
                playerX = 310;
                score = 0;
                totalBricks = 21;
                map = new MapGenerator(3,7);

                repaint();

            }
        }
    }
    public void moveRight(){
        play = true;
        playerX += 20;
    }
    public void moveLeft(){
        play = true;
        playerX -= 20;
    }




}
