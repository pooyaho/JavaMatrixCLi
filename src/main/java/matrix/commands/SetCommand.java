/*
 * Copyright (c) 2013, Phsys and/or its affiliates. All rights reserved.
 *  Phsys PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package matrix.commands;

import matrix.Matrix;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
* @author : Pooya husseini
 * Email : info@pooya-hfp.ir
 * Date: 1/23/13
 * Time: 2:10 PM
 */
public class SetCommand extends AbstractCommand {

    @Override
    public void execute(List<String> params) throws Exception {
        String name = params.remove(0);
        StringTokenizer tokenizer = new StringTokenizer(name, " {}");

        Integer row = null;
        Integer col = null;

        if (tokenizer.hasMoreElements()) {
            name = (String) tokenizer.nextElement();

            List<String> dims = extractDimensions(name);
            if (dims.size() > 0) {
                name = dims.get(0);
                if (dims.get(1) != null)
                    row = Integer.valueOf(dims.get(1)) - 1;
                if (dims.get(2) != null)
                    col = Integer.parseInt(dims.get(2)) - 1;
            }

            Matrix matrix = getMatrix(name);
            double[] doubles = toDouble(params);
            matrix.setContent(row, col, doubles);
        }
    }

    public double[] toDouble(List<String> list) {
        double[] doubles = new double[list.size()];


        for (int i = 0; i < list.size(); i++) {
            doubles[i] = Double.parseDouble(list.get(i));
        }
        return doubles;
    }

    public List<String> extractDimensions(String s) {
        StringTokenizer tokenizer = new StringTokenizer(s.replace(" ", ""), " []", true);

        List<String> dimensions = new ArrayList<String>();
        if (tokenizer.hasMoreElements()) {
            dimensions.add(String.valueOf(tokenizer.nextElement()));
        }
        while (tokenizer.hasMoreElements()) {
            if ("[".equals(tokenizer.nextElement())) {
                String operand = (String) tokenizer.nextElement();
                if ("]".equals(operand))
                    dimensions.add(null);
                else
                    dimensions.add(operand);
            }
        }
        for (int i = dimensions.size(); i < 3; i++) {
            dimensions.add(null);
        }


        return dimensions;
    }
}