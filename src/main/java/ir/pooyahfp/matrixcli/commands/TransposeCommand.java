/*
 * Copyright (c) 2013, Phsys and/or its affiliates. All rights reserved.
 *  Phsys PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package ir.pooyahfp.matrixcli.commands;

import ir.pooyahfp.matrixcli.matrix.Matrix;

import java.util.List;

/**
 *
* @author : Pooya husseini
 * Email : info@pooya-hfp.ir
 * Date: 1/23/13
 * Time: 2:14 PM
 */
public class TransposeCommand extends AbstractCommand {

    @Override
    public void execute(List<String> params, List<String> values) throws Exception {
        if (params.size() < 1)
            throw new IllegalArgumentException("Invalid parameters");

        Matrix matrix1;
        Matrix resultMatrix = null;
        if (params.size() == 2) {

            matrix1 = (Matrix) getMathObject(params.get(1));
            resultMatrix = matrix1.getTranspose();
            resultMatrix.setName(params.get(0));

        } else if (params.size() == 1) {
            matrix1 = (Matrix) getMathObject(params.get(0));
            resultMatrix = matrix1.getTranspose();

            resultMatrix.setName(matrix1.getName());
        }
        updateMathObject(resultMatrix);

    }

}

