/*
 * Copyright (c) 2013, Phsys and/or its affiliates. All rights reserved.
 *  Phsys PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package ir.pooyahfp.matrixcli.exception;

/**
 * @author : Pooya husseini
 *         Email : info@pooya-hfp.ir
 *         Date: 3/16/13
 *         Time: 7:04 PM
 */
public class NonDecomposableMatrixException extends RuntimeException {

    public NonDecomposableMatrixException() {
    }

    public NonDecomposableMatrixException(String message) {
        super(message);
    }

    public NonDecomposableMatrixException(String message, Throwable cause) {
        super(message, cause);
    }

    public NonDecomposableMatrixException(Throwable cause) {
        super(cause);
    }

    public NonDecomposableMatrixException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
