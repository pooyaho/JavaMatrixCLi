/*
 * Copyright (c) 2013, Phsys and/or its affiliates. All rights reserved.
 *  Phsys PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package ir.pooyahfp.matrixcli.commands;

import ir.pooyahfp.matrixcli.matrix.MatrixObject;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author : Pooya husseini
 *         Email : info@pooya-hfp.ir
 *         Date: 3/16/13
 *         Time: 5:54 PM
 */
@Command(targetClass = TransposeCommand.class)
public class TransposeCommandTest extends AbstractCommandTest {
    public TransposeCommandTest() {

    }

    @Test
    public void testTranspose() throws IllegalAccessException, InstantiationException {
        executeWithOperands("a");

        MatrixObject matrixObject = (MatrixObject) getMathObject("a");
        Assert.assertArrayEquals(matrixObject.getContent()[0], new double[]{1, 4, 7}, 0);
        Assert.assertArrayEquals(matrixObject.getContent()[1], new double[]{2, 5, 8}, 0);
        Assert.assertArrayEquals(matrixObject.getContent()[2], new double[]{3, 6, 9}, 0);
    }

    @Test
    public void testAndPush() throws IllegalAccessException, InstantiationException {
        executeWithOperands("b","a");

        MatrixObject matrixObject = (MatrixObject) getMathObject("b");
        Assert.assertArrayEquals(matrixObject.getContent()[0], new double[]{1, 4, 7}, 0);
        Assert.assertArrayEquals(matrixObject.getContent()[1], new double[]{2, 5, 8}, 0);
        Assert.assertArrayEquals(matrixObject.getContent()[2], new double[]{3, 6, 9}, 0);
    }

    @Test
    public void testNonCorrectParameters() throws IllegalAccessException, InstantiationException {
        executeAndExpectException("d");
        executeAndExpectException();
        executeAndExpectException("a","b","c");
        executeAndExpectException("d","a");
    }
}
