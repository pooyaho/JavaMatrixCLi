/*
 * Copyright (c) 2013, Phsys and/or its affiliates. All rights reserved.
 *  Phsys PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package ir.pooyahfp.matrixcli.commands;

import ir.pooyahfp.matrixcli.matrix.SimpleObject;

/**
 * @author : Pooya husseini
 *         Email : info@pooya-hfp.ir
 *         Date: 1/23/13
 *         Time: 2:13 PM
 */
public class InvertCommand extends AbstractUnaryOperation {
    @Override
    public SimpleObject operation(SimpleObject object) {
        return object.getInvert();
    }
//    @Override
//    public void execute(List<String> params, List<String> values)  {
//        if (params.size() < 1 || params.size() > 2) {
//            throw new IllegalCommandArguments();
//        }
//
//        SimpleObject simpleObject;
//        SimpleObject resultObject = null;
//        if (params.size() == 2) {
//            simpleObject = getMathObject(params.get(1));
//            resultObject = simpleObject.getInvert();
//            resultObject.setName(params.get(0));
//
//        } else if (params.size() == 1) {
//            simpleObject = getMathObject(params.get(0));
//            resultObject = simpleObject.getInvert();
//
//            resultObject.setName(simpleObject.getName());
//        }
//        updateMathObject(resultObject);
//    }
}
