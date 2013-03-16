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
 *         Time: 7:23 PM
 */
@Command(targetClass = SwapCommand.class)
public class SwapCommandTest extends AbstractCommandTest {
    public SwapCommandTest()  {
    }

    @Test
    public void testSwapMatrices() throws IllegalAccessException, InstantiationException {
        MatrixObject oldA = (MatrixObject) getMathObject("a");
        MatrixObject oldB = (MatrixObject) getMathObject("b");
        executeWithOperands("a", "b");
        MatrixObject a = (MatrixObject) getMathObject("a");
        MatrixObject b = (MatrixObject) getMathObject("b");


        Assert.assertArrayEquals(oldA.getContent(), b.getContent());
        Assert.assertArrayEquals(oldB.getContent(), a.getContent());
    }

    @Test
    public void testSwapMatrixAndNumber()  {
        executeAndExpectException("a", "d");
    }

    @Test
    public void testSwapNumberAndMatrix()  {
        executeAndExpectException("d", "a");
    }

    @Test
    public void testSwapNumbers() throws IllegalAccessException, InstantiationException {
        SimpleObject oldD = getMathObject("d");
        SimpleObject oldE = getMathObject("e");

        executeWithOperands("d", "e");
        SimpleObject d = getMathObject("d");
        SimpleObject e = getMathObject("e");

        Assert.assertEquals(oldD.doubleValue(), e.doubleValue(),0);
        Assert.assertEquals(oldE.doubleValue(), d.doubleValue(),0);
    }

    @Test
    public void testNonCorrectParameters()  {
       executeAndExpectException("a","b","c");
       executeAndExpectException("a");
       executeAndExpectException();
    }
}