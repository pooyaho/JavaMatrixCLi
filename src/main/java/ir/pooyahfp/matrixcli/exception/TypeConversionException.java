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
public class TypeConversionException extends RuntimeException {
    public TypeConversionException() {
        super("Can not convert non matrix to matrix object!");
    }

    public TypeConversionException(String message) {
        super(message);
    }

    public TypeConversionException(String message, Throwable cause) {
        super(message, cause);
    }

    public TypeConversionException(Throwable cause) {
        super("Can not convert non matrix to matrix object!",cause);
    }
}
