/*
 * Copyright (c) 2013, Phsys and/or its affiliates. All rights reserved.
 *  Phsys PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package ir.pooyahfp.matrix.commands;

import ir.pooyahfp.matrix.Matrix;

import java.util.List;

/**
 * @author : Pooya husseini
 *         Email : info@pooya-hfp.ir
 *         Date: 2/21/13
 *         Time: 2:48 PM
 */
public class TraceCommand extends AbstractCommand {
    @Override
    public void execute(List<String> params, List<String> values) throws Exception {
        if (params.size() != 1)
            throw new IllegalArgumentException("Illegal parameters");

        Matrix matrix = getMatrix(params.get(0));
        getWriter().println(matrix.getTrace());

    }
}
