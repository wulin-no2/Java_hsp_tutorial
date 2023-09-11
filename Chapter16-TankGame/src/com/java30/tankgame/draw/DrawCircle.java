package com.java30.tankgame.draw;

import javax.swing.*;
import java.awt.*;

/**
*@author Lina Wu
*@version 1.0
 */
@SuppressWarnings({"all"})
public class DrawCircle extends JFrame{
    //define a panel:
    private MyPanel mp = null;
    public static void main(String[] args) {
        new DrawCircle();
    }

    public DrawCircle(){  //constructor:
        //initialize a panel:
        mp = new MyPanel();
        //put panel into the frame:
        this.add(mp);
        //set window size:
        this.setSize(400,300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);//can be displayed.
    }
}

//create a panel extends JPanel:
//MyPanel is a drawing board. Graphics g is a painting brush.
//Graphics has many painting methods.
class MyPanel extends JPanel{

    @Override
    public void paint(Graphics g) {//paint method.
        super.paint(g);//must be reserved.
        g.drawOval(10,10,100,100);
        //show how to use paint to draw:
        g.drawLine(0,0,400,400);
        g.drawRect(10,10,100,50);
        g.setColor(Color.blue);//set painting's color.
        g.fillRect(50,50,100,50);

        //get a image:
        Image image = Toolkit.getDefaultToolkit().getImage(MyPanel.class.getResource("/bg.png"));
        g.drawImage(image,60,60,175,221,this);

        g.setColor(Color.gray);
        g.setFont(new Font("Dialog",Font.ITALIC,20));
        g.drawString("Hello World.",200,200);
    }
}
