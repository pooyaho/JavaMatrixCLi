/*
 * Copyright (c) 2013, Phsys and/or its affiliates. All rights reserved.
 *  Phsys PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package ir.pooyahfp.matrixcli.commands;

import ir.pooyahfp.matrixcli.exception.IllegalCommandArguments;
import ir.pooyahfp.matrixcli.matrix.SimpleObject;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class LuCommand extends AbstractCommand {
    @Override
    public void execute(@NotNull List<String> params, List<String> values) {
        if (params.size() < 3) {
            throw new IllegalCommandArguments();
        }

        SimpleObject a = getMathObject(params.get(0));
        SimpleObject l = getMathObject(params.get(1));
        SimpleObject u = getMathObject(params.get(2));

        a.lu(l, u);

        updateMathObject(a, l, u);

    }
}