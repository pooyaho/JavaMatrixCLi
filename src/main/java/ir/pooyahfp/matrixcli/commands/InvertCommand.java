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
 *         Time: 2:13 PM
 */
public class InvertCommand extends AbstractCommand {
    @Override
    public void execute(List<String> params, List<String> values) throws Exception {
        if (params.size() < 1 || params.size() > 2) {
            throw new IllegalArgumentException("Invalid parameters");
        }

        SimpleObject simpleObject;
        SimpleObject resultObject = null;
        if (params.size() == 2) {
            simpleObject = getMathObject(params.get(1));
            resultObject = simpleObject.getInvert();
            resultObject.setName(params.get(0));

        } else if (params.size() == 1) {
            simpleObject = getMathObject(params.get(0));
            resultObject = simpleObject.getInvert();

            resultObject.setName(simpleObject.getName());
        }
        updateMathObject(resultObject);
    }
}
