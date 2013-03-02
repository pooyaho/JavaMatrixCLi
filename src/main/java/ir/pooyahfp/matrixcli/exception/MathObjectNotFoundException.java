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
public class MathObjectNotFoundException extends Exception {
    public MathObjectNotFoundException() {
    }

    public MathObjectNotFoundException(String message) {
        super(message);
    }

    public MathObjectNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public MathObjectNotFoundException(Throwable cause) {
        super(cause);
    }

    public MathObjectNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
