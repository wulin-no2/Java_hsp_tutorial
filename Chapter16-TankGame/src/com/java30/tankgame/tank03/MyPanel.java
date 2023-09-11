package com.java30.tankgame.tank03;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

public class MyPanel extends JPanel implements KeyListener,Runnable {
    LinaTank lina = null;
    Vector<BadTank> badTank =new Vector();
    public MyPanel() {
        lina = new LinaTank(200,200,1);
        badTank.add(new BadTank(100,100,2));
        badTank.add(new BadTank(300,300,3));
        badTank.add(new BadTank(400,400,0));
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0,0,1000,750);
        //draw a lina tank(drawTank method is defined separately:
        drawTank(lina.getX(),lina.getY(),g,lina.getDirect(),0);

        //draw a bullet:
        if( lina.shot != null && lina.shot.isLive() == true){
            g.setColor(Color.yellow);
            g.draw3DRect(lina.shot.getX(),lina.shot.getY(),2,2, false);
        }
        drawTank(badTank.get(0).getX(),badTank.get(0).getY(),g,badTank.get(0).getDirect(),1);
        drawTank(badTank.get(1).getX(),badTank.get(1).getY(),g,badTank.get(1).getDirect(),1);
        drawTank(badTank.get(2).getX(),badTank.get(2).getY(),g,badTank.get(2).getDirect(),1);
    }

    /**
     *
     * @param x the horizontal ordinate of tank
     * @param y the vertical ordinate of tank
     * @param g the painting brush
     * @param direct the direction of tank
     * @param type the type of tank
     */
    public void drawTank(int x, int y, Graphics g, int direct, int type){
        switch (type){
            case 0://linaTank
                g.setColor(Color.yellow);
                break;
            case 1://badTank
                g.setColor(Color.cyan);
                break;
        }
        switch (direct){
            case 0://up direction
                g.fill3DRect(x,y,10,60,false);
                g.fill3DRect(x + 10,y + 10,20,40,false);
                g.fill3DRect(x + 30,y,10,60,false);
                g.fillOval(x + 10, y + 20, 20,20);
                g.drawLine(x + 20,y + 30,x + 20,y);
                break;
            case 1://right direction
                g.fill3DRect(x,y,60,10,false);
                g.fill3DRect(x + 10,y + 10,40,20,false);
                g.fill3DRect(x,y + 30,60,10,false);
                g.fillOval(x + 20, y + 10, 20,20);
                g.drawLine(x + 30,y + 20,x + 60,y + 20);
                break;
            case 2://down direction
                g.fill3DRect(x,y,10,60,false);
                g.fill3DRect(x + 10,y + 10,20,40,false);
                g.fill3DRect(x + 30,y,10,60,false);
                g.fillOval(x + 10, y + 20, 20,20);
                g.drawLine(x + 20,y + 30,x + 20,y + 60);
                break;
            case 3://left direction
                g.fill3DRect(x,y,60,10,false);
                g.fill3DRect(x + 10,y + 10,40,20,false);
                g.fill3DRect(x,y + 30,60,10,false);
                g.fillOval(x + 20, y + 10, 20,20);
                g.drawLine(x + 30,y + 20,x,y + 20);
                break;
//            default:
//                System.out.println("key need to be defined..");
//                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_W){
            lina.setDirect(0);
            lina.moveup();
            this.repaint();

        } else if (e.getKeyCode()==KeyEvent.VK_D) {
            lina.setDirect(1);
            lina.moveright();
            this.repaint();
            
        } else if (e.getKeyCode()==KeyEvent.VK_S) {
            lina.setDirect(2);
            lina.movedown();
            this.repaint();
            
        } else if (e.getKeyCode()==KeyEvent.VK_A) {
            lina.setDirect(3);
            lina.moveleft();
            this.repaint();
        }

        //if enter j, then shot:
        if (e.getKeyCode() == KeyEvent.VK_J){
            lina.shotBadTank();
            this.repaint();
        }


    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void run() {
        while (true){
            repaint();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
