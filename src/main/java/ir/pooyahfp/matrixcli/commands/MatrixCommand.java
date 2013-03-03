/*
 * Copyright (c) 2013, Phsys and/or its affiliates. All rights reserved.
 *  Phsys PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package ir.pooyahfp.matrixcli.commands;

import ir.pooyahfp.matrixcli.matrix.MathObject;
import ir.pooyahfp.matrixcli.matrix.Matrix;

import java.util.List;

/**
* @author : Pooya husseini
 * Email : info@pooya-hfp.ir
 * Date: 1/23/13
 * Time: 2:18 PM
 */
public class MatrixCommand extends AbstractCommand {

    @Override
    public void execute(List<String> params, List<String> values) throws Exception {

        if (params.isEmpty()){
            throw new IllegalArgumentException("Matrix command without parameters.");
        }

        MathObject matrix;
        if (params.size() > 1) {
            int height = Integer.parseInt(params.get(1));
            int width = Integer.parseInt(params.get(2));

            matrix = new Matrix(height, width, params.get(0));
        } else {
            matrix = new Matrix(params.get(0));
        }
        createMathObject(matrix);
    }
}