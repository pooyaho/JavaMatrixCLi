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
public class SourceTypeException extends RuntimeException {
    public SourceTypeException() {
        super("Objects do not have the same types!");
    }

    public SourceTypeException(String message) {
        super(message);
    }

    public SourceTypeException(String message, Throwable cause) {
        super(message, cause);
    }

    public SourceTypeException(Throwable cause) {
        super("Objects do not have the same types!",cause);
    }
}
