/*
 * Copyright (c) 2013, Phsys and/or its affiliates. All rights reserved.
 *  Phsys PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package ir.pooyahfp.matrixcli.exception;

/**
 * @author : Pooya husseini
 *         Email : info@pooya-hfp.ir
 *         Date: 2/27/13
 *         Time: 5:06 PM
 */
public class DuplicateMathObjectException extends RuntimeException {
    public DuplicateMathObjectException() {
        super("Object has already defined!");
    }

    public DuplicateMathObjectException(String message) {
        super(message);
    }

    public DuplicateMathObjectException(String message, Throwable cause) {
        super(message, cause);
    }

    public DuplicateMathObjectException(Throwable cause) {
        super("Object has already defined!",cause);
    }
}
