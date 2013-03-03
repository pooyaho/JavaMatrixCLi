/*
 * Copyright (c) 2013, Phsys and/or its affiliates. All rights reserved.
 *  Phsys PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package ir.pooyahfp.matrixcli.matrix;

/**
 * @author : Pooya husseini
 *         Email : info@pooya-hfp.ir
 *         Date: 3/2/13
 *         Time: 6:28 PM
 */
public interface MathObject {
    String toString();

    String getName() throws Exception;

    void setName(String name) throws Exception;

    MathObject getTranspose() throws Exception;

    double getDeterminant() throws Exception;

    MathObject getInvert() throws Exception;

    MathObject add(MathObject b) throws Exception;

    MathObject sub(MathObject b) throws Exception;

    MathObject mul(MathObject b) throws Exception;

    MathObject power(int c) throws Exception;

    void lu(MathObject l, MathObject u) throws Exception;

    MathObject echelonForm() throws Exception;

    int getRank() throws Exception;

    double getTrace() throws Exception;

    MathObject eigenValues() throws Exception;

    MathObject getIdentity() throws Exception;

    MathObject copy() throws Exception;

    MathObject cast(MathObject o) throws Exception;

    Matrix setContent(Integer row, Integer col, double[] content) throws Exception;
}