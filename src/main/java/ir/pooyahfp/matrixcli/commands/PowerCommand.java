/*
 * Copyright (c) 2013, Phsys and/or its affiliates. All rights reserved.
 *  Phsys PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package ir.pooyahfp.matrixcli.commands;

import ir.pooyahfp.matrixcli.matrix.MathObject;

import java.util.List;

/**
 * @author : Pooya husseini
 *         Email : info@pooya-hfp.ir
 *         Date: 1/23/13
 *         Time: 2:12 PM
 */
public class PowerCommand extends AbstractCommand {

    @Override
    public void execute(List<String> params, List<String> values) throws Exception {
        if (params.size() < 2)
            throw new IllegalArgumentException("Input should has 2 or 3 parameters");

        MathObject matrix1;
        int pow;
        MathObject resultMatrix = null;
        if (params.size() == 3) {

            matrix1 = getMathObject(params.get(1));

            if (hasMathObject(params.get(2))) {
                MathObject mathObject = getMathObject(params.get(2));
                resultMatrix = matrix1.power(mathObject);
            } else {

                pow = Integer.parseInt(params.get(2));
                resultMatrix = matrix1.power(pow);
            }

            resultMatrix.setName(params.get(0));

        } else if (params.size() == 2) {
            matrix1 = getMathObject(params.get(0));

            if (hasMathObject(params.get(1))) {
                MathObject mathObject = getMathObject(params.get(1));
                resultMatrix = matrix1.power(mathObject);
            } else {

                pow = Integer.parseInt(params.get(1));
                resultMatrix = matrix1.power(pow);
            }
//            pow = Integer.parseInt(params.get(1));

//            resultMatrix = matrix1.power(pow);

            resultMatrix.setName(matrix1.getName());
        }
        updateMathObject(resultMatrix);
    }
}