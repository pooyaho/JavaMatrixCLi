/*
 * Copyright (c) 2013, Phsys and/or its affiliates. All rights reserved.
 *  Phsys PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package ir.pooyahfp.matrix.commands;

import ir.pooyahfp.matrix.Matrix;
import ir.pooyahfp.matrix.exception.MatrixNotFoundException;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : Pooya husseini
 *         Email : info@pooya-hfp.ir
 *         Date: 1/23/13
 *         Time: 1:59 PM
 */
public abstract class AbstractCommand {


    private static PrintWriter writer;

    public abstract void execute(List<String> params,List<String> values) throws Exception;

    private final static Map<String, Matrix> matrixMap = new HashMap<String, Matrix>();

    /**
     * Persist the given matrices. it stores them in a map that the key is the matrix name and the value is the
     * matrix object.
     * @param args The vararg of the matrices
     */
    void persistMatrix(Matrix... args) {
        for (Matrix matrix : args)
            matrixMap.put(matrix.getName(), matrix);
    }

    /**
     * Returns the matrix with given name. if it does not find the matrix throws MatrixNotFoundException
     * @param name The matrix name
     * @return The object of matrix that stored in the map
     * @throws MatrixNotFoundException
     */
    Matrix getMatrix(String name) throws MatrixNotFoundException {
        Matrix matrix = matrixMap.get(name);
        if (matrix == null)
            throw new MatrixNotFoundException("Matrix " + name + " not found!");
        return matrixMap.get(name);
    }


    public static void setWriter(PrintWriter writer) {
        AbstractCommand.writer = writer;
    }

    /**
     * Returns the print writer that you can print with it in the defined console
     * @return the writer
     */
    PrintWriter getWriter() {
        return writer;
    }
}