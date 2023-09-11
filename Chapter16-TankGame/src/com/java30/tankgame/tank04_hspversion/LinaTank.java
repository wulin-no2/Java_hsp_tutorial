package com.java30.tankgame.tank04_hspversion;

public class LinaTank extends Tank {
    //linaTank has a bullet:
    //define a bullet:
    Shot shot = null;
    public LinaTank(int x, int y, int direct) {
        super(x, y, direct);
    }
    //define a method to shot：
    public void shotBadTank(){
        //the bullet should have different directions once shotting:
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
        //the bullet should be a thread.
        // Once shot method is used the bullet thread begins:
        Thread thread = new Thread(shot);
        thread.start();
    }

}
