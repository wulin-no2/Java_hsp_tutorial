package com.java30.tankgame.tank03;

public class LinaTank extends Tank {
    Shot shot = null;//define a bullet.
    public LinaTank(int x, int y, int direct) {
        super(x, y, direct);
    }

    public void shotBadTank(){
        switch (getDirect()){
            case 0:
                shot = new Shot(getX() + 20,getY(),0);
                break;
            case 1:
                shot = new Shot(getX() + 60,getY() + 20 ,1);
                break;
            case 2:
                shot = new Shot(getX() + 20,getY() + 60 ,2);
                break;
            case 3:
                shot = new Shot(getX(),getY() + 20 ,3);
                break;
        }
        //launch the bullet:
        Thread thread = new Thread(shot);
        thread.start();
    }

}
