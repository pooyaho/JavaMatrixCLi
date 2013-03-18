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
 *         Date: 2/20/13
 *         Time: 4:55 PM
 */
public class EchelonCommand extends AbstractCommand {

    @Override
    public void execute(List<String> params, List<String> values) {
        if (params.size() <= 0) {
            throw new IllegalCommandArguments();
        }

        switch (params.size()) {
            case 1:
                SimpleObject object = getMathObject(params.get(0));
                object = object.echelonForm();
                updateMathObject(object);
                break;
            case 2:
                object = getMathObject(params.get(1));
                SimpleObject temp = object.echelonForm();
                temp.setName(params.get(0));
                updateMathObject();
                break;
            default:
                throw new IllegalArgumentException("Illegal parameters");
        }
    }
}