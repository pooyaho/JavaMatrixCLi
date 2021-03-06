/*
 * Copyright (c) 2013, Phsys and/or its affiliates. All rights reserved.
 *  Phsys PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package ir.pooyahfp.matrixcli.commands;

import org.junit.Test;

/**
 * @author : Pooya husseini
 *         Email : info@pooya-hfp.ir
 *         Date: 3/7/13
 *         Time: 3:41 PM
 */
@Command(targetClass = DeleteCommand.class)
public class DeleteCommandTest extends AbstractCommandTest {

    public DeleteCommandTest()  {

    }

    @Test
    public void testDeleteItems() throws IllegalAccessException, InstantiationException {
        executeWithOperands("a", "b");

        if (hasMathObject("a") || hasMathObject("b")) {
            throw new RuntimeException("Hey, They are alive!");
        }
    }

    @Test
    public void testDeleteWithoutOperands()  {
        executeAndExpectException();
    }
}