/*
 * Copyright (c) 2013, Phsys and/or its affiliates. All rights reserved.
 *  Phsys PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package ir.pooyahfp.matrixcli.matrix;

/**
 * @author : Pooya husseini
 *         Email : info@pooya-hfp.ir
 *         Date: 3/18/13
 *         Time: 5:05 PM
 */
public class OperationRuntimeException extends RuntimeException {

    public OperationRuntimeException() {
    }

    public OperationRuntimeException(String message) {
        super(message);
    }

    public OperationRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public OperationRuntimeException(Throwable cause) {
        super(cause);
    }

    public OperationRuntimeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}