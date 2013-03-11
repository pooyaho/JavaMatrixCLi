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
 *         Date: 3/9/13
 *         Time: 5:50 PM
 */
@Command(targetClass = MulCommand.class)
public class MulCommandTest extends AbstractCommandTest {
    public MulCommandTest() throws Exception {
    }

    @Test
    public void testMulTwoOperand() throws Exception {
        executeWithOperands("a", "b");

        MatrixObject object = (MatrixObject) getMathObject("a");
        Assert.assertArrayEquals(object.getContent()[0], new double[]{30.000, 24.000, 18.000}, 0);
        Assert.assertArrayEquals(object.getContent()[1], new double[]{84.000, 69.000, 54.000}, 0);
        Assert.assertArrayEquals(object.getContent()[2], new double[]{138.000, 114.000, 90.000}, 0);
    }

    @Test
    public void testMulThreeOperand() throws Exception {
        executeWithOperands("c", "a", "b");

        MatrixObject object = (MatrixObject) getMathObject("c");
        Assert.assertArrayEquals(object.getContent()[0], new double[]{30.000, 24.000, 18.000}, 0);
        Assert.assertArrayEquals(object.getContent()[1], new double[]{84.000, 69.000, 54.000}, 0);
        Assert.assertArrayEquals(object.getContent()[2], new double[]{138.000, 114.000, 90.000}, 0);
    }

    @Test
    public void testMulNotSizedOperand() throws Exception {
        executeAndExpectException("c", "a");
    }

    @Test
    public void testUnexpectedOperands() throws Exception {
        executeAndExpectException("c", "a", "d", "d");
    }

    @Test
    public void testMulMatrixAndNumber() throws Exception {
        executeWithOperands("a", "d");
        MatrixObject a = (MatrixObject) getMathObject("a");

        Assert.assertArrayEquals(a.getContent()[0], new double[]{1, 2, 3}, 0);
        Assert.assertArrayEquals(a.getContent()[1], new double[]{4, 5, 6}, 0);
        Assert.assertArrayEquals(a.getContent()[2], new double[]{7, 8, 9}, 0);
    }

    @Test
    public void testMulNumberAndMatrix() throws Exception {
        executeAndExpectException("d", "a");
    }

    @Test
    public void testMulNumberAndNumber() throws Exception {
        executeWithOperands("d", "e");
        SimpleObject d = getMathObject("d");
        Assert.assertEquals(d.doubleValue(), 67.0, 0);
    }
}
