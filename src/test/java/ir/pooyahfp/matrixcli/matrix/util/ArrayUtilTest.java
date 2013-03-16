/*
 * Copyright (c) 2013, Phsys and/or its affiliates. All rights reserved.
 *  Phsys PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package ir.pooyahfp.matrixcli.matrix.util;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author : Pooya husseini
 *         Email : info@pooya-hfp.ir
 *         Date: 3/11/13
 *         Time: 8:05 PM
 */
public class ArrayUtilTest {
    @Test
    public void testSplitArray()  {
        Double[] arr = new Double[9];
        Arrays.fill(arr, 0, 9, 12.0);

        System.out.println(Arrays.deepToString(ArrayUtil.splitArray(arr, 3)));
//        System.out.println(Arrays.deepToString(arr));
    }

    @Test
    public void testDivide()  {

    }

    @Test
    public void testMultiply()  {

    }

    @Test
    public void testSub()  {

    }


}
