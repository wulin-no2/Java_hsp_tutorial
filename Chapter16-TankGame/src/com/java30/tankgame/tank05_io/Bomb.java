package com.java30.tankgame.tank05_io;

public class Bomb {
    private int x;
    private int y;
    private boolean isLive = true;
    private int life = 9;

    public Bomb(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public void lifeDomn(){
        if (life > 0){
            life --;
        }else {
            setLive(false);
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

    public boolean isLive() {
        return isLive;
    }

    public void setLive(boolean live) {
        isLive = live;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }
}
