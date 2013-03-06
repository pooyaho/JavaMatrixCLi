/*
 * Copyright (c) 2013, Phsys and/or its affiliates. All rights reserved.
 *  Phsys PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package ir.pooyahfp.matrixcli.commands;

import ir.pooyahfp.matrixcli.matrix.MatrixObject;
import ir.pooyahfp.matrixcli.matrix.SimpleObject;

import java.util.List;

/**
 * @author : Pooya husseini
 *         Email : info@pooya-hfp.ir
 *         Date: 1/23/13
 *         Time: 2:18 PM
 */
public class MatrixCommand extends AbstractCommand {

    @Override
    public void execute(List<String> params, List<String> values) throws Exception {

        if (params.isEmpty()) {
            throw new IllegalArgumentException("Matrix command without parameters.");
        }

        SimpleObject simpleObject;

        if (params.size() > 1) {
            int height = Integer.parseInt(params.get(1));
            int width = Integer.parseInt(params.get(2));

            simpleObject = new MatrixObject(height, width, params.get(0));
        } else {
            simpleObject = new MatrixObject(params.get(0));
        }
        createMathObject(simpleObject);
    }
}