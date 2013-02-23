/*
 * Copyright (c) 2013, Phsys and/or its affiliates. All rights reserved.
 *  Phsys PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package ir.pooyahfp.matrix.commands;

import ir.pooyahfp.matrix.Matrix;
import ir.pooyahfp.matrix.MatrixOperations;

import java.util.List;

/**
* @author : Pooya husseini
 * Email : info@pooya-hfp.ir
 * Date: 1/23/13
 * Time: 2:15 PM
 */
public class CopyCommand extends AbstractCommand {
    @Override
    public void execute(List<String> params, List<String> values) throws Exception {

        if (params.size() < 2)
            throw new IllegalArgumentException("Copy should have 2 parameters");

        Matrix matrix1 = getMatrix(params.get(0));
        Matrix matrix2 = getMatrix(params.get(1));

        MatrixOperations.copy(matrix1, matrix2);

        persistMatrix(matrix1, matrix2);
    }
}
