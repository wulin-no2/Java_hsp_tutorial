package com.java30.tankgame.tank05_io;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

public class MyPanel extends JPanel implements KeyListener,Runnable {
    LinaTank lina = null;
    //create a vector to collect badtanks:
    Vector<BadTank> badTanks =new Vector<>();
    int badTanksSize = 3;
    //Create a vetor to collect bomb,if hit a tank,then initialize a bomb:
    Vector<Bomb> bombs = new Vector<>();
    //define 3 images to present bombs:
    Image image1 = null;
    Image image2 = null;
    Image image3 = null;


    public MyPanel() {
        //initialize linaTank:
        lina = new LinaTank(400,200,1);
        //System.out.println("lina tank is initialized..");
        for (int i = 0; i < badTanksSize; i++) {
            //initialize badTank:
            BadTank badTank = new BadTank((i + 1) * 100, 0, 2);
            Thread thread = new Thread(badTank);
            thread.start();
            //System.out.println("a badTank is initialized..");
            badTanks.add(badTank);
        }
        //initialize bombs:
        image1 = Toolkit.getDefaultToolkit().getImage(MyPanel.class.getResource("/bomb_1.gif"));
        image2 = Toolkit.getDefaultToolkit().getImage(MyPanel.class.getResource("/bomb_2.gif"));
        image3 = Toolkit.getDefaultToolkit().getImage(MyPanel.class.getResource("/bomb_3.gif"));
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0,0,1000,750);
        //draw a lina tank(drawTank method is defined separately:
        if (lina != null && lina.isLive()) {
            drawTank(lina.getX(), lina.getY(), g, lina.getDirect(), 0);
        }

        //draw a lina bullet:
        for (int i = 0; i < lina.linaShots.size(); i++) {
            if(lina.linaShots.get(i) != null && lina.linaShots.get(i).isLive()){
                g.setColor(Color.yellow);
                g.draw3DRect(lina.linaShots.get(i).getX(),lina.linaShots.get(i).getY(),2,2, false);
            }else {
                lina.linaShots.remove(lina.linaShots.get(i));
            }
        }

