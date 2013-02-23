/*
 * Copyright (c) 2013, Phsys and/or its affiliates. All rights reserved.
 *  Phsys PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package ir.pooyahfp.matrix.commands;

import ir.pooyahfp.matrix.Matrix;

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

    void persistMatrix(Matrix... args) {
        for (Matrix matrix : args)
            matrixMap.put(matrix.getName(), matrix);
    }

    Matrix getMatrix(String name) throws Exception {
        Matrix matrix = matrixMap.get(name);
        if (matrix == null)
            throw new Exception("Matrix " + name + " not found!");
        return matrixMap.get(name);
    }

    public static void setWriter(PrintWriter writer) {
        AbstractCommand.writer = writer;
    }

    PrintWriter getWriter() {
        return writer;
    }
}