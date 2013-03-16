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
 *         Date: 3/13/13
 *         Time: 7:35 PM
 */
@Command(targetClass = TraceCommand.class)
public class TraceCommandTest extends AbstractCommandTest {

    public TraceCommandTest() throws Exception {
    }

    @Test
    public void testTraceMatrix() throws Exception {
        executeWithOperands("a");
    }

    @Test
    public void testTraceMatrixAndPush() throws Exception {
        executeWithOperands("d", "a");
        SimpleObject d = getMathObject("d");

        Assert.assertEquals(d.doubleValue(), 15.0, 0);
    }

    @Test
    public void testTraceMatrixAndPushToMatrix() throws Exception {
        executeAndExpectException("b", "a");
    }

    @Test
    public void testNonCorrectParameters() throws Exception {
        executeAndExpectException("a", "c", "d");
        executeAndExpectException();
        executeAndExpectException("d");
    }

}