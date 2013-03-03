/*
 * Copyright (c) 2013, Phsys and/or its affiliates. All rights reserved.
 *  Phsys PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package ir.pooyahfp.matrixcli.matrix;

import ir.pooyahfp.matrixcli.exception.TypeConversionException;

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
 */
public class Matrix implements MathObject, Serializable, Cloneable {

    private double[][] content;
    private String name;


    public Matrix() {
    }

    private Matrix(int height, int width) {
        this(height, width, "");
    }

    public Matrix(String name) {
        this(0, 0, name);
    }

    public Matrix(int height, int width, String name) {
        this.name = name;
//        this.width = width;
//        this.getHeight() = getHeight();
        this.content = new double[height][width];
    }

//    public Matrix(String name, double[][] content) {
//        this.name = name;
//        this.width = content[0].length;
//        this.getHeight() = content.length;
//        this.content = content.clone();
//    }

    /**
     * Changes the content of the matrix with a 2d double array
     *
     * @param content 2d double array
     * @return the matrix with given data
     */
    public Matrix setContent(double[][] content) {
        Matrix x = new Matrix(content.length, content[0].length, this.name);

        for (int i = 0; i < content.length; i++) {
            System.arraycopy(content[i], 0, x.content[i], 0, content[0].length);
        }
//        x.getHeight() = content.length;
//        x.width = content[0].length;
//
        return x;
    }


