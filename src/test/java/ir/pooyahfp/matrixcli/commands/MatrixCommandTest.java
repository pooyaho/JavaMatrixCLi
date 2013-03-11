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
 *         Time: 5:01 PM
 */
@Command(targetClass = MatrixCommand.class)
public class MatrixCommandTest extends AbstractCommandTest {
    public MatrixCommandTest() throws Exception {
    }

    @Test
    public void testCreateNamedMatrix() throws Exception {
        executeWithOperands("x");
        Assert.assertTrue(hasMathObject("x"));
    }

    @Test
    public void testSizedMatrix() throws Exception {
        executeWithOperands("x", "3", "2");
        Assert.assertTrue(hasMathObject("x"));

        MatrixObject x = (MatrixObject) getMathObject("x");

        Assert.assertEquals(x.getWidth(), 2);
        Assert.assertEquals(x.getHeight(), 3);
    }

    @Test
    public void testGiveUnexpectedParameters() throws Exception {
        executeAndExpectException();
        executeAndExpectException("");
        executeAndExpectException("a", "b");
        executeAndExpectException("a", "b", "c");
        executeAndExpectException("a", "b", "c", "4");
        executeAndExpectException("a", "2", "3", "4");
        executeAndExpectException("a", "b", "3");
        executeAndExpectException("a", "4", "g");
    }

}
