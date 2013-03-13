/*
 * Copyright (c) 2013, Phsys and/or its affiliates. All rights reserved.
 *  Phsys PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package ir.pooyahfp.matrixcli.commands;

import ir.pooyahfp.matrixcli.matrix.SaveLoadUtil;
import ir.pooyahfp.matrixcli.matrix.SimpleObject;

import java.util.List;

/**
 * @author : Pooya husseini
 *         Email : info@pooya-hfp.ir
 *         Date: 1/23/13
 *         Time: 2:08 PM
 */
public class ReadCommand extends AbstractCommand {

    @Override
    public void execute(List<String> params, List<String> values) throws Exception {
        if (params.size() != 2) {
            throw new IllegalArgumentException("Save should have 2 parameters");
        }
        String name = params.get(0);
        String path = params.get(1);

        SimpleObject simpleObject = (SimpleObject) SaveLoadUtil.readObject(path);
        simpleObject.setName(name);

        updateMathObject(simpleObject);
    }

}
