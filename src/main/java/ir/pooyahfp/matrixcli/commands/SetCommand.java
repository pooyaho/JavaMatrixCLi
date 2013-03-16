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
 *         Date: 1/23/13
 *         Time: 2:10 PM
 */
public class SetCommand extends AbstractCommand {

    @Override
    public void execute(List<String> params, List<String> values)  {
        if (params.size() < 1 || params.size() > 3) {
            throw new IllegalArgumentException("Illegal arguments!");
        }
        String name = params.get(0);
        Integer row = null;
        Integer col = null;

        if (params.size() == 3) {
            row = params.get(1).isEmpty() ? null : Integer.parseInt(params.get(1)) - 1;
            col = params.get(2).isEmpty() ? null : Integer.parseInt(params.get(2)) - 1;
        }

        SimpleObject mathObject = getMathObject(name);
        double[] doubles = toDouble(values);
        mathObject = mathObject.setContent(row, col, doubles);

        updateMathObject(mathObject);
    }

    public double[] toDouble(List<String> list) {
        double[] doubles = new double[list.size()];

        for (int i = 0; i < list.size(); i++) {
            doubles[i] = Double.parseDouble(list.get(i));
        }
        return doubles;
    }
}