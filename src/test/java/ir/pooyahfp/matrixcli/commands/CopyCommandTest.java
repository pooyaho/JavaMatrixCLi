/*
 * Copyright (c) 2013, Phsys and/or its affiliates. All rights reserved.
 *  Phsys PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package ir.pooyahfp.matrixcli.commands;

import ir.pooyahfp.matrixcli.matrix.MatrixObject;
import ir.pooyahfp.matrixcli.matrix.SimpleObject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * @author : Pooya husseini
 *         Email : info@pooya-hfp.ir
 *         Date: 3/7/13
 *         Time: 3:05 PM
 */
public class CopyCommandTest extends AbstractCommandTest {
    public CopyCommandTest() throws Exception {
    }

    @Before
    public void cleanup() throws Exception {
        fillMap();
    }

    @Test
    public void testCopyTwoMatrices() throws Exception {
        executeWithOperands("a", "b");

        MatrixObject a = (MatrixObject) getMathObject("a");
        MatrixObject b = (MatrixObject) getMathObject("b");
        Assert.assertArrayEquals(a.getContent()[0], b.getContent()[0], 0);
        Assert.assertArrayEquals(a.getContent()[1], b.getContent()[1], 0);
        Assert.assertArrayEquals(a.getContent()[2], b.getContent()[2], 0);
    }

    @Test
    public void testCopyTwoNotSameSizedMatrices() throws Exception {
        executeWithOperands("a", "c");

        MatrixObject a = (MatrixObject) getMathObject("a");
        MatrixObject c = (MatrixObject) getMathObject("c");

        Assert.assertArrayEquals(a.getContent()[0], c.getContent()[0], 0);
        Assert.assertArrayEquals(a.getContent()[1], c.getContent()[1], 0);

    }

    @Test
    public void testCopyTwoValues() throws Exception {
        executeWithOperands("d", "e");

        SimpleObject d = getMathObject("d");
        SimpleObject e = getMathObject("e");
        Assert.assertEquals(d.doubleValue(), e.doubleValue(), 0);
    }

    @Test
    public void testCopyValueAndOtherTypes() throws Exception {
        executeWithOperands("a", "e");

        SimpleObject a = getMathObject("a");
        SimpleObject e = getMathObject("e");
        Assert.assertEquals(a.doubleValue(), e.doubleValue(), 0);
    }

    @Test
    public void testCopyOtherTypeAndValue() throws Exception {
        executeWithOperands("e", "a");

        MatrixObject e = (MatrixObject) getMathObject("e");
        MatrixObject a = (MatrixObject) getMathObject("a");
        for (int i = 0; i < a.getHeight(); i++) {
            Assert.assertArrayEquals(e.getContent()[i], a.getContent()[i], 0);
        }
    }

    @Override
    public void execute(List<String> params, List<String> values) throws Exception {
        AbstractCommand addCommand = new CopyCommand();
        addCommand.execute(params, values);
    }
}
