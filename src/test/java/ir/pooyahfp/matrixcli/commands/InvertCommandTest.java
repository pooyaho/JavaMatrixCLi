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
 *         Date: 3/9/13
 *         Time: 4:28 PM
 */
@Command(targetClass = InvertCommand.class)
public class InvertCommandTest extends AbstractCommandTest {

    public InvertCommandTest()  {
    }

    @Test
    public void testInvertMatrix() throws IllegalAccessException, InstantiationException {
        MatrixObject matrixObject = ((MatrixObject) getMathObject("b")).setHeight(2).setWidth(2);

        matrixObject.setContent(new double[]{1, 2, 3, 4});
        updateMathObject(matrixObject);
        executeWithOperands("b");

        Assert.assertArrayEquals(matrixObject.getContent()[0], new double[]{-2, 1}, 0);

        Assert.assertArrayEquals(matrixObject.getContent()[1], new double[]{1.5, -.5}, 0);
    }

    @Test
    public void testNonInvertibleMatrix()  {
        executeAndExpectException("a");
    }


    @Test
    public void testNonAppropriateParameters()  {
        executeAndExpectException("a", "b", "c");
        executeAndExpectException();
    }

    @Test
    public void testInvertAndPushResult() throws IllegalAccessException, InstantiationException {
        MatrixObject z = new MatrixObject(2, 2, "z");

        z.setContent(new double[]{1, 2, 3, 4});
        createMathObject(z);
        executeWithOperands("b", "z");

        MatrixObject b = (MatrixObject) getMathObject("b");

        Assert.assertArrayEquals(b.getContent()[0], new double[]{-2, 1}, 0);

        Assert.assertArrayEquals(b.getContent()[1], new double[]{1.5, -.5}, 0);
    }

    @Test
    public void testInvertValue()  {
        executeAndExpectException("f");
    }
}