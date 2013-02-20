/*
 * Copyright (c) 2013, Phsys and/or its affiliates. All rights reserved.
 *  Phsys PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package matrix.commands;

import matrix.Matrix;

import java.util.List;

/**
* @author : Pooya husseini
 * Email : info@pooya-hfp.ir
 * Date: 1/23/13
 * Time: 2:18 PM
 */
public class CreateCommand extends AbstractCommand {
    @Override
    public void execute(List<String> params) throws Exception {

        if (params.isEmpty()){
            throw new IllegalArgumentException("Matrix command without parameters.");
        }

        Matrix matrix;
        if (params.size() > 1) {
            int height = Integer.parseInt(params.get(1));
            int width = Integer.parseInt(params.get(2));

            matrix = new Matrix(height, width, params.get(0));
        } else {
            matrix = new Matrix(params.get(0));
        }
        persistMatrix(matrix);
    }
}