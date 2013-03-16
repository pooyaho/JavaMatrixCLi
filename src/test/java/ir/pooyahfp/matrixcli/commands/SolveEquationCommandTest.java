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
 *         Date: 3/13/13
 *         Time: 2:15 PM
 */
@Command(targetClass = SolveEquationCommand.class)
public class SolveEquationCommandTest extends AbstractCommandTest {

    public SolveEquationCommandTest()  {
    }

    @Test
    public void testSolveEquation() throws IllegalAccessException, InstantiationException {
        MatrixObject a = (MatrixObject) getMathObject("a");

        updateMathObject(a.setContent(5, 0, 0));
        executeWithOperands("x", "a", "m");
        MatrixObject x = (MatrixObject) getMathObject("x");

        Assert.assertArrayEquals(x.getContent()[0], new double[]{0.0}, 0);
        Assert.assertArrayEquals(x.getContent()[1], new double[]{-10.0}, 0);
        Assert.assertArrayEquals(x.getContent()[2], new double[]{9.667}, 0.5);
    }

    @Test
    public void testMultipleParameters()  {
        executeAndExpectException("a");
        executeAndExpectException("a", "b");

        executeAndExpectException("a", "b", "a");
        executeAndExpectException();
    }
}