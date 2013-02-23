/*
 * Copyright (c) 2013, Phsys and/or its affiliates. All rights reserved.
 *  Phsys PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package matrix.commands;

import matrix.Matrix;

import java.util.List;

/**
 * @author : Pooya husseini
 *         Email : info@pooya-hfp.ir
 *         Date: 1/23/13
 *         Time: 2:10 PM
 */
public class SetCommand extends AbstractCommand {

    @Override
    public void execute(List<String> params, List<String> values) throws Exception {
        String name = params.get(0);

        Integer row = params.get(1).isEmpty() ? null : Integer.parseInt(params.get(1))-1;
        Integer col = params.get(2).isEmpty() ? null : Integer.parseInt(params.get(2))-1;

        Matrix matrix = getMatrix(name);
        double[] doubles = toDouble(values);
        matrix.setContent(row, col, doubles);

    }

    public double[] toDouble(List<String> list) {
        double[] doubles = new double[list.size()];

        for (int i = 0; i < list.size(); i++) {
            doubles[i] = Double.parseDouble(list.get(i));
        }
        return doubles;
    }

//    public static class CommandDescriptor {
//
//        private final String identifier;
//        private final int firstDimension;
//        private final int secondDimension;
//        private final Integer[] values;
//
//        public CommandDescriptor(String identifier, int firstDimension, int secondDimension, Integer[] values) {
//            this.identifier = identifier;
//            this.firstDimension = firstDimension;
//            this.secondDimension = secondDimension;
//            this.values = values;
//        }
//
//        public String getIdentifier() {
//            return identifier;
//        }
//
//        public int getFirstDimension() {
//            return firstDimension;
//        }
//
//        public int getSecondDimension() {
//            return secondDimension;
//        }
//
//        public Integer[] getValues() {
//            return values;
//        }
//    }

//    public List<String> extractDimensions(String s) {
//        final DocumentScanner scanner = new PositionAwareDocumentScanner(s);
//        scanner.expect("set");
//        StringTokenizer tokenizer = new StringTokenizer(s.replace(" ", ""), " []", true);
//
//        List<String> dimensions = new ArrayList<String>();
//        if (tokenizer.hasMoreElements()) {
//            dimensions.add(String.valueOf(tokenizer.nextElement()));
//        }
//        while (tokenizer.hasMoreElements()) {
//            if ("[".equals(tokenizer.nextElement())) {
//                String operand = (String) tokenizer.nextElement();
//                if ("]".equals(operand))
//                    dimensions.add(null);
//                else
//                    dimensions.add(operand);
//            }
//        }
//        for (int i = dimensions.size(); i < 3; i++) {
//            dimensions.add(null);
//        }
//
//
//        return dimensions;
//    }
}

// set x [   ] [ 2 ] { 1,2,3,   6 ,7 }