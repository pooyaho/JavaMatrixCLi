/*
 * Copyright (c) 2013, Phsys and/or its affiliates. All rights reserved.
 *  Phsys PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package ir.pooyahfp.matrix.commands;

import ir.pooyahfp.matrix.Matrix;

import java.util.List;

public class LuCommand extends AbstractCommand {
    @Override
    public void execute(List<String> params, List<String> values) throws Exception {
        if (params.size() < 3)
            throw new IllegalArgumentException("Input should has 3 parameters");

        Matrix a = getMatrix(params.get(0));
        Matrix l = getMatrix(params.get(1));
        Matrix u = getMatrix(params.get(2));

        a.lu(l, u);

        persistMatrix(a, l, u);

    }
}