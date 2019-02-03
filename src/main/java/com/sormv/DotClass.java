package com.sormv;


import java.awt.geom.Point2D;

/**
 * The <code>DotClass</code> class defines a point representing a location
 * of dot in {@code (x,y)} coordinate space.
 * extends abstract class
 *
 * @see Point2D
 */
public class DotClass extends Point2D {

    /**
     * The X (horizontal) coordinate of this <code>DotClass</code>.
     */
    private double x;

    /**
     * The Y (vertical) coordinate of this <code>DotClass</code>.
     */
    private double y;

//    public DotClass prev;
//    public DotClass next;


    /**
     * Constructs and initializes a <code>DotClass</code> with
     *
     * @param x (horizontal) coordinate of this <code>DotClass</code>.
     * @param y (vertical) coordinate of this <code>DotClass</code>.
     */
    public DotClass(double x, double y) {
        if (x <= 1000 && y <= 1000) {
            this.x = x;
            this.y = y;
        }
    }

    /**
     * sets the X coordinate of <code>DotClass</code>
     *
     * @param x the new X coordinate of this {@code DotClass}
     */
    public void setX(double x) {
        if (x <= 1000)
            this.x = x;
    }

    /**
     * sets the Y coordinate of <code>DotClass</code>
     *
     * @param y the new Y coordinate of this {@code DotClass}
     */
    public void setY(double y) {
        if (y <= 1000)
            this.y = y;
    }

    /**
     * @return X coordinate of <code>DotClass</code>
     */
    public double getX() {
        return x;
    }

    /**
     * @return Y coordinate of <code>DotClass</code>
     */
    public double getY() {
        return y;
    }


    /**
     * Sets the location of this <code>DotClass</code> to the
     * specified <code>double</code> coordinates.
     *
     * @param x the new X coordinate of this {@code DotClass}
     * @param y the new Y coordinate of this {@code DotClass}
     */
    @Override
    public void setLocation(double x, double y) {
        if (x < 1000 && y <= 1000) {
            this.x = x;
            this.y = y;
        }
    }


    /**
     * Determines that two points are near or not . Two instances of
     * <code>DotClass</code> are close if the distance between
     * their position in the coordinate space, are under than setted  radius.
     *
     * @param radius - is the setted value of closeness
     * @param d1     an first object of <code>DotClass</code>
     * @param d2     an other object of <code>DotClass</code>
     * @return <code>true</code> if the objects closest than radius
     */
    public boolean isNear(DotClass d1, DotClass d2, int radius) {
        int distance = (int) Math.sqrt(Math.pow(d1.getX() - d2.getX(), 2) + Math.pow(d1.getY() - d2.getY(), 2));
        if (distance <= radius) return true;
        else return false;
    }

    /**
     * Returns a <code>double</code> value that represents the value
     * of distance between two instances of <code>DotClass</code> in coordinate space
     *
     * @param d1 - an first object of <code>DotClass</code>
     * @param d2 - an other object of <code>DotClass</code>
     * @return <code>double</code> value of distance between two instances of <code>DotClass</code>
     */
    public static double getDistance(DotClass d1, DotClass d2) {
        if (d1 != null && d2 != null) {
            return Math.sqrt(Math.pow(d1.getX() - d2.getX(), 2) + Math.pow(d1.getY() - d2.getY(), 2));
        }
        return -1;
    }

    /**
     * Returns a middle point between two <code>DotClass</code> instances
     * or <code>null</code> if their links are equal
     *
     * @param d1 is a instance of <code>DotClass</code>
     * @param d2 is a other instance of <code>DotClass</code>
     * @return instance of <code>DotClass</code> with some coordinates
     * that is midway between two points or <code>null</code> if links of this dots are equal
     */
    public static DotClass getMiddle(DotClass d1, DotClass d2) {
        if (d1.equals(d2) || d1 == null || d2 == null) return null;
        double middleX = (d1.getX() + d2.getX()) / 2;
        double middleY = (d1.getY() + d2.getY()) / 2;
        return new DotClass(middleX, middleY);
    }

}
