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
 *         Date: 3/11/13
 *         Time: 4:03 PM
 */
@Command(targetClass = SetCommand.class)
public class SetCommandTest extends AbstractCommandTest {
    public SetCommandTest() throws Exception {
    }

    @Test
    public void testSetMatrix() throws Exception {
        executeWithOperands("a", new Integer[]{11, 12, 13, 14, 15, 16, 17, 18, 19});

        MatrixObject a = (MatrixObject) getMathObject("a");

        Assert.assertArrayEquals(a.getContent()[0], new double[]{11, 12, 13}, 0);
        Assert.assertArrayEquals(a.getContent()[1], new double[]{14, 15, 16}, 0);
        Assert.assertArrayEquals(a.getContent()[2], new double[]{17, 18, 19}, 0);
    }

    @Test
    public void testSetWithRowIndexMatrix() throws Exception {
        executeWithOperands("a", "1", "", new Integer[]{11, 12, 13});

        MatrixObject a = (MatrixObject) getMathObject("a");

        Assert.assertArrayEquals(a.getContent()[0], new double[]{11, 12, 13}, 0);
        Assert.assertArrayEquals(a.getContent()[1], new double[]{4, 5, 6}, 0);
        Assert.assertArrayEquals(a.getContent()[2], new double[]{7, 8, 9}, 0);

    }

    @Test
    public void testSetWithColIndexMatrix() throws Exception {
        executeWithOperands("a", "", "1", new Integer[]{11, 12, 13});

        MatrixObject a = (MatrixObject) getMathObject("a");

        Assert.assertArrayEquals(a.getContent()[0], new double[]{11, 2, 3}, 0);
        Assert.assertArrayEquals(a.getContent()[1], new double[]{12, 5, 6}, 0);
        Assert.assertArrayEquals(a.getContent()[2], new double[]{13, 8, 9}, 0);
    }

    @Test
    public void testSetWithEmptyIndexMatrix() throws Exception {
        executeWithOperands("a", "", "", new Integer[]{11, 12, 13, 14, 15, 16, 17, 18, 19});

        MatrixObject a = (MatrixObject) getMathObject("a");

        Assert.assertArrayEquals(a.getContent()[0], new double[]{11, 12, 13}, 0);
        Assert.assertArrayEquals(a.getContent()[1], new double[]{14, 15, 16}, 0);
        Assert.assertArrayEquals(a.getContent()[2], new double[]{17, 18, 19}, 0);
    }

    @Test
    public void testSetWithColAndRowIndexMatrix() throws Exception {
        executeWithOperands("a", "1", "1", new Integer[]{11});

        MatrixObject a = (MatrixObject) getMathObject("a");

        Assert.assertArrayEquals(a.getContent()[0], new double[]{11, 2, 3}, 0);
        Assert.assertArrayEquals(a.getContent()[1], new double[]{4, 5, 6}, 0);
        Assert.assertArrayEquals(a.getContent()[2], new double[]{7, 8, 9}, 0);
    }

    @Test
    public void testNonCorrectParameters() throws Exception {
        executeAndExpectException(new int[]{11, 12, 13, 14, 15, 16, 17, 18}, "a");
        fillMap();
        executeAndExpectException(new int[]{16, 17, 18}, "a");
        fillMap();
        executeAndExpectException(new int[]{}, "a");
        fillMap();
        executeAndExpectException(new int[]{}, "a");

    }
}