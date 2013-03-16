/*
 * Copyright (c) 2013, Phsys and/or its affiliates. All rights reserved.
 *  Phsys PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package ir.pooyahfp.matrixcli.commands;

import org.junit.Test;

/**
 * @author : Pooya husseini
 *         Email : info@pooya-hfp.ir
 *         Date: 3/16/13
 *         Time: 5:54 PM
 */
@Command(targetClass = TransposeCommand.class)
public class TransposeCommandTest extends AbstractCommandTest {
    public TransposeCommandTest()  {

    }

    @Test
    public void testTranspose() throws IllegalAccessException, InstantiationException {
        executeWithOperands("a");
    }
}
