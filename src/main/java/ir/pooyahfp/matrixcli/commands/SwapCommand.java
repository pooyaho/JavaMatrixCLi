/*
 * Copyright (c) 2013, Phsys and/or its affiliates. All rights reserved.
 *  Phsys PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package ir.pooyahfp.matrixcli.commands;

import ir.pooyahfp.matrixcli.exception.IllegalCommandArguments;
import ir.pooyahfp.matrixcli.matrix.MatrixOperations;
import ir.pooyahfp.matrixcli.matrix.SimpleObject;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * @author : Pooya husseini
 *         Email : info@pooya-hfp.ir
 *         Date: 1/23/13
 *         Time: 2:14 PM
 */
public class SwapCommand extends AbstractCommand {

    @Override
    public void execute(@NotNull List<String> params, List<String> values)  {
        if (params.size() != 2) {
            throw new IllegalCommandArguments();
        }

        SimpleObject mathObject1 = getMathObject(params.get(0));
        SimpleObject mathObject2 = getMathObject(params.get(1));

        MatrixOperations.swap(mathObject1, mathObject2);

        updateMathObject(mathObject1, mathObject2);
    }
}