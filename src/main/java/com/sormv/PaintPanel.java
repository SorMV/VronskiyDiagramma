package com.sormv;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.TreeSet;

/**
 * The base class for all Swing components except top-level containers.
 * To use a component that inherits from <code>JComponent</code>
 * you must place the component in a containment hierarchy
 * whose root is a top-level Swing container.
 * Top-level Swing containers --
 * such as <code>JFrame</code>
 *
 * @see JFrame
 * This class provide a place for other Swing components to paint themselves.
 */
public class PaintPanel extends JComponent {

    //Parabolic parabolic = new Parabolic();
    // private TreeSet<DotClass> dots;
    /**
     * this field stores all added dots <code>DotClass</code>
     */
    private ArrayList<DotClass> testDots;

    /**
     * Constructs and initializes a <code>PaintPanel</code> with no psrameters
     * in addition to the initial graphic settings we add new Listener for
     * mouse and override mouseClicked event
     *
     * @see MouseAdapter
     * when mouse clicked on painting area we create new <code>DotClass</code> dot
     * with computer mouse coordinates to testDots field with
     */
    public PaintPanel() {
        testDots = new ArrayList<>();
        setSize(new Dimension(1000, 1000));
        setBackground(Color.WHITE);
        setBorder(new LineBorder(Color.BLACK, 3));
        setVisible(true);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                testDots.add(new DotClass(e.getX(), e.getY()));
                repaint();
            }
        });

    }

    /**
     * @return testDots array with all created <code>DotClass</code> dots
     */
    public ArrayList<DotClass> getDots() {
        return testDots;
    }


    /**
     * adds the dot of <code>DotClass</code> class to a testDots field
     *
     * @param dot is the new dot of <code>DotClass</code>
     */
    public void addDots(DotClass dot) {
        this.testDots.add(dot);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        for (DotClass dot : testDots) {
            g2.draw(new Ellipse2D.Double(dot.getX(), dot.getY(), 5, 5));
        }

        ArrayList<Line2D> lineArray;
        lineArray = LineClass.getNormilizedLines(testDots);
        for (Line2D line : lineArray) {
            g2.draw(line);
        }


    /*
                ArrayList<Line2D> lines = new ArrayList<>();
                for(Line2D line: lineArray) {
                    for(Line2D otherLine: lineArray) {
                        if(line!=otherLine) {
                            DotClass crossDot = LineClass.getCrossing(line, otherLine);
                            if(crossDot==null) {
                                lines.add(otherLine);
                                continue;
                            }
                                if (DotClass.getDistance(crossDot, new DotClass(line.getX2(), line.getY2())) < DotClass.getDistance(crossDot, new DotClass(otherLine.getX2(), otherLine.getY2()))) {
                                    line.setLine(crossDot.getX(), crossDot.getY(), line.getX2(), line.getY2());
                                    lines.add(line);
                                } else {
                                    otherLine.setLine(crossDot.getX(), crossDot.getY(), otherLine.getX2(), otherLine.getY2());
                                    lines.add(otherLine);
                                }
                        }
                    }
                    for(Line2D ln:lines) {
                        g2.draw(ln);
                    }
                }
                */
        //  g2.draw(DotClass.normalize(new Line2D.Double((double)dot1.getX(), (double)dot1.getY(),(double)dot2.getX(),(double)dot2.getY()), DotClass.getMiddle(dot1,dot2)));




        /*
        ArrayList<Integer> yValues = new ArrayList<>();
        ArrayList<Integer> xValues = new ArrayList<>();
        for (DotClass dot: dots) {
            yValues.add(dot.getY());
            xValues.add(dot.getX());
        }
        int count=0;
        int xcount=0;
        for (int l = 0; l <= 500; l = l + 1) {
            if(l==yValues.get(count)) {
                Iterator<DotClass> iterator = dots.iterator();
                if(count+1<yValues.size()) {
                    l=(yValues.get(count)+yValues.get(count+1))/2;
                    count++;
                    xcount=count;
                }

                while (iterator.hasNext()) {
                    DotClass dot = iterator.next();
                    g2.fill(new Ellipse2D.Double(dot.getX(), dot.getY(), 5, 5));
                    if (dots.size() > 1) {
//                if(iterator.hasNext()) {
//                    iterator.
//                }
                        //  for (int l = dot.getX(); l <= 500; l = l + 100) {
                        for (int j = 0; j <= 500; j = j + 100) {
                            for (int x = 0; x <= xValues.get(xcount); x = x + 5) {
                                for (int y = 0; y <= l; y = y + 5) {
                                    if (DotClass.getDistance(dot, new DotClass(x, y)) <= l - y) {
                                        // g2.draw(new Ellipse2D.Double(x, y, 5, 5));
                                        g2.drawArc(x,y,5,5,90,90);

                                    }
                                }
                            }
                            // DotClass.getDistance(new DotClass(j,parabolic.createYValues(j,l,dot.getX(),dot.getY())), dot)==(dot.getY()-l)) {
                            // g2.draw(new Ellipse2D.Double(parabolic.createYValues(j, l, dot.getX(), dot.getY()), j, 5, 5));
                            // g2.draw(new Ellipse2D.Double(parabolic.createYValues(j, l, dot.getX(), dot.getY()),j,5,5));


                        }
                    }
                }
            }
            }

            */

    }

    /**
     * class which implements Comparator and used to sorting elements of
     * <code>TreeSet<DotClass></code> collection by Y coordinate
     *
     * @see Comparator
     */
    class TreeComparator implements Comparator<DotClass> {

        @Override
        public int compare(DotClass o1, DotClass o2) {
            return Double.compare(o1.getY(), o2.getY());
        }
    }
}


