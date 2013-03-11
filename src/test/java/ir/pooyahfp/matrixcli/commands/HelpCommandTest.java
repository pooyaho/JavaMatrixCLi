/*
 * Copyright (c) 2013, Phsys and/or its affiliates. All rights reserved.
 *  Phsys PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package ir.pooyahfp.matrixcli.commands;

import org.junit.Test;

/**
 * @author : Pooya husseini
 *         Email : info@pooya-hfp.ir
 *         Date: 3/9/13
 *         Time: 4:01 PM
 */
@Command(targetClass = HelpCommand.class)
public class HelpCommandTest extends AbstractCommandTest {
    public HelpCommandTest() throws Exception {
    }

    @Test
    public void  testHelpCommand() throws Exception {
        executeWithOperands("add","sub","OOOOO");
    }

}
