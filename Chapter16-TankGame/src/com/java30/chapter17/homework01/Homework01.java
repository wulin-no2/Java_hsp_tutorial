package com.java30.chapter17.homework01;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Scanner;

import static java.lang.Thread.enumerate;
import static java.lang.Thread.sleep;

public class Homework01{
    public static void main(String[] args) throws InterruptedException {
        T1 t1 = new T1();
        T2 t2 = new T2(t1);
        t1.start();
        t2.start();

    }
}

class T1 extends Thread {
    private boolean loop = true;
    @Override
    public void run() {
        while (loop) {
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + Math.round(Math.random()*100) + "\t" + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
    public boolean isLoop() {
        return loop;
    }
    public void setLoop(boolean loop) {
        this.loop = loop;
    }
}
class T2 extends Thread{
    Scanner scanner = new Scanner(System.in);
    private T1 t1;
    public T2(T1 t1) {
        this.t1 = t1;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("enter your key(Q):");
            char key = scanner.next().toUpperCase().charAt(0);
            if(key == 'Q'){
                t1.setLoop(false);
                System.out.println("you entered Q.");
                break;
            }
        }
    }
}

