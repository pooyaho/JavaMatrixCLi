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
 *         Date: 3/27/13
 *         Time: 5:56 PM
 */
@Command(targetClass = ValCommand.class)
public class ValCommandTest extends AbstractCommandTest {
    @Test
    public void createValue() throws IllegalAccessException, InstantiationException {
        executeWithOperands("z", "3");
        Assert.assertTrue(hasMathObject("z"));
        SimpleObject z = getMathObject("z");
        Assert.assertEquals(z.doubleValue(), 3, 0);
    }

    @Test
    public void testNonCorrectParameters() throws IllegalAccessException, InstantiationException {
       executeAndExpectException("z","z");
       executeWithOperands("z");
       executeAndExpectException();
       executeAndExpectException("a");
       executeAndExpectException("z","3","2");

    }
}
