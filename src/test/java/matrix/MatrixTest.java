/*
 * Copyright (c) 2013, Phsys and/or its affiliates. All rights reserved.
 *  Phsys PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package matrix;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author : Pooya husseini
 *         Email : info@pooya-hfp.ir
 *         Date: 2/20/13
 *         Time: 3:11 PM
 */
public class MatrixTest {
    @Test
    public void testSetContent() throws Exception {
        Matrix x=new Matrix(3,3,"a");
        x.setContent(1);
        for (double[] doubles : x.getContent()) {
            Assert.assertArrayEquals(doubles,new double[]{1,1,1},0);
        }

    }


    @Test
    public void testGetName() throws Exception {

    }

    @Test
    public void testSetName() throws Exception {

    }

    @Test
    public void testGetWidth() throws Exception {

    }

    @Test
    public void testSetWidth() throws Exception {

    }

    @Test
    public void testGetHeight() throws Exception {

    }

    @Test
    public void testSetHeight() throws Exception {

    }

    @Test
    public void testGetContent() throws Exception {

    }


    @Test
    public void testSetMatrix() throws Exception {

    }

    @Test
    public void testRemoveRow() throws Exception {

    }

    @Test
    public void testRemoveColumn() throws Exception {

    }

    @Test
    public void testGetTranspose() throws Exception {

    }

    @Test
    public void testToString() throws Exception {

    }

    @Test
    public void testDivide() throws Exception {

    }

    @Test
    public void testDeterminant() throws Exception {

    }

    @Test
    public void testIsDeterministic() throws Exception {

    }

    @Test
    public void testIsInvertible() throws Exception {

    }

    @Test
    public void testRemoveRowAndCol() throws Exception {

    }

    @Test
    public void testCofactor() throws Exception {

    }

    @Test
    public void testInvert() throws Exception {

    }

    @Test
    public void testGetRow() throws Exception {

    }

    @Test
    public void testAdd() throws Exception {

    }

    @Test
    public void testSub() throws Exception {

    }

    @Test
    public void testMul() throws Exception {

    }

    @Test
    public void testPower() throws Exception {

    }

    @Test
    public void testLu() throws Exception {

    }

    @Test
    public void testEchelonForm() {
        double[][] a = {
                {2, 4, 1, 3},
                {-1, -2, 1, 0},
                {0, 0, 2, 2},
                {3, 6, 2, 5}
        };
        Matrix p = new Matrix("P", a);
        System.out.println(p.echelonForm());
    }

    @Test
    public void testEigenValues(){
        Matrix matrix=new Matrix();
        System.out.println(matrix.eigenValues());
    }
}