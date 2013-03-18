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
public class RuntimeClassNotFoundException extends RuntimeException {
    public RuntimeClassNotFoundException() {

    }

    public RuntimeClassNotFoundException(String message) {
        super(message);
    }

    public RuntimeClassNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public RuntimeClassNotFoundException(Throwable cause) {
        super(cause);
    }
}
