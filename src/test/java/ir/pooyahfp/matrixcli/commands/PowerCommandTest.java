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
 *         Date: 3/11/13
 *         Time: 3:27 PM
 */
@Command(targetClass = PowerCommand.class)
public class PowerCommandTest extends AbstractCommandTest {
    public PowerCommandTest()  {
    }

    @Test
    public void testPowerOfMatrixNumber() throws IllegalAccessException, InstantiationException {
        executeWithOperands("a", "g");

        MatrixObject a = (MatrixObject) getMathObject("a");
        Assert.assertArrayEquals(a.getContent()[0], new double[]{468.000, 576.000, 684.000}, 0);
        Assert.assertArrayEquals(a.getContent()[1], new double[]{1062.000, 1305.000, 1548.000}, 0);
        Assert.assertArrayEquals(a.getContent()[2], new double[]{1656.000, 2034.000, 2412.000}, 0);
    }

    @Test
    public void testPowerOfMatrixMatrix()  {
        executeAndExpectException("a", "b");
    }

    @Test
    public void testPowerOfNumberNumber() throws IllegalAccessException, InstantiationException {
        executeWithOperands("e", "g");
        SimpleObject e = getMathObject("e");
        Assert.assertEquals(e.doubleValue(),300763,0);
    }
    @Test
    public void testPowerOfNumberMatrix()  {
        executeAndExpectException("e", "a");
    }
    @Test
    public void testNonCorrectParameters()  {
        executeAndExpectException();
        executeAndExpectException("e");
        executeAndExpectException("e","g","g");
    }

}
