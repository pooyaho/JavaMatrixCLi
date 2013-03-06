/*
 * Copyright (c) 2013, Phsys and/or its affiliates. All rights reserved.
 *  Phsys PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package ir.pooyahfp.matrixcli.matrix;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author : Pooya husseini
 *         Email : info@pooya-hfp.ir
 *         Date: 3/6/13
 *         Time: 5:43 PM
 */
public class SimpleObjectTest {
    @Test
    public void testIntValue() throws Exception {
        SimpleObject simpleObject = new SimpleObject("a", 12);
        Assert.assertEquals(simpleObject.longValue(), 12);

    }

    @Test
    public void testLongValue() throws Exception {
        SimpleObject simpleObject = new SimpleObject("a", 12);
        Assert.assertEquals(simpleObject.longValue(), 12, 0);

    }

    @Test
    public void testFloatValue() throws Exception {
        SimpleObject simpleObject = new SimpleObject("a", 12);
        Assert.assertEquals(simpleObject.floatValue(), 12L, 0);

    }

    @Test
    public void testDoubleValue() throws Exception {
        SimpleObject simpleObject = new SimpleObject("a", 12);
        Assert.assertEquals(simpleObject.doubleValue(), 12L, 0);

    }

    @Test
    public void testGetName() throws Exception {
        SimpleObject simpleObject = new SimpleObject("a", 12);
        Assert.assertEquals(simpleObject.getName(), "a");
    }

    @Test
    public void testAdd() throws Exception {
        SimpleObject simpleObject = new SimpleObject("a", 12);
        SimpleObject a = new SimpleObject("b", 3);

        Assert.assertEquals(simpleObject.add(a).intValue(), 15);
    }

    @Test
    public void testSub() throws Exception {
        SimpleObject simpleObject = new SimpleObject("a", 12);
        SimpleObject a = new SimpleObject("b", 3);

        Assert.assertEquals(simpleObject.sub(a).intValue(), 9);
    }

    @Test
    public void testMul() throws Exception {
        SimpleObject simpleObject = new SimpleObject("a", 12);
        SimpleObject a = new SimpleObject("b", 3);

        Assert.assertEquals(simpleObject.mul(a).intValue(), 36);
    }


    @Test
    public void testPower() throws Exception {
        SimpleObject simpleObject = new SimpleObject("a", 12);
        SimpleObject power = new SimpleObject("b", 3);
        Assert.assertEquals(simpleObject.power(2).intValue(), 144);

        Assert.assertEquals(simpleObject.power(power).intValue(), 1728);
    }

    @Test
    public void testCopy() throws Exception {
        SimpleObject simpleObject = new SimpleObject("a", 12);
        SimpleObject o = simpleObject.copy();

        Assert.assertEquals(o.intValue(), 12);
    }


    @Test
    public void testGetEquivalenceValue() throws Exception {
        SimpleObject simpleObject = new SimpleObject("a", 12);


        Assert.assertEquals(simpleObject.getEquivalenceValue(), 12, 0);
    }

    @Test
    public void testSetName() throws Exception {
        SimpleObject simpleObject = new SimpleObject("a", 12);
        simpleObject.setName("b");

        Assert.assertEquals(simpleObject.getName(), "b");
    }

    @Test
    public void testGetValue() throws Exception {
        SimpleObject simpleObject = new SimpleObject("a", 12);


        Assert.assertEquals(simpleObject.intValue(), 12);
    }

    @Test
    public void testSetValue() throws Exception {
        SimpleObject simpleObject = new SimpleObject("a", 12);
        simpleObject.setValue(13);

        Assert.assertEquals(simpleObject.intValue(), 13);
    }

    @Test
    public void testToString() throws Exception {
        SimpleObject simpleObject = new SimpleObject("a", 12);
        System.out.println(simpleObject);
    }
}
