/*
 * Copyright (c) 2013, Phsys and/or its affiliates. All rights reserved.
 *  Phsys PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package ir.pooyahfp.matrixcli.commands;

import ir.pooyahfp.matrixcli.matrix.MathObject;

import java.util.List;

/**
 * @author : Pooya husseini
 *         Email : info@pooya-hfp.ir
 *         Date: 1/23/13
 *         Time: 2:14 PM
 */
public class AddCommand extends AbstractCommand {

    @Override
    public void execute(List<String> params, List<String> values) throws Exception {
        if (params.size() < 2)
            throw new IllegalArgumentException("Input should has 2 or 3 parameters");

        MathObject matrix1;
        MathObject matrix2;
        MathObject resultMatrix = null;
        if (params.size() == 3) {

            matrix1 = getMathObject(params.get(1));
            matrix2 = getMathObject(params.get(2));
            resultMatrix = matrix1.add(matrix2);
            resultMatrix.setName(params.get(0));

        } else if (params.size() == 2) {
            matrix1 = getMathObject(params.get(0));
            matrix2 = getMathObject(params.get(1));
            resultMatrix = matrix1.add(matrix2);

            resultMatrix.setName(matrix1.getName());
        }

        updateMathObject(resultMatrix);

    }
}