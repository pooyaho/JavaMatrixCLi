/*
 * Copyright (c) 2013, Phsys and/or its affiliates. All rights reserved.
 *  Phsys PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package ir.pooyahfp.matrixcli.commands;

import ir.pooyahfp.matrixcli.matrix.SimpleObject;
import ir.pooyahfp.matrixcli.matrix.MatrixOperations;

import java.util.List;

/**
 * @author : Pooya husseini
 *         Email : info@pooya-hfp.ir
 *         Date: 1/23/13
 *         Time: 2:14 PM
 */
public class SwapCommand extends AbstractCommand {

    @Override
    public void execute(List<String> params, List<String> values) throws Exception {
        if (params.size() < 2)
            throw new IllegalArgumentException("Input should has 2 parameters");

        SimpleObject matrix1 =  getMathObject(params.get(0));
        SimpleObject matrix2 =  getMathObject(params.get(1));

        MatrixOperations.swap(matrix1, matrix2);

        updateMathObject(matrix1, matrix2);
    }
}