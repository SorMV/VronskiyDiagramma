package com.sormv;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.sound.sampled.Line;
import java.awt.geom.Line2D;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class LineClassTest {

    private LineClass lc;

    @BeforeEach
    void setUp() {
        lc = new LineClass(100, 200, 0, 0);
    }

    @Test
    void getCrossing() {
        LineClass line = new LineClass(100, 0, 0, 50);
        DotClass dot = new DotClass(100, 0);
        Assert.assertEquals(dot, LineClass.getCrossing(lc, line));
        Assert.assertNull(LineClass.getCrossing(lc, null));
        line = new LineClass(100, 200, 0, 0);
        Assert.assertNull(LineClass.getCrossing(lc, line));
        line = new LineClass(10, 100, 1000, 10000);
        Assert.assertNull(LineClass.getCrossing(lc, line));
    }

    @Test
    void normalize() {
        Assert.assertNull(LineClass.normalize(lc, null));
        Assert.assertNull(LineClass.normalize(null, new DotClass(10, 10)));
        DotClass testDot = new DotClass(50, 50);
        Line2D testLine = new LineClass(50, 50, -50, 50);
        Line2D line = LineClass.normalize(lc, testDot);
        Assert.assertEquals(testLine.getX1(), line.getX1(), 0.1);
        Assert.assertEquals(testLine.getX2(), line.getX2(), 0.1);
        Assert.assertEquals(testLine.getY1(), line.getY1(), 0.1);
        Assert.assertEquals(testLine.getY2(), line.getY2(), 0.1);


    }


    @Test
    void getNormilizedLines() {
        DotClass dc = new DotClass(100, 0);
        DotClass dc2 = new DotClass(200, 0);
        ArrayList<DotClass> dotclass = new ArrayList<>();
        dotclass.add(dc);
        dotclass.add(dc2);
        Line2D line = LineClass.getNormilizedLines(dotclass).get(0);
        line = LineClass.normalize(line, DotClass.getMiddle(dc, dc2));
        Assert.assertEquals(line.getX1(), line.getX1(), 0.1);
        Assert.assertEquals(line.getX2(), line.getX2(), 0.1);
        Assert.assertEquals(line.getY1(), line.getY1(), 0.1);
        Assert.assertEquals(line.getY2(), line.getY2(), 0.1);

    }
}