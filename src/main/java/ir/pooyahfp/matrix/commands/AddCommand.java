/*
 * Copyright (c) 2013, Phsys and/or its affiliates. All rights reserved.
 *  Phsys PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package ir.pooyahfp.matrix.commands;

import ir.pooyahfp.matrix.Matrix;

import java.util.List;

/**
* @author : Pooya husseini
 * Email : info@pooya-hfp.ir
 * Date: 1/23/13
 * Time: 2:14 PM
 */
public class AddCommand extends AbstractCommand {

    @Override
    public void execute(List<String> params, List<String> values) throws Exception {
        if (params.size() < 2)
            throw new IllegalArgumentException("Input should has 2 or 3 parameters");

        Matrix matrix1;
        Matrix matrix2;
        Matrix resultMatrix = null;
        if (params.size() == 3) {

            matrix1 = getMatrix(params.get(1));
            matrix2 = getMatrix(params.get(2));
            resultMatrix = matrix1.add(matrix2);
            resultMatrix.setName(params.get(0));

        } else if (params.size() == 2) {
            matrix1 = getMatrix(params.get(0));
            matrix2 = getMatrix(params.get(1));
            resultMatrix = matrix1.add(matrix2);

            resultMatrix.setName(matrix1.getName());
        }

        persistMatrix(resultMatrix);

    }
}