    /**
     * Changes the content of the matrix with a 1d double array
     * It copies row by row of the 1d content array
     *
     * @param content 1d double array
     */
    public Matrix setContent(double[] content) throws Exception {
        Matrix x = this.copy();

        for (int i = 0; i < getHeight(); i++)
            System.arraycopy(content, i * getWidth(), x.content[i], 0, getWidth());

        return x;
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
    @Override
    public Matrix setContent(Integer row, Integer col, double[] content) throws Exception {
        Matrix x = this.copy();

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
     * @return the name of the matrix
     */
    public String getName() {
        return name;
    }

    /**
     * sets the name of matrix
     *
     * @param name name of the matrix
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the width of matrix
     */
    public int getWidth() {
        return content[0].length;
    }

    /**
     * sets the width of the matrix and resize the matrix width
     *
     * @param width the with
     */
    public Matrix setWidth(int width) {
        if (width <= 0)
            throw new IllegalArgumentException("Width should be greater than zero");

        Matrix matrix = new Matrix(this.getHeight(), width, this.name);

        for (int i = 0; i < this.getHeight(); i++) {
            System.arraycopy(content[i], 0, matrix.content[i], 0, this.getWidth());
        }

        return matrix;
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
    public Matrix setHeight(int height) {
        if (height <= 0)
            throw new IllegalArgumentException("Height should be greater than zero");

        Matrix matrix = new Matrix(height, this.getWidth(), name);
//        double[][] newArray = new double[getHeight()][width];

        for (int i = 0; i < this.getHeight(); i++) {
            System.arraycopy(content[i], 0, matrix.content[i], 0, getWidth());
        }
        return matrix;
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
    public Matrix setContent(double val) throws Exception {
        Matrix x = this.copy();

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
    public Matrix setContent(double val, int i, int j) throws Exception {
        Matrix x = this.copy();
        x.content[i][j] = val;
        return x;
    }


    /**
     * it removes entire a row
     *
     * @param r desired row
     * @return returns the new matrix without the row
     */
    public Matrix removeRow(int r) {
        Matrix x = new Matrix(getHeight() - 1, getWidth(), name);

        return x.setContent(removeRow(content, r));
    }

    /**
     * it removes entire a column
     *
     * @param c desired column
     * @return returns the new matrix without the column
     */
    public Matrix removeColumn(int c) {
        Matrix x = new Matrix(getHeight(), getWidth() - 1, name);

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
    private double[][] removeRow(double[][] content, int r) {
        List<double[]> l = new ArrayList<double[]>(Arrays.asList(content));
        l.remove(r);
        return l.toArray(new double[][]{});
    }

    /**
     * @return returns the transpose of this matrix
     */
    public Matrix getTranspose() {
        Matrix matrix = new Matrix(getWidth(), getHeight(), name);
//        double temp[][] = new double[this.getWidth()][this.getHeight()];
        for (int i = 0; i < getHeight(); ++i) {
            for (int j = 0; j < getWidth(); ++j) {
                matrix.content[j][i] = this.content[i][j];
            }
        }
        //noinspection SuspiciousNameCombination

        return matrix;
    }

    /**
     * @return returns the string representation of the matrix
     */
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
    public Matrix divide(double n) throws Exception {
        Matrix matrix = this.copy();

        for (int i = 0; i < getHeight(); i++) {
            for (int j = 0; j < getWidth(); j++) {
                matrix.content[i][j] /= n;
            }
        }
        return matrix;
    }


    /**
     * divides this matrix with the n matrix cell by cell
     *
     * @param o input matrix
     * @return the divided matrix
     */
    public Matrix divide(MathObject o) throws Exception {
        Matrix n=cast(o);
        if (isDivisionByZero(n))
            throw new IllegalArgumentException("Division by zero");

        Matrix matrix = this.copy();


        for (int i = 0; i < getHeight(); i++) {
            for (int j = 0; j < getWidth(); j++) {
                matrix.content[i][j] /= n.getContent(i, j);
            }
        }
        return matrix;
    }

    public boolean contains(double value) {
        for (double[] aContent : content) {
            for (double c : aContent) {
                if (value == c)
                    return true;
            }
        }
        return false;
    }

    /**
     * @return returns the determinant of the matrix
     */
    public double getDeterminant() {
        return determinant(this);
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
        return getDeterminant() != 0;
    }

    /**
     * Calculates determinant of the matrix
     *
     * @param a input matrix
     * @return determinant of the matrix
     */
    private double determinant(Matrix a) {
        if (!a.hasDeterminant())
            throw new IllegalArgumentException("Matrix has not determinant");

        if (a.getHeight() == 2 && a.getWidth() == 2)
            //in haman ad -bc ast
            return a.content[0][0] * a.content[1][1] - a.content[0][1] * a.content[1][0];

        double n = 0;

        for (int j = 0; j < getWidth(); j++)
            n += a.content[0][j] * determinant(a.removeRowAndCol(0, j)) * (j % 2 == 0 ? 1 : -1);

        return n;
    }

    /**
     * Removes row and col from the matrix
     *
     * @param i input row number
     * @param j input column number
     * @return the new matrix without row and column
     */
    public Matrix removeRowAndCol(int i, int j) {
        Matrix temp = this.removeRow(i);

        return temp.removeColumn(j);
    }

    /**
     * @return returns the coFactor of the matrix
     */
    public Matrix coFactor() throws Exception {
        Matrix temp = new Matrix(getHeight(), getWidth());

//
//        } else {

        for (int i = 0; i < getHeight(); i++) {
            for (int j = 0; j < getWidth(); j++) {
                Matrix cofactor = this.removeRowAndCol(i, j);
                temp.setContent(((i + j) % 2 == 0 ? 1 : -1) * determinant(cofactor), i, j);
            }
        }

        return temp;

    }

    /**
     * @return returns the invert of the matrix
     */
    public Matrix getInvert() throws Exception {

        if (!isInvertible())
            throw new IllegalArgumentException("Matrix is not invertible!");
        double det = this.getDeterminant();

        if (getHeight() == 2 && getWidth() == 2) {

            Matrix temp = new Matrix(name);
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
        if (i < 0)
            throw new IllegalArgumentException("Row number is greater or equal than 0");
        return content[i];
    }

    /**
     * Adds the input matrix to this matrix
     *
     * @param o input matrix
     * @return returns the result of addition
     */
    public Matrix add(MathObject o) throws Exception {
        Matrix b=cast(o);

        if (getWidth() != b.getWidth() || getHeight() != b.getHeight()) {
            throw new IllegalArgumentException("Input matrices should have same dimensions");
        }

        Matrix temp = new Matrix(getHeight(), getWidth());

        for (int i = 0; i < getHeight(); i++) {
            for (int j = 0; j < getWidth(); j++) {
                temp.content[i][j] = this.content[i][j] + b.content[i][j];
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
    public Matrix sub(MathObject o) throws Exception {
        Matrix b = cast(o);
        if (getWidth() != b.getWidth() || getHeight() != b.getHeight()) {
            throw new IllegalArgumentException("Input Matrixes should have same dimensions");
        }

        Matrix temp = new Matrix(getHeight(), getWidth(), getName() + "-" + b.getName());

        for (int i = 0; i < getHeight(); i++) {
            for (int j = 0; j < getWidth(); j++) {
                temp.content[i][j] = this.content[i][j] - b.content[i][j];
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
    public Matrix mul(MathObject o) throws Exception {
        Matrix b = cast(o);
        if (getWidth() != b.getHeight()) {
            throw new IllegalArgumentException(MessageFormat.format("A:Rows: {0} did not match B:Columns {1}.",
                    getWidth(), b.getHeight()));
        }

        Matrix temp = new Matrix(getHeight(), b.getWidth());

//        double[][] result = new double[getHeight()][b.getWidth()];

        for (int i = 0; i < getHeight(); i++) {
            for (int j = 0; j < b.getWidth(); j++) { // bColumn
                for (int k = 0; k < getWidth(); k++) { // aColumn
                    temp.content[i][j] += this.content[i][k] * b.content[k][j];
                }
            }
        }
        return temp;
    }

    /**
     * Powers the matrix to input number
     *
     * @param c power number
     * @return returns the result of this^c
     */
    public Matrix power(int c) throws Exception {
        if (c <= 0)
            throw new IllegalArgumentException("Power must be greater than zero");

        Matrix temp = this.copy();

        for (int i = 1; i < c; i++) {
            temp = temp.mul(this).copy();
        }
        return temp;
    }

    /**
     * Decomposes the matrix to lu decomposition and fills l and u
     *
     * @param l output parameter of l in lu decomposition
     * @param u output parameter of u in lu decomposition
     * @throws Exception
     */
    public void lu(MathObject l, MathObject u) throws Exception {
        if (getHeight() != getWidth())
            throw new Exception("Can not decompose");

        double[][] lu;

        int height;
        int width;

        lu = getContent();
        height = getHeight();
        width = getWidth();

        int[] piv = new int[getHeight()];
        for (int i = 0; i < getHeight(); i++) {
            piv[i] = i;
        }
        int pivsign = 1;
        double[] LUrowi;
        double[] LUcolj = new double[getHeight()];

        for (int j = 0; j < width; j++) {

            for (int i = 0; i < getHeight(); i++) {
                LUcolj[i] = lu[i][j];
            }

            for (int i = 0; i < getHeight(); i++) {
                LUrowi = lu[i];

                int kmax = Math.min(i, j);
                double s = 0.0;
                for (int k = 0; k < kmax; k++) {
                    s += LUrowi[k] * LUcolj[k];
                }

                LUrowi[j] = LUcolj[i] -= s;
            }
            int p = j;
            for (int i = j + 1; i < getHeight(); i++) {
                if (Math.abs(LUcolj[i]) > Math.abs(LUcolj[p])) {
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

        Matrix lTemp = new Matrix(getHeight(), width);

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
        Matrix uTemp = new Matrix(width, width);
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

    public Matrix echelonForm() {
        Matrix matrix = new Matrix(name);
        matrix.content = this.content.clone();
//        double[][] a = content.clone();

        for (int r = 0; r < matrix.content.length; r++) {
            if (matrix.content[r][r] != 1 && matrix.content[r][r] != 0) {
                matrix.content[r] = divide(matrix.content[r], matrix.content[r][r]);
            }
            for (int i = r + 1; i < matrix.content.length; i++) {
                matrix.content[i] = sub(matrix.content[i], multiply(matrix.content[r], matrix.content[i][r])).clone();
            }
        }

        return matrix;
    }

    private double[] divide(double[] content, double divisor) {
        double[] clone = content.clone();
        for (int i = 0; i < content.length; i++) {
            clone[i] /= divisor;
        }
        return clone;
    }

    private double[] multiply(double[] content, double multiplier) {
        double[] clone = content.clone();
        for (int i = 0; i < content.length; i++) {
            clone[i] *= multiplier;
        }
        return clone;
    }

    private double[] sub(double[] content, double operand) {
        double[] clone = content.clone();
        for (int i = 0; i < content.length; i++) {
            clone[i] -= operand;

        }
        return clone;
    }

    private double[] divide(double[] a, double[] b) {
        double[] clone = a.clone();
        for (int i = 0; i < a.length; i++) {
            clone[i] /= b[i];
        }
        return clone;
    }

    private double[] multiply(double[] a, double[] b) {
        double[] clone = a.clone();
        for (int i = 0; i < a.length; i++) {
            clone[i] *= b[i];
        }
        return clone;
    }

    private double[] sub(double[] a, double[] b) {
        double[] clone = a.clone();
        for (int i = 0; i < a.length; i++) {
            clone[i] -= b[i];

        }
        return clone;
    }

    private double[] add(double[] a, double[] b) {
        double[] clone = a.clone();
        for (int i = 0; i < a.length; i++) {
            clone[i] += b[i];
        }
        return clone;
    }

    private double[] add(double[] content, double operand) {
        double[] clone = content.clone();
        for (int i = 0; i < content.length; i++) {
            clone[i] += operand;
        }
        return clone;
    }

    public double[] concat(double[] first, double[] second) {
        double[] result = Arrays.copyOf(first, first.length + second.length);
        System.arraycopy(second, 0, result, first.length, second.length);

        return result;
    }

    private double gcd(double[] content) {
        double result = content[0];
        for (int i = 1; i < content.length; i++) {
            result = gcd(result, content[i]);
        }
        return result;
    }

    private double gcd(double a, double b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    public int getRank() {
        Matrix x = echelonForm();

        int rank = 0;
        for (double[] doubles : x.content) {
            double sum = 0;
            for (double aDouble : doubles) {
                sum += aDouble;
            }
            if (Math.abs(sum) == 0)
                rank++;
        }
        return x.content.length - rank;
    }

    public double getTrace() throws Exception {
        if (getHeight() != getWidth())
            throw new Exception("Matrix should be square matrix!");

        double sum = 0;
        for (int i = 0; i < getHeight(); i++) {
            sum += content[i][i];
        }

        return sum;
    }

    public Matrix eigenValues() throws Exception {
        Matrix y = new Matrix(getHeight(), 1);
        y.setContent(1);

        for (int i = 1; i < 10; i++) {
            Matrix pre = this.power(i - 1).mul(y);
            Matrix in = this.power(i).mul(y);

            y = in.divide(pre);
        }
        return y;
    }

    public Matrix getIdentity() throws Exception {
        if (getHeight() != getWidth())
            throw new IllegalStateException("Matrix has not identity");
        double[][] v = new double[getWidth()][getWidth()];


        for (int i = 0; i < getHeight(); i++) {
            v[i][i] = 1;

        }
        return new Matrix("I").setContent(v);
    }

    public Matrix copy() throws Exception {
        Matrix matrix = new Matrix(name);
        matrix.content = this.content.clone();
        return matrix;
    }


    public boolean isDivisionByZero(MathObject o) throws Exception {

        return cast(o).contains(0);
    }


    public boolean isMultipliable(MathObject o) throws Exception {
        Matrix b = cast(o);
        return getWidth() == b.getHeight();
    }

    @Override
    public Matrix cast(MathObject o) throws Exception {
        if (!(o instanceof Matrix))
            throw new TypeConversionException("Can not convert non matrix '" + o.getName() + "' to matrix");
        return (Matrix) o;
    }
}