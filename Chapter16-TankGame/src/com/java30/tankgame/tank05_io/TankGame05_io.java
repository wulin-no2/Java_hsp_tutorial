package com.java30.tankgame.tank05_io;

import javax.swing.*;

public class TankGame05_io extends JFrame {
    //
    MyPanel mp = null;
    public static void main(String[] args) {
        new TankGame05_io();
    }
    public TankGame05_io() {
        mp = new MyPanel();
        Thread thread = new Thread(mp);
        thread.start();
        this.add(mp);
        this.setSize(1000,750);
        this.addKeyListener(mp);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}