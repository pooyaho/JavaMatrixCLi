/*
 * Copyright (c) 2013, Phsys and/or its affiliates. All rights reserved.
 *  Phsys PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package ir.pooyahfp.matrixcli.matrix;

import org.jetbrains.annotations.NotNull;

/**
 * This class contains the operation on multiple matrices
 *
 * @author : Pooya husseini
 *         Email : info@pooya-hfp.ir
 *         Date: 1/26/13
 *         Time: 10:58 AM
 */
public final class MatrixOperations {
    private MatrixOperations() {

    }

    /**
     * It swaps two given matrices,
     * @param a The first matrix
     * @param b The second one
     */
    public static void swap(@NotNull SimpleObject a, @NotNull SimpleObject b)  {

        String temp = a.getName();
        a.setName(b.getName());
        b.setName(temp);

    }
}