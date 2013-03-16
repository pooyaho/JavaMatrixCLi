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
 *         Date: 3/11/13
 *         Time: 3:49 PM
 */
@Command(targetClass = RankCommand.class)
public class RankCommandTest extends AbstractCommandTest {
    public RankCommandTest()  {
    }

    @Test
    public void testRankMatrix() throws IllegalAccessException, InstantiationException {
        executeWithOperands("a");
    }

    @Test
    public void testRankMatrixAndPush() throws IllegalAccessException, InstantiationException {
        executeWithOperands("d", "a");
        SimpleObject d = getMathObject("d");

        Assert.assertEquals(d.doubleValue(), 2, 0);
    }

    @Test
    public void testRankNumber()  {
        executeAndExpectException("d");
    }

    @Test
    public void testNonCorrectParameters()  {
        executeAndExpectException();
        executeAndExpectException("a","a","a");
    }
}
