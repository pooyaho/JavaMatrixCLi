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
 *         Date: 3/6/13
 *         Time: 7:40 PM
 */
@Command(targetClass = AddCommand.class)
public class AddCommandTest extends AbstractCommandTest {

    public AddCommandTest() throws Exception {

    }

    @Test
    public void testAddMultipleOperands() throws Exception {
        executeAndExpectException("e", "d", "d", "d");
    }

    @Test
    public void testValueAndValue() throws Exception {
        executeWithOperands("e", "d");

        SimpleObject e = getMathObject("e");
        Assert.assertEquals(e.doubleValue(), 68, 0);
    }

    @Test
    public void testValueAndMatrix() throws Exception {
        executeAndExpectException("d", "a");
    }

    @Test
    public void testMatrixAndValue() throws Exception {
        executeWithOperands("a", "d");

        MatrixObject a = (MatrixObject) getMathObject("a");

        Assert.assertArrayEquals(a.getContent()[0], new double[]{2, 3, 4}, 0);
        Assert.assertArrayEquals(a.getContent()[1], new double[]{5, 6, 7}, 0);
        Assert.assertArrayEquals(a.getContent()[2], new double[]{8, 9, 10}, 0);
    }

    @Test
    public void testAddWrongSizedMatrices() throws Exception {
        executeAndExpectException("a", "c");
    }

    @Test
    public void testAddTwoMatrices() throws Exception {
        executeWithOperands("a", "b");
        MatrixObject a = (MatrixObject) getMathObject("a");

        Assert.assertArrayEquals(a.getContent()[0], new double[]{10, 10, 10}, 0);
        Assert.assertArrayEquals(a.getContent()[1], new double[]{10, 10, 10}, 0);
        Assert.assertArrayEquals(a.getContent()[2], new double[]{10, 10, 10}, 0);
    }
}