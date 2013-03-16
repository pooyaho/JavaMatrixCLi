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
 *         Date: 3/7/13
 *         Time: 3:05 PM
 */
@Command(targetClass = CopyCommand.class)
public class CopyCommandTest extends AbstractCommandTest {
    public CopyCommandTest()  {
    }

    @Test
    public void testCopyTwoMatrices() throws IllegalAccessException, InstantiationException {
        executeWithOperands("a", "b");

        MatrixObject a = (MatrixObject) getMathObject("a");
        MatrixObject b = (MatrixObject) getMathObject("b");

        for (int i = 0; i < a.getHeight(); i++) {
            Assert.assertArrayEquals(a.getContent()[i], b.getContent()[i], 0);
        }
    }

    @Test
    public void testCopyTwoNotSameSizedMatrices() throws IllegalAccessException, InstantiationException {
        executeWithOperands("a", "c");

        MatrixObject a = (MatrixObject) getMathObject("a");
        MatrixObject c = (MatrixObject) getMathObject("c");

        for (int i = 0; i < a.getHeight(); i++) {
            Assert.assertArrayEquals(a.getContent()[i], c.getContent()[i], 0);
        }
    }

    @Test
    public void testCopyTwoValues() throws IllegalAccessException, InstantiationException {
        executeWithOperands("d", "e");

        SimpleObject d = getMathObject("d");
        SimpleObject e = getMathObject("e");
        Assert.assertEquals(d.doubleValue(), e.doubleValue(), 0);
    }

    @Test
    public void testCopyValueAndOtherTypes()  {
        executeAndExpectException("a", "e");
    }

    @Test
    public void testCopyOtherTypeAndValue()  {
        executeAndExpectException("e", "a");
    }

    @Test
    public void testCopyWithManyOperands()  {
        executeAndExpectException("e", "a", "e", "a");
        executeAndExpectException("e");
    }
}
