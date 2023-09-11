package com.java30.tankgame.tank04;

import java.util.Vector;

public class LinaTank extends Tank {
    Shot shot = null;//define a bullet.
    private boolean isLive = true;
    public boolean isLive() {
        return isLive;
    }

    public void setLive(boolean live) {
        isLive = live;
    }

    Vector<Shot> linaShots = new Vector<>();
    public LinaTank(int x, int y, int direct) {
        super(x, y, direct);
    }

    public void shotBadTank(){
        //control the number of bullets:
        if (linaShots.size() == 5) {
            return;
        }
            switch (getDirect()) {
                case 0:
                    shot = new Shot(getX() + 20, getY(), 0);
                    break;
                case 1:
                    shot = new Shot(getX() + 60, getY() + 20, 1);
                    break;
                case 2:
                    shot = new Shot(getX() + 20, getY() + 60, 2);
                    break;
                case 3:
                    shot = new Shot(getX(), getY() + 20, 3);
                    break;
            }
            //set the new shot into vector:
            linaShots.add(shot);

        //launch the bullet:
        Thread thread = new Thread(shot);
        thread.start();
        //for (int i = 0; i < linaShots.size(); i++) {
            //Thread thread = new Thread(linaShots.get(i));
//            thread.start();
//        }

    }

}
