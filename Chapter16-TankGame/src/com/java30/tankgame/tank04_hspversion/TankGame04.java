package com.java30.tankgame.tank04_hspversion;

import javax.swing.*;

public class TankGame04 extends JFrame {
    //define a panel:
    MyPanel mp = null;

    //creat a TankGame in the main method:
    public static void main(String[] args) {
        new TankGame04();
    }
    public TankGame04() {//it's a constructor of the TankGame.
        //initialize new panel in the constructor.
        mp = new MyPanel();
        //make the mp a thread in order to repaint every 100ms:
        Thread thread = new Thread(mp);
        thread.start();
        //add the panel to the frame:
        this.add(mp);
        //set the frame size:
        this.setSize(1000,750);
        //make the frame listen to keyboard that the panel have implemented:
        this.addKeyListener(mp);
        //make the frame close once the exit button is clicked:
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //make the frame visible:
        this.setVisible(true);
    }
}
