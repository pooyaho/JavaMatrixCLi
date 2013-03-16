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
 *         Time: 2:12 PM
 */
public class SubCommand extends AbstractCommand {
    @Override
    public void execute(List<String> params, List<String> values)  {
        if (params.size() < 2 || params.size() > 3) {
            throw new IllegalArgumentException("Input should has 2 or 3 parameters");
        }

        SimpleObject simpleObject1;
        SimpleObject simpleObject2;
        SimpleObject resultMatrix = null;
        if (params.size() == 3) {

            simpleObject1 = getMathObject(params.get(1));
            simpleObject2 = getMathObject(params.get(2));
            resultMatrix = simpleObject1.sub(simpleObject2);
            resultMatrix.setName(params.get(0));

        } else if (params.size() == 2) {
            simpleObject1 = getMathObject(params.get(0));
            simpleObject2 = getMathObject(params.get(1));
            resultMatrix = simpleObject1.sub(simpleObject2);

            resultMatrix.setName(simpleObject1.getName());
        }
        updateMathObject(resultMatrix);
    }
}