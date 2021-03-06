/*
 * Copyright (c) 2013, Phsys and/or its affiliates. All rights reserved.
 *  Phsys PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package ir.pooyahfp.matrixcli.commands;

import ir.pooyahfp.matrixcli.exception.IllegalCommandArguments;
import ir.pooyahfp.matrixcli.matrix.SaveLoadUtil;
import ir.pooyahfp.matrixcli.matrix.SimpleObject;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * @author : Pooya husseini
 *         Email : info@pooya-hfp.ir
 *         Date: 1/23/13
 *         Time: 2:08 PM
 */
public class ReadCommand extends AbstractCommand {

    @Override
    public void execute(@NotNull List<String> params, List<String> values) {
        if (params.size() != 2) {
            throw new IllegalCommandArguments();
        }
        String name = params.get(0);
        String path = params.get(1);

        SimpleObject simpleObject;
        simpleObject = (SimpleObject) SaveLoadUtil.readObject(path);

        simpleObject.setName(name);

        updateMathObject(simpleObject);
    }

}
