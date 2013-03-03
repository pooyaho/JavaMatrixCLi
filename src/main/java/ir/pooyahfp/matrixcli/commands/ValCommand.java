/*
 * Copyright (c) 2013, Phsys and/or its affiliates. All rights reserved.
 *  Phsys PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package ir.pooyahfp.matrixcli.commands;

import ir.pooyahfp.matrixcli.matrix.MathObject;
import ir.pooyahfp.matrixcli.matrix.SimpleValue;

import java.util.List;

/**
 * @author : Pooya husseini
 *         Email : info@pooya-hfp.ir
 *         Date: 1/23/13
 *         Time: 2:18 PM
 */
public class ValCommand extends AbstractCommand {

    @Override
    public void execute(List<String> params, List<String> values) throws Exception {

        if (params.isEmpty()) {
            throw new IllegalArgumentException("Matrix command without parameters.");
        }

        MathObject value = null;
        if (params.size() == 2) {
            double val = Double.parseDouble(params.get(1));
            String name = params.get(0);
            value = new SimpleValue(name, val);
        } else if (params.size() == 1) {
            value = new SimpleValue(params.get(0),null);
        }

        createMathObject(value);
    }
}