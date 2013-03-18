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
public class NonSquareMatrixException extends RuntimeException {
    public NonSquareMatrixException() {
        super("Matrix should be square matrix!");
    }

    public NonSquareMatrixException(String message) {
        super(message);
    }

    public NonSquareMatrixException(String message, Throwable cause) {
        super(message, cause);
    }

    public NonSquareMatrixException(Throwable cause) {
        super("Matrix should be square matrix!",cause);
    }

    public NonSquareMatrixException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
