/*
 * Copyright (c) 2013, Phsys and/or its affiliates. All rights reserved.
 *  Phsys PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package ir.pooyahfp.matrixcli.commands;

import ir.pooyahfp.matrixcli.matrix.Matrix;

import java.util.List;


public class SolveEquationCommand extends AbstractCommand {
    @Override
    public void execute(List<String> params, List<String> values) throws Exception {
        if (params.size() < 3)
            throw new IllegalArgumentException("Input should has 3 parameters");


        Matrix a = (Matrix) getMathObject(params.get(1));
        Matrix b = (Matrix) getMathObject(params.get(2));

        Matrix x=a.getInvert().mul(b).copy();
        x.setName(params.get(0));

        updateMathObject(x);
    }
}
