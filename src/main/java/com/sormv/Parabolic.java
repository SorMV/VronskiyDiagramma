package com.sormv;


public class Parabolic {

    public Parabolic() {

    }

    public int createYValues(int x, int l,int xdot, int ydot) {
        if(ydot!=l) {
            return (int) (Math.pow(x - xdot, 2) + Math.pow(ydot, 2) - l) / (2 * (ydot - l));
        }
        else return 0;
    }


}
