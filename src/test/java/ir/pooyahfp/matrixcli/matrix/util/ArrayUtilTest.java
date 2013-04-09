/*
 * Copyright (c) 2013, Phsys and/or its affiliates. All rights reserved.
 *  Phsys PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package ir.pooyahfp.matrixcli.matrix.util;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author : Pooya husseini
 *         Email : info@pooya-hfp.ir
 *         Date: 3/11/13
 *         Time: 8:05 PM
 */
public class ArrayUtilTest {
    private final static double[] ARR=new double[9];

    static {
        Arrays.fill(ARR, 0, 9, 12.0);
    }

    @Test
    public void testSplitArray() {
        Object[][] doubles = ArrayUtil.splitArray(ArrayUtil.toObject(ARR), 3);

        for (Object[] aDouble : doubles) {
            Assert.assertArrayEquals(aDouble, new Double[]{12.0, 12.0, 12.0});
        }
    }

    @Test
    public void testDivide() {
        double[] divide = ArrayUtil.divide(ARR, 3);

        for (double aDivide : divide) {
            Assert.assertEquals(aDivide, 4, 0);
        }

        double[] divide2 = ArrayUtil.divide(ARR, divide);

        for (double aDivide : divide2) {
            Assert.assertEquals(aDivide, 3, 0);
        }
    }

    @Test
    public void testMultiply() {
        double[] multiply1 = ArrayUtil.multiply(ARR, 2);

        for (double a : multiply1) {
            Assert.assertEquals(a, 24, 0);
        }

        double[] multiply2 = ArrayUtil.multiply(ARR, multiply1);

        for (double a : multiply2) {
            Assert.assertEquals(a, 288, 0);
        }
    }

    @Test
    public void testSub() {
        double[] sub1 = ArrayUtil.sub(ARR, 2);

        for (double a : sub1) {
            Assert.assertEquals(a, 10, 0);
        }

        double[] sub2 = ArrayUtil.sub(ARR, sub1);

        for (double a : sub2) {
            Assert.assertEquals(a, 2, 0);
        }
    }

    @Test
    public void testToObject() {
        double[][] a = new double[][]{{1, 2}, {3, 4}};

        Double[][] doubles = ArrayUtil.toObject(a);
        Assert.assertArrayEquals(doubles[0], new Double[]{1.0, 2.0});
        Assert.assertArrayEquals(doubles[1], new Double[]{3.0, 4.0});
    }

    @Test
    public void testAdd() {

        double[] add1 = ArrayUtil.add(ARR, 2);

        for (double a : add1) {
            Assert.assertEquals(a, 14, 0);
        }

        double[] add2 = ArrayUtil.add(ARR, add1);

        for (double a : add2) {
            Assert.assertEquals(a, 26, 0);
        }

    }

    @Test
    public void testConcat() {
        double[] concat = ArrayUtil.concat(ARR, ARR);
        for (double aConcat : concat) {
            Assert.assertEquals(aConcat, 12, 0);
        }
    }

    @Test
    public void testGCD() {
        double gcd = ArrayUtil.gcd(new double[]{4, 6, 8});
        Assert.assertEquals(gcd, 2, 0);
    }

}