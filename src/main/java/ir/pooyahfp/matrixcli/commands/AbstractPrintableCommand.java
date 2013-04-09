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
 *         Date: 4/8/13
 *         Time: 4:08 PM
 */
public abstract class AbstractPrintableCommand extends AbstractCommand {
    @Override
    public void execute(@NotNull List<String> params, List<String> values) throws IllegalAccessException, InstantiationException {
        if (params.size() < 1 || params.size() > 2) {
            throw new IllegalCommandArguments();
        }

        SimpleObject operand;

        if (params.size() == 1) {
            operand = getMathObject(params.get(0));
            getWriter().println(operation(operand));
        } else if (params.size() == 2) {
            operand = getMathObject(params.get(1));
            SimpleObject result = operation(operand);
            result.setName(params.get(0));
            updateMathObject(result);
        }
    }

    @NotNull
    protected abstract SimpleObject operation(SimpleObject simpleObject);
}
