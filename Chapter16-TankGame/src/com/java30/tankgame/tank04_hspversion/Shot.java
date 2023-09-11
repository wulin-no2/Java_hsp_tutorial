package com.java30.tankgame.tank04_hspversion;

import static java.lang.Thread.sleep;

//the shot should have starting position, direction,speed, and is alive.
//the shot must be a thread which can start and end in some time:
public class Shot implements Runnable{
    private int x;//bullet's x;
    private int y;//bullet's y;
    private int direct = 0;//bullet's direction;
    private int speed = 10;//bullet's speed;
    private boolean isLive = true;//if bullet's alive;

    public Shot(int x, int y, int direct) {
        this.x = x;
        this.y = y;
        this.direct = direct;
    }
    //should make a run method to shot the bullet and let loop and sleep method working to generate bullets.
    @Override
    public void run() {//bullet shots.
        while (true) {
            try {
                sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            //the bullet's position will change according to the direction and speed.
            switch (direct){
                case 0:
                    y = y - speed;
                    break;
                case 1:
                    x = x + speed;
                    break;
                case 2:
                    y = y + speed;
                    break;
                case 3:
                    x = x - speed;
                    break;
            }
            //give the bullet a method to disapear:
            if(!(x >= 0 && x <= 1000 && y >= 0 && y <= 750)){
                isLive = false;
                break;
            }

        }

    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getDirect() {
        return direct;
    }

    public void setDirect(int direct) {
        this.direct = direct;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isLive() {
        return isLive;
    }

    public void setLive(boolean live) {
        isLive = live;
    }
}
