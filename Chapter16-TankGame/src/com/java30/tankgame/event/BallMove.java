package com.java30.tankgame.event;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class BallMove extends JFrame{
    private MyPanel mp = null;
    public static void main(String[] args) {
        new BallMove();
    }

    public BallMove() {
        mp = new MyPanel();
        this.add(mp);
        this.setSize(300,400);
        //let the frame listen to keyboard:
        this.addKeyListener(mp);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}

class MyPanel extends JPanel implements KeyListener {
    int x = 10;
    int y = 10;
    @Override
    public void paint(Graphics g) {

        super.paint(g);
        g.fillRect(0,0,300,400);
        g.setColor(Color.yellow);
        g.fillOval(x,y,20,20);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        //set the direction key run:
        if((char)e.getKeyCode() == KeyEvent.VK_DOWN){
            y ++;
        } else if ((char)e.getKeyCode() == KeyEvent.VK_UP) {
            y --;
        } else if ((char)e.getKeyCode() == KeyEvent.VK_LEFT) {
            x --;
        } else if ((char)e.getKeyCode() == KeyEvent.VK_RIGHT) {
            x ++;
        }
        //panel needs to be repainted.
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}