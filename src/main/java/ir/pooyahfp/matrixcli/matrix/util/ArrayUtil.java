/*
 * Copyright (c) 2013, Phsys and/or its affiliates. All rights reserved.
 *  Phsys PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package ir.pooyahfp.matrixcli.matrix.util;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

/**
 * @author : Pooya husseini
 *         Email : info@pooya-hfp.ir
 *         Date: 3/11/13
 *         Time: 7:29 PM
 */
public final class ArrayUtil {

    private ArrayUtil() {
    }

    @NotNull
    public static <T> T[][] splitArray(@NotNull T[] input, @SuppressWarnings("SameParameterValue") int length) {

        T[][] temp = (T[][]) new Object[input.length / length][length];

        for (int i = 0; i < input.length / length; i++) {
            temp[i] = Arrays.copyOfRange(input, i * length, i * length + length);
        }
        return temp;
    }

    @NotNull
    public static Double[][] toObject(@NotNull double[][] input) {
        Double[][] temp = new Double[input.length][input[0].length];
        for (int i = 0; i < input.length; i++) {
            temp[i] = toObject(input[i]);
        }
        return temp;
    }

    @NotNull
    public static Double[] toObject(@NotNull double[] input) {
        Double[] temp = new Double[input.length];
        //noinspection ForLoopReplaceableByForEach
        for (int i = 0; i < input.length; i++) {
            temp[i] = input[i];
        }
//        System.arraycopy(input, 0, temp, 0, input.length);
        return temp;
    }

    public static double[] divide(@NotNull double[] content, double divisor) {
        double[] clone = content.clone();
        for (int i = 0; i < content.length; i++) {
            clone[i] /= divisor;
        }
        return clone;
    }

    public static double[] multiply(@NotNull double[] content, double multiplier) {
        double[] clone = content.clone();
        for (int i = 0; i < content.length; i++) {
            clone[i] *= multiplier;
        }
        return clone;
    }

    public static double[] sub(@NotNull double[] content, @SuppressWarnings("SameParameterValue") double operand) {
        double[] clone = content.clone();
        for (int i = 0; i < content.length; i++) {
            clone[i] -= operand;
        }
        return clone;
    }

    public static double[] divide(@NotNull double[] a, double[] b) {
        double[] clone = a.clone();
        for (int i = 0; i < a.length; i++) {
            clone[i] /= b[i];
        }
        return clone;
    }

    public static double[] multiply(@NotNull double[] a, double[] b) {
        double[] clone = a.clone();
        for (int i = 0; i < a.length; i++) {
            clone[i] *= b[i];
        }
        return clone;
    }

    public static double[] sub(@NotNull double[] a, double[] b) {
        double[] clone = a.clone();
        for (int i = 0; i < a.length; i++) {
            clone[i] -= b[i];

        }
        return clone;
    }

    public static double[] add(@NotNull double[] a, double[] b) {
        double[] clone = a.clone();
        for (int i = 0; i < a.length; i++) {
            clone[i] += b[i];
        }
        return clone;
    }

    public static double[] add(@NotNull double[] content, @SuppressWarnings("SameParameterValue") double operand) {
        double[] clone = content.clone();
        for (int i = 0; i < content.length; i++) {
            clone[i] += operand;
        }
        return clone;
    }

    @NotNull
    public static double[] concat(@NotNull double[] first, @NotNull double[] second) {
        double[] result = Arrays.copyOf(first, first.length + second.length);
        System.arraycopy(second, 0, result, first.length, second.length);

        return result;
    }

    public static double gcd(@NotNull double[] content) {
        double result = content[0];
        for (int i = 1; i < content.length; i++) {
            result = gcd(result, content[i]);
        }
        return result;
    }

    private static double gcd(double a, double b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}