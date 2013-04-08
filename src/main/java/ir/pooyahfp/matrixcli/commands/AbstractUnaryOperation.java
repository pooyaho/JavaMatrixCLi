/*
 * Copyright (c) 2013, Phsys and/or its affiliates. All rights reserved.
 *  Phsys PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package ir.pooyahfp.matrixcli.commands;

import ir.pooyahfp.matrixcli.exception.IllegalCommandArguments;
import ir.pooyahfp.matrixcli.matrix.SimpleObject;

import java.util.List;

/**
 * @author : Pooya husseini
 *         Email : info@pooya-hfp.ir
 *         Date: 4/8/13
 *         Time: 4:45 PM
 */
public abstract class AbstractUnaryOperation extends AbstractCommand {
    @Override
    public void execute(List<String> params, List<String> values) throws IllegalAccessException, InstantiationException {
        if (params.size() < 1 || params.size() > 2) {
            throw new IllegalCommandArguments();
        }

        SimpleObject simpleObject;
        SimpleObject resultObject = null;
        if (params.size() == 2) {
            simpleObject = getMathObject(params.get(1));
            resultObject = operation(simpleObject);
            resultObject.setName(params.get(0));

        } else if (params.size() == 1) {
            simpleObject = getMathObject(params.get(0));
            resultObject = operation(simpleObject);

            resultObject.setName(simpleObject.getName());
        }
        updateMathObject(resultObject);
    }

    public abstract SimpleObject operation(SimpleObject object);
}
