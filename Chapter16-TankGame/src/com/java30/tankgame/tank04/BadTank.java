package com.java30.tankgame.tank04;

import java.util.Vector;
//bad tank should be a thread then they can move around:
public class BadTank extends Tank implements Runnable{
    private boolean isLive = true;

    public boolean isLive() {
        return isLive;
    }

    public void setLive(boolean live) {
        isLive = live;
    }

    Vector<Shot> shots = new Vector<>();
    public BadTank(int x, int y, int direct) {
        super(x, y, direct);
        shotBullet();
    }
    public void shotBullet(){
        switch (getDirect()){
            case 0:
                shots.add(new Shot(getX() + 20,getY(),0));
                break;
            case 1:
                shots.add(new Shot(getX() + 60,getY() + 20 ,1));
                break;
            case 2:
                shots.add(new Shot(getX() + 20,getY() + 60 ,2));
                break;
            case 3:
                shots.add(new Shot(getX(),getY() + 20 ,3));
                break;
        }
        System.out.println("badtank's bullet is initialized.." + shots.size());
        //launch the bullet:
        for (int i = 0; i < shots.size(); i++) {
            Thread thread = new Thread(shots.get(i));
            System.out.println("bad tank's shot thread is newed..");
            thread.start();
        }
    }

    @Override
    public void run() {
        while (true){
            if (isLive && shots.size() == 0){
                System.out.println("bad tank shoot another bullet..");
                shotBullet();
            }
            //move according to its direction:
            switch (getDirect()){
                case 0:
                    //tank must move to one direction for a while then change direction:
                    //after each move, we set tank sleep for a while:
                    for (int i = 0; i < 30; i++) {
                        moveup();
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    //there must be a break or the tank will be crazy!!!
                    break;

                case 1:
                    for (int i = 0; i < 30; i++) {
                        moveright();
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;

                case 2:
                    for (int i = 0; i < 30; i++) {
                        movedown();
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;

                case 3:
                    for (int i = 0; i < 30; i++) {
                        moveleft();
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;
            }
            //change direction randomly:
            setDirect((int)(Math.random() * 4));
            //we must consider how to exit a thread. it's important!!!
            if (! isLive) {
                break;
            }
        }
    }
}
