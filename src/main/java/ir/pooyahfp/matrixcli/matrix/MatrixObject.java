/*
 * Copyright (c) 2013, Phsys and/or its affiliates. All rights reserved.
 *  Phsys PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package ir.pooyahfp.matrixcli.matrix;

import ir.pooyahfp.matrixcli.exception.MatrixHasNotDeterminantException;
import ir.pooyahfp.matrixcli.exception.NonDecomposableMatrixException;
import ir.pooyahfp.matrixcli.exception.NonInvertibleMatrixException;
import ir.pooyahfp.matrixcli.exception.NonSquareMatrixException;
import ir.pooyahfp.matrixcli.exception.NotSupportedException;
import ir.pooyahfp.matrixcli.exception.TypeConversionException;
import ir.pooyahfp.matrixcli.matrix.util.ArrayUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.Serializable;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Base immutable matrix class that has a lot of functions to manipulate the matrix data
 *
 * @author : Pooya husseini
 *         Email : info@pooya-hfp.ir
 *         Date: 1/26/13
 *         Time: 10:58 AM
 *         TODO update comments
 */
public class MatrixObject extends SimpleObject implements Serializable, Cloneable {

    private final static String MESSAGE="Matrix has not single value";
    private double[][] content;
    private String name;

    private MatrixObject(int height, int width) {
        this(height, width, "Temp");
    }

    public MatrixObject(@NotNull String name) {

        this(0, 0, name);
    }

    public MatrixObject(int height, int width, @NotNull String name) {
        if ("".equals(name.trim())) {
            throw new IllegalArgumentException("Matrices should have name!");
        }
        this.name = name;
        this.content = new double[height][width];
    }

    /**
     * Changes the content of the matrix with a 2d double array
     *
     * @param content 2d double array
     * @return the matrix with given data
     */
    @NotNull
    public MatrixObject setContent(@NotNull double[][] content) {

        MatrixObject x = new MatrixObject(content.length, content[0].length, this.name);

        for (int i = 0; i < content.length; i++) {
            System.arraycopy(content[i], 0, x.content[i], 0, content[0].length);
        }
        return x;
    }


    @NotNull
    public MatrixObject setContent(@NotNull Double[][] content) {

        MatrixObject x = new MatrixObject(content.length, content[0].length, this.name);

        for (int i = 0; i < content.length; i++) {
            System.arraycopy(content[i], 0, x.content[i], 0, content[0].length);
        }
        return x;
    }

    /**
     * Changes the content of the MatrixObject with a 1d double array
     * It copies row by row of the 1d content array
     *
     * @param content 1d double array
     */
    @NotNull
    public MatrixObject setContent(@NotNull double[] content) {

        if (content.length < getHeight() * getWidth()) {
            throw new IllegalArgumentException("Input data length is not equal to matrix size");
        }

        MatrixObject x = this.copy();

        for (int i = 0; i < getHeight(); i++) {
            System.arraycopy(content, i * getWidth(), x.content[i], 0, getWidth());
        }

        return x;
//        return setContent(ArrayUtil.splitArray(ArrayUtil.toObject(content), getWidth()));
    }

    /**
     * Sets the content of array according to row and col.
     * if row is null then it copies all 1d content to entered column
     * if col is null then it copies all 1d content to entered row
     * if both have value then it copies the content[0] to the [row][col]
     * and if both were null then it acts like setContent(double[] content)
     *
     * @param row     desired row number. it can be null
     * @param col     desired col number. it can be null
     * @param content 1d double array
     */
    @NotNull
    @Override
    public MatrixObject setContent(@Nullable Integer row, @Nullable Integer col, @NotNull double[] content) {
        MatrixObject x = this.copy();

        if (row == null && col != null) {
            for (int i = 0; i < getHeight(); i++) {
                x.content[i][col] = content[i];
            }
        } else if (col == null && row != null) {
            System.arraycopy(content, 0, x.content[row], 0, getWidth());
        } else if (col != null && content.length == 1) {
            return setContent(content[0], row, col);
        } else {
            return setContent(content);
        }
        return x;
    }

    /**
     * @return the name of the MatrixObject
     */
    public String getName() {
        return name;
    }

    /**
     * sets the name of MatrixObject
     *
     * @param name name of the MatrixObject
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the width of MatrixObject
     */
    public int getWidth() {
//        if (content[0].length == 0) {
//            return Integer.MAX_VALUE;
//        }
        return content[0].length;
    }

