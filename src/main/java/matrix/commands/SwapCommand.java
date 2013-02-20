/*
 * Copyright (c) 2013, Phsys and/or its affiliates. All rights reserved.
 *  Phsys PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package matrix.commands;

import matrix.Matrix;
import matrix.MatrixOperations;

import java.util.List;

/**
 * @author : Pooya husseini
 *         Email : info@pooya-hfp.ir
 *         Date: 1/23/13
 *         Time: 2:14 PM
 */
public class SwapCommand extends AbstractCommand {

    @Override
    public void execute(List<String> params) throws Exception {
        if (params.size() < 2)
            throw new IllegalArgumentException("Input should has 2 parameters");

        Matrix matrix1 = getMatrix(params.get(0));
        Matrix matrix2 = getMatrix(params.get(1));

        MatrixOperations.swap(matrix1, matrix2);

        persistMatrix(matrix1, matrix2);
    }
}