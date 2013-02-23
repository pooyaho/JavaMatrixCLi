/*
 * Copyright (c) 2013, Phsys and/or its affiliates. All rights reserved.
 *  Phsys PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package matrix.commands;

import matrix.Matrix;
import matrix.MatrixOperations;

import java.util.List;


public class SolveEquationCommand extends AbstractCommand {
    @Override
    public void execute(List<String> params, List<String> values) throws Exception {
        if (params.size() < 3)
            throw new IllegalArgumentException("Input should has 3 parameters");

        Matrix x = getMatrix(params.get(0));
        Matrix a = getMatrix(params.get(1));
        Matrix b = getMatrix(params.get(2));

        MatrixOperations.copy(x, a.invert().mul(b));

        persistMatrix(x);
    }
}
