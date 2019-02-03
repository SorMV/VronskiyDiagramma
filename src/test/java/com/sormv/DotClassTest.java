package com.sormv;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class DotClassTest {

    private DotClass dot;

    @BeforeEach
    void setUp() {
        dot = new DotClass(100, 100);
    }

    @Test
    void setX() {
        Assert.assertEquals(100, dot.getX(), 0.1);
        dot.setX(50);
        Assert.assertEquals(50, dot.getX(), 0.1);
        dot.setX(1111);
        Assert.assertEquals(50, dot.getX(), 0.1);
    }

    @Test
    void setY() {
        Assert.assertEquals(100, dot.getY(), 0.1);
        dot.setY(50);
        Assert.assertEquals(50, dot.getY(), 0.1);
        dot.setY(1111);
        Assert.assertEquals(50, dot.getY(), 0.1);
    }

    @Test
    void getX() {
        Assert.assertEquals(100, dot.getX(), 0.1);
        dot.setX(50);
        Assert.assertEquals(50, dot.getX(), 0.1);
    }

    @Test
    void getY() {
        Assert.assertEquals(100, dot.getY(), 0.1);
        dot.setY(50);
        Assert.assertEquals(50, dot.getY(), 0.1);
    }

    @Test
    void setLocation() {
        Assert.assertEquals(100, dot.getY(), 0.1);
        Assert.assertEquals(100, dot.getX(), 0.1);
        dot.setLocation(50, 50);
        Assert.assertEquals(50, dot.getY(), 0.1);
        Assert.assertEquals(50, dot.getX(), 0.1);
        dot.setLocation(1111, 11111);
        Assert.assertEquals(50, dot.getY(), 0.1);
        Assert.assertEquals(50, dot.getX(), 0.1);
    }

    @Test
    void isNear() {
    }

    @Test
    void getDistance() {
        Assert.assertEquals(-1, DotClass.getDistance(dot, null), 0.1);
        DotClass dot2 = new DotClass(100, 150);
        Assert.assertEquals(50, DotClass.getDistance(dot, dot2), 0.1);
        dot2 = new DotClass(200, 100);
        Assert.assertEquals(100, DotClass.getDistance(dot, dot2), 0.1);
    }

    @Test
    void getMiddle() {
        DotClass dot2 = new DotClass(100, 150);
        DotClass realMiddle = new DotClass(100, 125);
        Assert.assertEquals(realMiddle, DotClass.getMiddle(dot, dot2));
        dot2 = new DotClass(100, 100);
        Assert.assertNull(DotClass.getMiddle(dot, dot2));
        Assert.assertNull(DotClass.getMiddle(dot, null));
    }
}