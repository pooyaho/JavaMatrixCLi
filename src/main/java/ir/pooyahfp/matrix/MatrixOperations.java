/*
 * Copyright (c) 2013, Phsys and/or its affiliates. All rights reserved.
 *  Phsys PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package ir.pooyahfp.matrix;

/**
 * @author : Pooya husseini
 * Email : info@pooya-hfp.ir
 * Date: 1/26/13
 * Time: 10:58 AM
 */
public class MatrixOperations {

//    public static void copy(Matrix a, Matrix b) {
//        a=b.copy();
//    }

    public static void swap(Matrix a, Matrix b) {
        String temp = a.getName();
        a.setName(b.getName());
        b.setName(temp);
    }

    public static Matrix transpose(Matrix a) {
        return a.getTranspose();
    }
}