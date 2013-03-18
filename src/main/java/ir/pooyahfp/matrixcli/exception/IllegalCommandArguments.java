/*
 * Copyright (c) 2013, Phsys and/or its affiliates. All rights reserved.
 *  Phsys PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package ir.pooyahfp.matrixcli.exception;

/**
 * @author : Pooya husseini
 *         Email : info@pooya-hfp.ir
 *         Date: 3/18/13
 *         Time: 4:26 PM
 */
public class IllegalCommandArguments extends IllegalArgumentException {
    public IllegalCommandArguments() {
        super("Illegal command arguments! see usage of the command for more information.");
    }

    public IllegalCommandArguments(String s) {
        super(s);
    }


    public IllegalCommandArguments(String message, Throwable cause) {
        super(message, cause);
    }


    public IllegalCommandArguments(Throwable cause) {
        super("Illegal command arguments! see usage of the command for more information.", cause);
    }
}
