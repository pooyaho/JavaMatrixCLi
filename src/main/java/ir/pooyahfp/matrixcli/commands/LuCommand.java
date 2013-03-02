/*
 * Copyright (c) 2013, Phsys and/or its affiliates. All rights reserved.
 *  Phsys PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package ir.pooyahfp.matrixcli.commands;

import ir.pooyahfp.matrixcli.matrix.Matrix;

import java.util.List;

public class LuCommand extends AbstractCommand {
    @Override
    public void execute(List<String> params, List<String> values) throws Exception {
        if (params.size() < 3)
            throw new IllegalArgumentException("Input should has 3 parameters");

        Matrix a = (Matrix) getMathObject(params.get(0));
        Matrix l = (Matrix) getMathObject(params.get(1));
        Matrix u = (Matrix) getMathObject(params.get(2));

        a.lu(l, u);

        updateMathObject(a, l, u);

    }
}