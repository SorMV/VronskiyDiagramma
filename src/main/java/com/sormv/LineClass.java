package com.sormv;

import java.awt.geom.Line2D;
import java.util.ArrayList;

/**
 * This <code>LineClass</code> represents a line segment in {@code (x,y)}
 * coordinate space.  This class, like all of the Java 2D API, uses a
 * default coordinate system called <i>user space</i> in which the y-axis
 * values increase downward and x-axis values increase to the right.  For
 * more information on the user space coordinate system, see the
 * <a href="https://docs.oracle.com/javase/1.3/docs/guide/2d/spec/j2d-intro.fm2.html#61857">
 * Coordinate Systems</a> section of the Java 2D Programmer's Guide.
 */
public class LineClass extends Line2D.Double {

    /**
     * Constructs and initializes a <code>LineClass</code> from the
     * specified coordinates.
     *
     * @param x1 the X coordinate of the start point
     * @param y1 the Y coordinate of the start point
     * @param x2 the X coordinate of the end point
     * @param y2 the Y coordinate of the end point
     */
    public LineClass(double x1, double x2, double y1, double y2) {
        if (x1 <= 1000 && x2 <= 1000 && y1 <= 1000 && y2 <= 1000) {
            this.x1 = x1;
            this.x2 = x2;
            this.y1 = y1;
            this.y2 = y2;
        }
    }

    /**
     * Returns a <code>DotClass</code> object that represents the
     * intersection point of two different instances of <code>Line2D</code>
     *
     * @param line      is a first instance of <code>Line2D</code>
     * @param otherLine is a second instance of <code>Line2D</code>
     * @return <code>DotClass</code> a dot of intersection of two <code>Lines2D</code>
     * if they have a common dot or <code>null</code> otherwise
     */
    public static DotClass getCrossing(Line2D line, Line2D otherLine) {
        if (line != otherLine && line != null && otherLine != null) {
            double a1 = line.getY1() - line.getY2();
            double b1 = line.getX2() - line.getX1();
            double a2 = otherLine.getY1() - otherLine.getY2();
            double b2 = otherLine.getX2() - otherLine.getX1();
            double d = a1 * b2 - a2 * b1;
            if (d != 0) {
                double c1 = line.getY2() * line.getX1() - line.getX2() * line.getY1();
                double c2 = otherLine.getY2() * otherLine.getX1() - otherLine.getX2() * otherLine.getY1();
                return new DotClass((b1 * c2 - b2 * c1) / d, (a2 * c1 - a1 * c2) / d);
            }
            return null;
        }
        return null;
    }


    /**
     * Creates a <code>Line2D</code> that returns perpendicular to the given <code>Line2D</code>
     * segment and has midpoint in given <code>Line2D</code>  represented as <code>DotClass</code>
     *
     * @param inputLine is a instance of <code>Line2D</code> that represents distance between two points
     *                  and would be normalized
     * @param middle    is a <code>DotClass</code> which is midpoint of the input <code>LineClass</code>
     * @return new <code>Line2D</code> segment which will normalized to the input <code>Line2D</code>
     * segment and has midpoint in input <code>DotClass</code> coordinates or <code>null</code> if
     */
    public static Line2D normalize(Line2D inputLine, DotClass middle) {
        if (inputLine != null && middle != null) {
            double x1 = -1 * (inputLine.getY1() - inputLine.getY2());
            double y1 = ((inputLine.getX1() - inputLine.getX2()));
            return new Line2D.Double(x1 + middle.getX(), y1 + middle.getY(), middle.getX(), middle.getY());
        }
        return null;
    }

    public static ArrayList<Line2D> getNormilizedLines(ArrayList<DotClass> testDots) {
        ArrayList<Line2D> lines = new ArrayList<>();
        for (DotClass dot1 : testDots) {
            for (DotClass dot2 : testDots) {
                if (dot1 != dot2 && DotClass.getDistance(dot1, dot2) <= 500) {
                    Line2D lc = LineClass.normalize(new Line2D.Double(dot1.getX(), dot1.getY(), dot2.getX(), dot2.getY()), DotClass.getMiddle(dot1, dot2));
                    if (lc != null) {
                        lines.add(lc);
                    }
                }
            }
        }
        return lines;
    }
}
