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
 *         Time: 2:14 PM
 */
public class AddCommand extends AbstractBinaryOperation {
    @Override
    public SimpleObject operation(SimpleObject a, SimpleObject b) {
        return a.add(b);
    }

//    @Override
//    public void execute(List<String> params, List<String> values) {
//        if (params.size() < 2 || params.size() > 3) {
//            throw new IllegalCommandArguments();
//        }
//
//        SimpleObject object1;
//        SimpleObject object2;
//        SimpleObject resultObject = null;
//        if (params.size() == 3) {
//
//            object1 = getMathObject(params.get(1));
//            object2 = getMathObject(params.get(2));
//            resultObject = object1.add(object2);
//            resultObject.setName(params.get(0));
//
//        } else if (params.size() == 2) {
//            object1 = getMathObject(params.get(0));
//            object2 = getMathObject(params.get(1));
//            resultObject = object1.add(object2);
//
//            resultObject.setName(object1.getName());
//        }
//        updateMathObject(resultObject);
//    }

}