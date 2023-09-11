package com.java30.tankgame.tank02;

import javax.swing.*;
import java.awt.*;

public class TankGame02 extends JFrame {
    //
    MyPanel mp = null;
    public static void main(String[] args) {
        new TankGame02();
    }
    public TankGame02() {
        mp = new MyPanel();
        this.add(mp);
        this.setSize(1000,750);
        this.addKeyListener(mp);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