    /**
     * sets the width of the MatrixObject and resize the MatrixObject width
     *
     * @param width the with
     */
    @NotNull
    public MatrixObject setWidth(int width) {
        if (width <= 0) {
            throw new IllegalArgumentException("Width should be greater than zero");
        }

        MatrixObject matrixObject = new MatrixObject(this.getHeight(), width, this.name);

        int destWidth = Math.min(width, getWidth());
        for (int i = 0; i < getHeight(); i++) {
            System.arraycopy(content[i], 0, matrixObject.content[i], 0, destWidth);
        }
//        for (int i = 0; i < this.getHeight(); i++) {
//            System.arraycopy(content[i], 0, matrixObject.content[i], 0, this.getWidth());
//        }

        return matrixObject;
    }

    /**
     * @return getHeight() of the matrix
     */
    public int getHeight() {
        return content.length;
    }

    /**
     * Sets the getHeight() of the matrix and resize it
     *
     * @param height the getHeight()
     */
    @NotNull
    public MatrixObject setHeight(int height) {
        if (height <= 0) {
            throw new IllegalArgumentException("Height should be greater than zero");
        }

        MatrixObject matrixObject = new MatrixObject(height, this.getWidth(), name);
        int destHeight = Math.min(height, this.getHeight());

        for (int i = 0; i < destHeight; i++) {
            System.arraycopy(content[i], 0, matrixObject.content[i], 0, this.getWidth());
        }
        return matrixObject;
    }

    /**
     * @param i cell row
     * @param j cell column
     * @return content at i,j cell
     */
    public double getContent(int i, int j) {
        return content[i][j];
    }

    /**
     * @return all content
     */
    public double[][] getContent() {
        return content;
    }

    /**
     * Fills all matrix with the given value
     *
     * @param val given value
     */
    @NotNull
    public MatrixObject setContent(@SuppressWarnings("SameParameterValue") double val) {
        MatrixObject x = this.copy();

        for (double[] doubles : x.content) {
            Arrays.fill(doubles, val);
        }
        return x;
    }

    /**
     * changes the cell value
     *
     * @param val new value
     * @param i   cell row
     * @param j   cell column
     */
    @NotNull
    public MatrixObject setContent(double val, int i, int j) {
        MatrixObject x = this.copy();
        x.content[i][j] = val;
        return x;
    }


    /**
     * it removes entire a row
     *
     * @param r desired row
     * @return returns the new matrix without the row
     */
    @NotNull
    public MatrixObject removeRow(int r) {
        MatrixObject x = new MatrixObject(getHeight() - 1, getWidth(), name);

        return x.setContent(removeRow(content, r));
    }

    /**
     * it removes entire a column
     *
     * @param c desired column
     * @return returns the new matrix without the column
     */
    @NotNull
    public MatrixObject removeColumn(int c) {
        MatrixObject x = new MatrixObject(getHeight(), getWidth() - 1, name);

        for (int i = 0; i < getHeight(); i++) {
            System.arraycopy(this.content[i], 0, x.content[i], 0, c);

            System.arraycopy(this.content[i], c + 1, x.content[i], c + 1 - 1, getWidth() - (c + 1));
        }

        return x;
    }

    /**
     * Removes the row from the entered array
     *
     * @param content input array
     * @param r       input row
     * @return the new array without the row
     */
    @NotNull
    private double[][] removeRow(double[][] content, int r) {
        List<double[]> l = new ArrayList<double[]>(Arrays.asList(content));
        l.remove(r);
        return l.toArray(new double[][]{});
    }

    /**
     * @return returns the transpose of this matrix
     */
    @NotNull
    public MatrixObject getTranspose() {
        MatrixObject matrixObject = new MatrixObject(getWidth(), getHeight(), name);
//        double temp[][] = new double[this.getWidth()][this.getHeight()];
        for (int i = 0; i < getHeight(); ++i) {
            for (int j = 0; j < getWidth(); ++j) {
                matrixObject.content[j][i] = this.content[i][j];
            }
        }
        //noinspection SuspiciousNameCombination

        return matrixObject;
    }

