/*
 * Copyright (c) 2013, Phsys and/or its affiliates. All rights reserved.
 *  Phsys PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package ir.pooyahfp.matrixcli.commands;

import ir.pooyahfp.matrixcli.matrix.MatrixObject;
import ir.pooyahfp.matrixcli.matrix.SimpleObject;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author : Pooya husseini
 *         Email : info@pooya-hfp.ir
 *         Date: 3/13/13
 *         Time: 6:36 PM
 */
@Command(targetClass = SubCommand.class)
public class SubCommandTest extends AbstractCommandTest {
    public SubCommandTest() throws Exception {
    }

    @Test
    public void testSubMatrices() throws Exception {
        executeWithOperands("b", "a");
        MatrixObject b = (MatrixObject) getMathObject("b");

        Assert.assertArrayEquals(b.getContent()[0], new double[]{8, 6, 4}, 0);
        Assert.assertArrayEquals(b.getContent()[1], new double[]{2, 0, -2}, 0);
        Assert.assertArrayEquals(b.getContent()[2], new double[]{-4, -6, -8}, 0);
    }

    @Test
    public void testSubMatricesAndFill() throws Exception {
        executeWithOperands("c", "b", "a");
        MatrixObject c = (MatrixObject) getMathObject("c");

        Assert.assertArrayEquals(c.getContent()[0], new double[]{8, 6, 4}, 0);
        Assert.assertArrayEquals(c.getContent()[1], new double[]{2, 0, -2}, 0);
        Assert.assertArrayEquals(c.getContent()[2], new double[]{-4, -6, -8}, 0);
    }

    @Test
    public void testSubNumber() throws Exception {
        executeWithOperands("e", "d");
        SimpleObject e = getMathObject("e");

        Assert.assertEquals(e.doubleValue(), 66, 0);
    }


    @Test
    public void testSubNumberAndPut() throws Exception {
        executeWithOperands("f","e", "d");
        SimpleObject f = getMathObject("f");

        Assert.assertEquals(f.doubleValue(), 66, 0);
    }

    @Test
    public void testSubMatrixAndNumber() throws Exception {
        executeWithOperands("a","d");
        MatrixObject a = (MatrixObject) getMathObject("a");

        Assert.assertArrayEquals(a.getContent()[0], new double[]{0, 1, 2}, 0);
        Assert.assertArrayEquals(a.getContent()[1], new double[]{3, 4, 5}, 0);
        Assert.assertArrayEquals(a.getContent()[2], new double[]{6, 7, 8}, 0);
    }

    @Test
    public void testSubNumberAndMatrix() throws Exception {
        executeAndExpectException("d","a");
    }

    @Test
    public void testNonCorrectParameters() throws Exception {
        executeAndExpectException("a","c");
        executeAndExpectException("a","c","a","a");
        executeAndExpectException("a");
    }
}