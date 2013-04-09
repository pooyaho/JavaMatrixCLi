/*
 * Copyright (c) 2013, Phsys and/or its affiliates. All rights reserved.
 *  Phsys PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package ir.pooyahfp.matrixcli.commands;

import ir.pooyahfp.matrixcli.exception.IllegalCommandArguments;
import ir.pooyahfp.matrixcli.matrix.SimpleObject;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * @author : Pooya husseini
 *         Email : info@pooya-hfp.ir
 *         Date: 1/23/13
 *         Time: 2:15 PM
 */
public class CopyCommand extends AbstractCommand {

    @Override
    public void execute(@NotNull List<String> params, List<String> values) {

        if (params.size() != 2) {
            throw new IllegalCommandArguments();
        }

        SimpleObject object2 = getMathObject(params.get(1));

        SimpleObject object1 = object2.copy();
        object1.setName(params.get(0));

        updateMathObject(object1, object2);
    }
}
