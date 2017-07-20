package com.example.user.bataille_clinet;

import android.util.Log;

import java.util.Random;

/**
 * Created by eric on 2017/7/19.
 */

public class Bateau {
    private int position; //
    private boolean canshoot; //用来轮流射击，先a 后b
    private Random random;
    private int shootpositon;
    private  boolean isalive;

    public boolean isalive() {
        return isalive;
    }

    public int getShootpositon() {
        return shootpositon;
    }
    private final String filtre = "socketRuna";
    public int getPosition() {

        return position;
    }



    public boolean isCanshoot() {
        return canshoot;
    }

    public void setCanshoot(boolean canshoot) {
        this.canshoot = canshoot;
    }

    public Bateau() {
        random = new Random();
        position = random.nextInt(99);
        canshoot =false;
        isalive =true;
        Log.i(filtre, "my position is " + String.valueOf(position));
    }
    public void shoot(int shootpositon) {
        this.shootpositon = shootpositon;
        canshoot =false;
    }
    public void  destroy()
    {
        this.isalive =false;
    }
}
