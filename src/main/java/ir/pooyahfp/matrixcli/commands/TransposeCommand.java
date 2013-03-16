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
 *         Time: 2:14 PM
 */
public class TransposeCommand extends AbstractCommand {

    @Override
    public void execute(List<String> params, List<String> values) {
        if (params.size() < 1) {
            throw new IllegalArgumentException("Invalid parameters");
        }

        SimpleObject simpleObject;
        SimpleObject resultMatrix = null;
        if (params.size() == 2) {

            simpleObject = getMathObject(params.get(1));
            resultMatrix = simpleObject.getTranspose();
            resultMatrix.setName(params.get(0));

        } else if (params.size() == 1) {
            simpleObject = getMathObject(params.get(0));
            resultMatrix = simpleObject.getTranspose();

            resultMatrix.setName(simpleObject.getName());
        }
        updateMathObject(resultMatrix);

    }

}

