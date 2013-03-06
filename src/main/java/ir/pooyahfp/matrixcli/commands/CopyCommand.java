/*
 * Copyright (c) 2013, Phsys and/or its affiliates. All rights reserved.
 *  Phsys PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package ir.pooyahfp.matrixcli.commands;

import ir.pooyahfp.matrixcli.matrix.SimpleObject;

import java.util.List;

/**
 * @author : Pooya husseini
 *         Email : info@pooya-hfp.ir
 *         Date: 1/23/13
 *         Time: 2:15 PM
 */
public class CopyCommand extends AbstractCommand {
    @Override
    public void execute(List<String> params, List<String> values) throws Exception {

        if (params.size() < 2)
            throw new IllegalArgumentException("Copy should have 2 parameters");


        SimpleObject matrix2 = getMathObject(params.get(1));

        SimpleObject matrix1 = matrix2.copy();
        matrix1.setName(params.get(0));

        updateMathObject(matrix1, matrix2);
    }
}
