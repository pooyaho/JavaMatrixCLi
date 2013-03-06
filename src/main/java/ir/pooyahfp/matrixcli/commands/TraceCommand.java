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
 *         Date: 2/21/13
 *         Time: 2:48 PM
 */
public class TraceCommand extends AbstractCommand {
    @Override
    public void execute(List<String> params, List<String> values) throws Exception {
        if (params.size() < 1)
            throw new IllegalArgumentException("Illegal parameters");

        SimpleObject operand;

        if (params.size() == 1) {
            operand = getMathObject(params.get(0));
            getWriter().println(operand.getTrace());
        } else if (params.size() == 2) {
            operand = getMathObject(params.get(1));
            SimpleObject result = operand.getTrace();
            result.setName(params.get(0));
            updateMathObject(result);
        }
//        SimpleObject matrix =  getMathObject(params.get(0));
//        getWriter().println(matrix.getTrace());
    }
}