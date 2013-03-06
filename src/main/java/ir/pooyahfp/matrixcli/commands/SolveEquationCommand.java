/*
 * Copyright (c) 2013, Phsys and/or its affiliates. All rights reserved.
 *  Phsys PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package ir.pooyahfp.matrixcli.commands;

import ir.pooyahfp.matrixcli.matrix.SimpleObject;

import java.util.List;


public class SolveEquationCommand extends AbstractCommand {
    @Override
    public void execute(List<String> params, List<String> values) throws Exception {
        if (params.size() < 3)
            throw new IllegalArgumentException("Input should has 3 parameters");


        SimpleObject a = getMathObject(params.get(1));
        SimpleObject b = getMathObject(params.get(2));

        SimpleObject x = a.getInvert().mul(b).copy();
        x.setName(params.get(0));

        updateMathObject(x);
    }
}
