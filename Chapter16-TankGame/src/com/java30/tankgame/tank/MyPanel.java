package com.java30.tankgame.tank;

import javax.swing.*;
import java.awt.*;

public class MyPanel extends JPanel {
    LinaTank lina = null;
    Tank bad0 = null;

    public MyPanel() {
        lina = new LinaTank(100,100);
        bad0 = new Tank(300,300);

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0,0,1000,750);
        //draw a tank(drawTank method is defined separately:
        drawTank(lina.getX(),lina.getY(),g,0,0);
        drawTank(bad0.getX(),bad0.getY(),g,0,1);
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
                g.setColor(Color.cyan);
                break;
            case 1://badTank
                g.setColor(Color.yellow);
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


            default:
                System.out.println("need to be defined..");

        }


    }
}
