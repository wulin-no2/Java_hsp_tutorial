package com.java30.tankgame.tank04;

/**
 * @author wulin
 * @version 0.1
 */

public class Tank {
    private int x;
    private int y;
    private int direct;
    public void moveup(){
        if (y >= 10){y = y - 10;}
    }
    public void movedown(){
        if (y <= 650){y = y + 10;}
    }
    public void moveleft(){
        if (x >= 10){x = x - 10;}
    }
    public void moveright(){
        if (x <= 930){x = x + 10;}
    }

    public Tank(int x, int y, int direct) {
        this.x = x;
        this.y = y;
        this.direct = direct;
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
}