        //draw some badTank bullet:
        //System.out.println("ready to draw a badTank..");
        for (int i = 0; i < badTanks.size(); i++) {
            if (badTanks.get(i).isLive() == true) {
                drawTank(badTanks.get(i).getX(), badTanks.get(i).getY(), g, badTanks.get(i).getDirect(), 1);
            }
            //System.out.println("draw a badTank..");
            for (int j = 0; j < badTanks.get(i).shots.size(); j++) {
                if (badTanks.get(i).shots.get(j) != null && badTanks.get(i).shots.get(j).isLive()==true){
                    g.setColor(Color.cyan);
                    g.draw3DRect(badTanks.get(i).shots.get(j).getX(),badTanks.get(i).shots.get(j).getY(),2,2,false);
                    //System.out.println("bad tank's bullet is painted..");
                }else{
                    badTanks.get(i).shots.remove(badTanks.get(i).shots.get(j));
                }
            }
        }
        //draw the bombs:
        for (int i = 0; i < bombs.size(); i++) {
            //take out the bomb:
            Bomb bomb = bombs.get(i);
            //draw the bomb according to its life value:
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (bomb.getLife() > 6){
                g.drawImage(image1,bomb.getX(),bomb.getY(),60,60,this);
            } else if (bomb.getLife() > 3) {
                g.drawImage(image2,bomb.getX(),bomb.getY(),60,60,this);
            }else {
                g.drawImage(image3,bomb.getX(),bomb.getY(),60,60,this);
            }
            bomb.lifeDomn();
            //if the bomb's life is 0, remove it from the vector;
            if (bomb.getLife() == 0){
                bombs.remove(bomb);
            }
        }
    }
    //write a method to check if badTank hit linaTank:
    public void hitLinaTank(){
        for (int i = 0; i < badTanks.size(); i++) {
            BadTank badTank = badTanks.get(i);
            for (int j = 0; j < badTank.shots.size(); j++) {
                Shot shot = badTank.shots.get(j);
                switch (lina.getDirect()){
                    case 0:
                    case 2:
                        if (shot.getX() >= lina.getX() && shot.getX() <= lina.getX() + 40
                                && shot.getY() >= lina.getY() && shot.getY() <= lina.getY() + 60){
                            shot.setLive(false);
                            lina.setLive(false);
                            //badTanks.remove(badTank);
                            //initialize a new bomb when hit a tank:
                            bombs.add(new Bomb(lina.getX(), lina.getY()));
                        }
                        break;
                    case 1:
                    case 3:
                        if (shot.getX() >= lina.getX() && shot.getX() <= lina.getX() + 60
                                && shot.getY() >= lina.getY() && shot.getY() <= lina.getY() + 40){
                            shot.setLive(false);
                            lina.setLive(false);
                            //badTanks.remove(badTank);
                            Bomb bomb = new Bomb(lina.getX(), lina.getY());
                        }
                        break;
                }
            }
        }
    }

    //write a new method to check if linaTank hits badTank cause linaTank can shoot a lot now:
    public void hitBadTank1(){
        for (int i = 0; i < lina.linaShots.size(); i++) {
            Shot s = lina.linaShots.get(i);
            for (int j = 0; j < badTanks.size(); j++) {
                BadTank badTank = badTanks.get(j);
                switch (badTank.getDirect()){
                    case 0:
                    case 2:
                        if (s.getX() >= badTank.getX() && s.getX() <= badTank.getX() + 40
                                && s.getY() >= badTank.getY() && s.getY() <= badTank.getY() + 60){
                            s.setLive(false);
                            badTank.setLive(false);
                            badTanks.remove(badTank);
                            //initialize a new bomb when hit a tank:
                            bombs.add(new Bomb(badTank.getX(), badTank.getY()));
                        }
                        break;
                    case 1:
                    case 3:
                        if (s.getX() >= badTank.getX() && s.getX() <= badTank.getX() + 60
                                && s.getY() >= badTank.getY() && s.getY() <= badTank.getY() + 40){
                            s.setLive(false);
                            badTank.setLive(false);
                            badTanks.remove(badTank);
                            Bomb bomb = new Bomb(s.getX(), s.getY());
                        }
                        break;
                }
            }
        }
    }
    //check if linaTank hits badTank:
    public void hitBadTank(Shot s, BadTank badTank){
        switch (badTank.getDirect()){
            case 0:
            case 2:
                if (s.getX() >= badTank.getX() && s.getX() <= badTank.getX() + 40
                        && s.getY() >= badTank.getY() && s.getY() <= badTank.getY() + 60){
                    s.setLive(false);
                    badTank.setLive(false);
                    badTanks.remove(badTank);
                    //initialize a new bomb when hit a tank:
                    bombs.add(new Bomb(badTank.getX(), badTank.getY()));
                }
                break;
            case 1:
            case 3:
                if (s.getX() >= badTank.getX() && s.getX() <= badTank.getX() + 60
                        && s.getY() >= badTank.getY() && s.getY() <= badTank.getY() + 40){
                    s.setLive(false);
                    badTank.setLive(false);
                    badTanks.remove(badTank);
                    Bomb bomb = new Bomb(s.getX(), s.getY());
                }
                break;
        }
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
            //if (lina.shot == null || ! lina.shot.isLive()) {//this condition can only be shot once.
                lina.shotBadTank();
            //}
        }


    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void run() {
        while (true){
            //check if lina's shot hit bad tank:

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            hitBadTank1();
            hitLinaTank();
            //the second time there are several shots in linaTank:
//            for (int i = 0; i < lina.linaShots.size(); i++) {
//                if (lina.linaShots.get(i)!=null && lina.linaShots.get(i).isLive()){
//                    for (int j = 0; j < badTanks.size(); j++) {
//                        hitBadTank1(lina.linaShots.get(i),badTanks.get(j));
//                    }
//                }
//            }
            //the first there is only one shot in linaTank:
//            if (lina.shot != null && lina.shot.isLive() ){
//                for (int i = 0; i < badTanks.size(); i++) {
//                    hitBadTank(lina.shot,badTanks.get(i));
//                }
//            }
            repaint();
        }
    }
}
