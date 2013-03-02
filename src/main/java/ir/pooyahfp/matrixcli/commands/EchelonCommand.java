/*
 * Copyright (c) 2013, Phsys and/or its affiliates. All rights reserved.
 *  Phsys PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package ir.pooyahfp.matrixcli.commands;

import ir.pooyahfp.matrixcli.matrix.Matrix;

import java.util.List;

/**
 * @author : Pooya husseini
 *         Email : info@pooya-hfp.ir
 *         Date: 2/20/13
 *         Time: 4:55 PM
 */
public class EchelonCommand extends AbstractCommand {

    @Override
    public void execute(List<String> params, List<String> values) throws Exception {
        if (params.size() <= 0)
            throw new IllegalArgumentException("Illegal parameter");

        switch (params.size()) {
            case 1:
                Matrix matrix = getMatrix(params.get(0));
                matrix = matrix.echelonForm();
                persistMatrix(matrix);
                break;
            case 2:
                matrix = getMatrix(params.get(1));
                Matrix temp = matrix.echelonForm();
                temp.setName(params.get(0));
                persistMatrix();
                break;
            default:
                throw new IllegalArgumentException("Illegal parameters");
        }
    }
}