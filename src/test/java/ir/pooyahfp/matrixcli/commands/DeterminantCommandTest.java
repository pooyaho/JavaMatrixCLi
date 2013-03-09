/*
 * Copyright (c) 2013, Phsys and/or its affiliates. All rights reserved.
 *  Phsys PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package ir.pooyahfp.matrixcli.commands;

import ir.pooyahfp.matrixcli.matrix.SimpleObject;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author : Pooya husseini
 *         Email : info@pooya-hfp.ir
 *         Date: 3/7/13
 *         Time: 3:48 PM
 */
@Command(targetClass = DeterminantCommand.class)
public class DeterminantCommandTest extends AbstractCommandTest {

    public DeterminantCommandTest() throws Exception {
    }

    @Test
    public void testDeterminant() throws Exception {
        executeWithOperands("a");
    }

    @Test
    public void testDeterminantAndPutToValue() throws Exception {
        executeWithOperands("f", "a");
        SimpleObject f = getMathObject("f");
        Assert.assertEquals(f.doubleValue(), 0, 0);
    }

    @Test
    public void testDeterminantAndPutToMatrix() throws Exception {
        executeAndExpectException("c", "a");
    }

    @Test
    public void testDeterminantOfMultipleOperand() throws Exception {
        executeAndExpectException("e", "a", "f");
    }

    @Test
    public void testDeterminantOfNonSquareMatrix() throws Exception {
        executeAndExpectException("e");
    }
}