    /**
     * @return returns the string representation of the matrix
     */
    @NotNull
    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder();
        builder.append("[[").append(name).append("]]\n");
        for (int i = 0; i < getHeight(); i++) {
            for (int j = 0; j < getWidth(); j++) {
                builder.append(String.format("%2f", content[i][j])).append("\t");
            }
            builder.append("\n");
        }
        return builder.toString();
    }

    /**
     * divides the matrix with the input number
     *
     * @param n input divisor
     * @return return the divided matrix
     */
    @NotNull
    public MatrixObject divide(double n) {
        MatrixObject matrixObject = this.copy();

        for (int i = 0; i < getHeight(); i++) {
            for (int j = 0; j < getWidth(); j++) {
                matrixObject.content[i][j] /= n;
            }
        }
        return matrixObject;
    }


    /**
     * divides this matrix with the n matrix cell by cell
     *
     * @param o input matrix
     * @return the divided matrix
     */
    @NotNull
    public MatrixObject divide(SimpleObject o) {
        MatrixObject n = cast(o);
        if (isDivisionByZero(n)) {
            throw new ArithmeticException("Division by zero");
        }
        MatrixObject matrixObject = this.copy();

        for (int i = 0; i < getHeight(); i++) {
            for (int j = 0; j < getWidth(); j++) {
                matrixObject.content[i][j] /= n.getContent(i, j);
            }
        }
        return matrixObject;
    }

    public boolean contains(@SuppressWarnings("SameParameterValue") double value) {
        for (double[] aContent : content) {
            for (double c : aContent) {
                if (value == c) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * @return returns the determinant of the matrix
     */
    @NotNull
    public SimpleObject getDeterminant() {
        return new SimpleObject(determinant(this));
    }

    /**
     * @return is the matrix deterministic
     */
    public boolean hasDeterminant() {
        return getHeight() == getWidth();
    }

    /**
     * @return is the matrix invertible
     */
    public boolean isInvertible() {
        return getDeterminant().doubleValue() != 0;
    }

    /**
     * Calculates determinant of the matrix
     *
     * @param a input matrix
     * @return determinant of the matrix
     */
    private double determinant(@NotNull MatrixObject a) {
        if (!a.hasDeterminant()) {
            throw new MatrixHasNotDeterminantException();
        }
        if (a.getHeight() == 2 && a.getWidth() == 2) {
            return a.content[0][0] * a.content[1][1] - a.content[0][1] * a.content[1][0];
        }

        double n = 0;

        for (int j = 0; j < getWidth(); j++) {
            n += a.content[0][j] * determinant(a.removeRowAndCol(0, j)) * (j % 2 == 0 ? 1 : -1);
        }

        return n;
    }

    /**
     * Removes row and col from the matrix
     *
     * @param i input row number
     * @param j input column number
     * @return the new matrix without row and column
     */
    @NotNull
    public MatrixObject removeRowAndCol(int i, int j) {
        MatrixObject temp = this.removeRow(i);
        return temp.removeColumn(j);
    }

    /**
     * @return returns the coFactor of the matrix
     */
    @NotNull
    public MatrixObject coFactor() {
        MatrixObject temp = new MatrixObject(getHeight(), getWidth());

        for (int i = 0; i < getHeight(); i++) {
            for (int j = 0; j < getWidth(); j++) {
                MatrixObject cofactor = this.removeRowAndCol(i, j);
                temp.setContent(((i + j) % 2 == 0 ? 1 : -1) * determinant(cofactor), i, j);
            }
        }
        return temp;
    }

    /**
     * @return returns the invert of the matrix
     */
    @NotNull
    public MatrixObject getInvert() {

        if (!isInvertible()) {
            throw new NonInvertibleMatrixException();
        }
        double det = this.getDeterminant().doubleValue();

        if (getHeight() == 2 && getWidth() == 2) {

            MatrixObject temp = new MatrixObject(name);
            temp.content = this.content.clone();
            double a = temp.content[0][0];
            temp.content[0][0] = temp.content[1][1];
            temp.content[1][1] = a;
            temp.content[0][1] = -temp.content[0][1];
            temp.content[1][0] = -temp.content[1][0];

            return temp.divide(det);
        }
        return coFactor().getTranspose().divide(det);
    }

    /**
     * @param i row number
     * @return returns the row in an 1d array
     */
    public double[] getRow(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Row number is greater or equal than 0");
        }
        return content[i];
    }

    /**
     * Adds the input Object (Both simple type and matrix type) to this matrix
     *
     * @param o input matrix
     * @return returns the result of addition
     */
    @NotNull
    public MatrixObject add(@NotNull SimpleObject o) {
        MatrixObject b = tryCast(o);
        MatrixObject temp = new MatrixObject(getHeight(), getWidth());
        if (b != null) {
            if (getWidth() != b.getWidth() || getHeight() != b.getHeight()) {
                throw new IllegalArgumentException("Input matrices should have same dimensions");
            }

            for (int i = 0; i < getHeight(); i++) {
                for (int j = 0; j < getWidth(); j++) {
                    temp.content[i][j] = this.content[i][j] + b.content[i][j];
                }
            }
        } else {
            for (int i = 0; i < getHeight(); i++) {
                for (int j = 0; j < getWidth(); j++) {
                    temp.content[i][j] = this.content[i][j] + o.doubleValue();
                }
            }
        }
        return temp;
    }

    @NotNull
    public MatrixObject add(double o) {
        MatrixObject temp = copy();

        for (int i = 0; i < getHeight(); i++) {
            for (int j = 0; j < getWidth(); j++) {
                temp.content[i][j] += o;
            }
        }

        return temp;
    }

    /**
     * Subtracts the input matrix from this matrix
     *
     * @param o input matrix
     * @return returns the result of this-b
     */
    @NotNull
    public MatrixObject sub(@NotNull SimpleObject o) {
        MatrixObject b = tryCast(o);
        MatrixObject temp = new MatrixObject(getHeight(), getWidth());
        if (b != null) {
            if (getWidth() != b.getWidth() || getHeight() != b.getHeight()) {
                throw new IllegalArgumentException("Input matrices should have same dimensions");
            }

            for (int i = 0; i < getHeight(); i++) {
                for (int j = 0; j < getWidth(); j++) {
                    temp.content[i][j] = this.content[i][j] - b.content[i][j];
                }
            }
        } else {
            for (int i = 0; i < getHeight(); i++) {
                for (int j = 0; j < getWidth(); j++) {
                    temp.content[i][j] = this.content[i][j] - o.doubleValue();
                }
            }
        }

        return temp;
    }

    /**
     * Multiplies the input matrix with this matrix
     *
     * @param o input matrix
     * @return returns the result of this*b
     */
    @NotNull
    public MatrixObject mul(@NotNull SimpleObject o) {
        MatrixObject b = tryCast(o);

        if (b != null) {
            if (getWidth() != b.getHeight()) {
                throw new IllegalArgumentException(MessageFormat.format("A:Rows: {0} did not match B:Columns {1}.",
                        getWidth(), b.getHeight()));
            }

            MatrixObject temp = new MatrixObject(getHeight(), b.getWidth());

//        double[][] result = new double[getHeight()][b.getWidth()];

            for (int i = 0; i < getHeight(); i++) {
                for (int j = 0; j < b.getWidth(); j++) { // bColumn
                    for (int k = 0; k < getWidth(); k++) { // aColumn
                        temp.content[i][j] += this.content[i][k] * b.content[k][j];
                    }
                }
            }
            return temp;
        } else {
            MatrixObject temp = new MatrixObject(getHeight(), getWidth());

            for (int i = 0; i < getHeight(); i++) {
                for (int j = 0; j < getWidth(); j++) {
                    temp.content[i][j] = this.content[i][j] * o.doubleValue();
                }
            }
            return temp;
        }

    }

    /**
     * Powers the matrix to input number
     *
     * @param c power number
     * @return returns the result of this^c
     */
    @NotNull
    public MatrixObject power(int c) {
        if (c <= 0) {
            throw new IllegalArgumentException("Power must be greater than zero");
        }

        MatrixObject temp = this.copy();

        for (int i = 1; i < c; i++) {
            temp = temp.mul(this).copy();
        }
        return temp;
    }

    @NotNull
    @Override
    public SimpleObject power(@NotNull SimpleObject o) {
        return power(o.intValue());
    }

    @Override
    public double getEquivalenceValue() {
        throw new NotSupportedException("Matrices have not equivalence value");
    }

    /**
     * Decomposes the matrix to lu decomposition and fills l and u
     *
     * @param l output parameter of l in lu decomposition
     * @param u output parameter of u in lu decomposition
     */
    public void lu(SimpleObject l, SimpleObject u) {
        if (getHeight() != getWidth()) {
            throw new NonDecomposableMatrixException("Can not decompose");
        }

        double[][] lu;

//        int height;
        int width;

        lu = getContent();
//        height = getHeight();
        width = getWidth();

        int[] piv = new int[getHeight()];
        for (int i = 0; i < getHeight(); i++) {
            piv[i] = i;
        }
        int pivsign = 1;
        double[] lUrowi;
        double[] lUcolj = new double[getHeight()];

        for (int j = 0; j < width; j++) {

            for (int i = 0; i < getHeight(); i++) {
                lUcolj[i] = lu[i][j];
            }

            for (int i = 0; i < getHeight(); i++) {
                lUrowi = lu[i];

                int kmax = Math.min(i, j);
                double s = 0.0;
                for (int k = 0; k < kmax; k++) {
                    s += lUrowi[k] * lUcolj[k];
                }

                lUrowi[j] = lUcolj[i] -= s;
            }
            int p = j;
            for (int i = j + 1; i < getHeight(); i++) {
                if (Math.abs(lUcolj[i]) > Math.abs(lUcolj[p])) {
                    p = i;
                }
            }
            if (p != j) {
                for (int k = 0; k < width; k++) {
                    double t = lu[p][k];
                    lu[p][k] = lu[j][k];
                    lu[j][k] = t;
                }
                int k = piv[p];
                piv[p] = piv[j];
                piv[j] = k;
                pivsign = -pivsign;
            }

            if (j < getHeight() & lu[j][j] != 0.0) {
                for (int i = j + 1; i < getHeight(); i++) {
                    lu[i][j] /= lu[j][j];
                }
            }
        }

        MatrixObject lTemp = new MatrixObject(getHeight(), width);

        for (int i = 0; i < getHeight(); i++) {
            for (int j = 0; j < width; j++) {
                if (i > j) {
                    lTemp.setContent(lu[i][j], i, j);
                } else if (i == j) {
                    lTemp.setContent(1.0, i, j);
                } else {
                    lTemp.setContent(0.0, i, j);
                }
            }
        }

        //noinspection SuspiciousNameCombination
        MatrixObject uTemp = new MatrixObject(width, width);
//        double[][] U = uTemp.getContent();
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < width; j++) {
                if (i <= j) {
                    uTemp.setContent(lu[i][j], i, j);
                } else {
                    uTemp.setContent(0.0, i, j);
                }
            }
        }
        u = uTemp.copy();
        l = lTemp.copy();
    }

    @NotNull
    public MatrixObject echelonForm() {
        MatrixObject matrixObject = new MatrixObject(name);
        matrixObject.content = this.content.clone();

        for (int r = 0; r < matrixObject.content.length; r++) {
            if (matrixObject.content[r][r] != 1 && matrixObject.content[r][r] != 0) {
                matrixObject.content[r] = ArrayUtil.divide(matrixObject.content[r], matrixObject.content[r][r]);
            }
            for (int i = r + 1; i < matrixObject.content.length; i++) {
                matrixObject.content[i] = ArrayUtil.sub(matrixObject.content[i],
                        ArrayUtil.multiply(matrixObject.content[r],
                                matrixObject.content[i][r])).clone();
            }
        }
        return matrixObject;
    }

    @NotNull
    public SimpleObject getRank() {
        MatrixObject x = echelonForm();

        int rank = 0;
        for (double[] doubles : x.content) {
            double sum = 0;
            for (double aDouble : doubles) {
                sum += aDouble;
            }
            if (Math.abs(sum) == 0) {
                rank++;
            }
        }
        return new SimpleObject(x.content.length - rank);
    }

    @NotNull
    public SimpleObject getTrace() {
        if (getHeight() != getWidth()) {
            throw new NonSquareMatrixException();
        }

        double sum = 0;
        for (int i = 0; i < getHeight(); i++) {
            sum += content[i][i];
        }

        return new SimpleObject(sum);
    }

    @NotNull
    public MatrixObject eigenValues() {
        MatrixObject y = new MatrixObject(getHeight(), 1);
        y.setContent(1);

        for (int i = 1; i < 10; i++) {
            MatrixObject pre = this.power(i - 1).mul(y);
            MatrixObject in = this.power(i).mul(y);

            y = in.divide(pre);
        }
        return y;
    }

    @NotNull
    public MatrixObject getIdentity() {
        if (getHeight() != getWidth()) {
            throw new NonSquareMatrixException();
        }
        double[][] v = new double[getWidth()][getWidth()];


        for (int i = 0; i < getHeight(); i++) {
            v[i][i] = 1;

        }
        return new MatrixObject("I").setContent(v);
    }

    @NotNull
    public MatrixObject copy() {
        MatrixObject matrixObject = new MatrixObject(name);
        matrixObject.content = this.content.clone();
        return matrixObject;
    }

    public boolean isDivisionByZero(SimpleObject o) {
        return cast(o).contains(0);
    }

    public boolean isMultipliable(SimpleObject o) {
        MatrixObject b = cast(o);
        return getWidth() == b.getHeight();
    }

    @NotNull
    public MatrixObject cast(SimpleObject o) {
        if (!(o instanceof MatrixObject)) {
            throw new TypeConversionException();
        }
        return (MatrixObject) o;
    }

    @Nullable
    public MatrixObject tryCast(SimpleObject o) {
        if (!(o instanceof MatrixObject)) {
            return null;
        }
        return (MatrixObject) o;
    }



    @Override
    public int intValue() {
        throw new NotSupportedException(MESSAGE);
    }

    @Override
    public long longValue() {
        throw new NotSupportedException(MESSAGE);
    }


    @Override
    public float floatValue() {

        throw new NotSupportedException();
    }

    @Override
    public double doubleValue() {
        throw new NotSupportedException(MESSAGE);
    }

}