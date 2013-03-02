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
public class DuplicateMatrixException extends Exception {
    public DuplicateMatrixException() {
    }

    public DuplicateMatrixException(String message) {
        super(message);
    }

    public DuplicateMatrixException(String message, Throwable cause) {
        super(message, cause);
    }

    public DuplicateMatrixException(Throwable cause) {
        super(cause);
    }

    public DuplicateMatrixException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
