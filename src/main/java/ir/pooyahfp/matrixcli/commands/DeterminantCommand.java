/*
 * Copyright (c) 2013, Phsys and/or its affiliates. All rights reserved.
 *  Phsys PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package ir.pooyahfp.matrixcli.commands;

import ir.pooyahfp.matrixcli.matrix.SimpleObject;

import java.util.List;

/**
 * @author : Pooya husseini
 *         Email : info@pooya-hfp.ir
 *         Date: 2/19/13
 *         Time: 5:35 PM
 */
public class DeterminantCommand extends AbstractCommand {

    @Override
    public void execute(List<String> params, List<String> values)  {
        if (params.size() <= 0 || params.size() > 2) {
            throw new IllegalArgumentException("Input should have one or two parameters!");
        }

        SimpleObject operand;

        if (params.size() == 1) {
            operand = getMathObject(params.get(0));
            getWriter().println(operand.getDeterminant());
        } else if (params.size() == 2) {
            operand = getMathObject(params.get(1));
            SimpleObject result = operand.getDeterminant();
            result.setName(params.get(0));
            updateMathObject(result);
        }
    }
}
