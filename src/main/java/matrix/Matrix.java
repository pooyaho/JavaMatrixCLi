/*
 * Copyright (c) 2013, Phsys and/or its affiliates. All rights reserved.
 *  Phsys PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package matrix;

import java.io.Serializable;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Base Matrix class that has a lot of functions which manipulates matrix data
 *
 * @author : Pooya husseini
 *         Email : info@pooya-hfp.ir
 *         Date: 1/26/13
 *         Time: 10:58 AM
 */
public class Matrix implements Serializable {

    private double[][] content;
    private String name;
    private int width;
    private int height;

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
        this.width = width;
        this.height = height;
        this.content = new double[height][width];
    }

    public Matrix(String name, double[][] content) {
        this.name = name;
        this.width = content[0].length;
        this.height = content.length;
        this.content = content.clone();
    }

    /**
     * Changes the content of the matrix with a 2d double array
     *
     * @param content 2d double array
     */
    public void setContent(double[][] content) {
        for (int i = 0; i < content.length; i++) {
            System.arraycopy(content[i], 0, this.content[i], 0, content[0].length);
        }
        this.height = content.length;
        this.width = content[0].length;
    }

    /**
     * Changes the content of the matrix with a 1d double array
     * It copies row by row of the 1d content array
     *
     * @param content 1d double array
     */
    public void setContent(double[] content) {
        for (int i = 0; i < height; i++)
            System.arraycopy(content, i * width, this.content[i], 0, width);
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
    public void setContent(Integer row, Integer col, double[] content) {
        if (row == null && col != null) {
            for (int i = 0; i < height; i++) {
                this.content[i][col] = content[i];
            }
        } else if (col == null && row != null) {
            System.arraycopy(content, 0, this.content[row], 0, width);
        } else if (col != null && content.length == 1) {
            setContent(content[0], row, col);
        } else {
            setContent(content);
        }
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
        return width;
    }

    /**
     * sets the width of the matrix
     *
     * @param width the with
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * @return height of the matrix
     */
    public int getHeight() {
        return height;
    }

    /**
     * sets the height of the matrix
     *
     * @param height the height
     */
    public void setHeight(int height) {
        this.height = height;
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
    public void setContent(double val) {
        for (double[] doubles : content) {
            Arrays.fill(doubles, val);
        }

    }

    /**
     * changes the cell value
     *
     * @param val new value
     * @param i   cell row
     * @param j   cell column
     */
    public void setContent(double val, int i, int j) {
        content[i][j] = val;
    }

    /**
     * Fills the matrix with the input matrix's name and content
     *
     * @param x new matrix
     */
    public void setMatrix(Matrix x) {
        setContent(x.content);
        setName(x.name);
    }

    /**
     * it removes entire a row
     *
     * @param r desired row
     * @return returns the new matrix without the row
     */
    public Matrix removeRow(int r) {
        Matrix x = new Matrix(height - 1, width, name);
        x.setContent(removeRow(content, r));

        return x;
    }

    /**
     * it removes entire a column
     *
     * @param c desired column
     * @return returns the new matrix without the column
     */
    public Matrix removeColumn(int c) {
        Matrix x = new Matrix(height, width - 1, name);

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < c; j++) {
                x.setContent(content[i][j], i, j);
            }
            for (int j = c + 1; j < width; j++) {
                x.setContent(content[i][j], i, j - 1);
            }
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
        double temp[][] = new double[this.width][this.height];
        for (int i = 0; i < height; ++i) {
            for (int j = 0; j < width; ++j) {
                temp[j][i] = this.content[i][j];
            }
        }
        //noinspection SuspiciousNameCombination
        Matrix matrix = new Matrix(width, height);
        matrix.setContent(temp);
        matrix.setName(name);

        return matrix;
    }

    /**
     * @return returns the string representation of the matrix
     */
    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder();
        builder.append("[[").append(name).append("]]\n");
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
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
    public Matrix divide(double n) {
        Matrix matrix = new Matrix(height, width);
        matrix.setMatrix(this);
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                matrix.content[i][j] /= n;
            }
        }
        return matrix;
    }

    /**
     * divides this matrix with the n matrix cell by cell
     *
     * @param n input matrix
     * @return the divided matrix
     */
    public Matrix divide(Matrix n) {
        if (n.contains(0))
            throw new IllegalArgumentException("Division by zero");

        Matrix matrix = new Matrix(height, width);
        matrix.setMatrix(this);

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
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
    public double determinant() {
        return determinant(this);
    }

    /**
     * @return is the matrix deterministic
     */
    public boolean isDeterministic() {
        return height == width;
    }

    /**
     * @return is the matrix invertible
     */
    public boolean isInvertible() {
        return determinant() != 0;
    }

    /**
     * Calculates determinant of the matrix
     *
     * @param a input matrix
     * @return determinant of the matrix
     */
    private double determinant(Matrix a) {
        if (!a.isDeterministic())
            throw new IllegalArgumentException("Matrix has not determinant");

        if (a.getHeight() == 2 && a.getWidth() == 2)
            //in haman ad -bc ast
            return a.getContent(0, 0) * a.getContent(1, 1) - a.getContent(0, 1) * a.getContent(1, 0);

        double n = 0;

        for (int j = 0; j < width; j++)
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
        Matrix temp = removeRow(i);
        temp.setMatrix(temp.removeColumn(j));
        return temp;
    }

    /**
     * @return returns the cofactor of the matrix
     */
    public Matrix cofactor() {
        Matrix temp = new Matrix(height, width);

//
//        } else {

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                Matrix cofactor = this.removeRowAndCol(i, j);
                temp.setContent(((i + j) % 2 == 0 ? 1 : -1) * determinant(cofactor), i, j);
            }
        }

        return temp;

    }

    /**
     * @return returns the invert of the matrix
     */
    public Matrix invert() {
//        Matrix temp = new Matrix(height, width);
        double[][] temp = content.clone();
        if (!isInvertible())
            throw new IllegalArgumentException("Matrix is not invertible!");
        double det = this.determinant();
        if (height == 2 && width == 2) {
            double a = temp[0][0];
            temp[0][0] = temp[1][1];
            temp[1][1] = a;
            temp[0][1] = -temp[0][1];
            temp[1][0] = -temp[1][0];

            Matrix matrix = new Matrix(name, temp);
            return matrix.divide(det);
        }

        return cofactor().getTranspose().divide(det);
    }

    /**
     * @param i row number
     * @return returns the row in an 1d array
     */
    public double[] getRow(int i) {
        return content[i];
    }

    /**
     * Adds the input matrix to this matrix
     *
     * @param b input matrix
     * @return returns the result of addition
     */
    public Matrix add(Matrix b) {
        if (getWidth() != b.getWidth() || getHeight() != b.getHeight()) {
            throw new IllegalArgumentException("Input matrices should have same dimensions");
        }

        Matrix temp = new Matrix(getHeight(), getWidth());

        for (int i = 0; i < getHeight(); i++) {
            for (int j = 0; j < getWidth(); j++) {
                temp.setContent(getContent(i, j) + b.getContent(i, j), i, j);
            }
        }

        return temp;
    }

    /**
     * Subtracts the input matrix from this matrix
     *
     * @param b input matrix
     * @return returns the result of this-b
     */
    public Matrix sub(Matrix b) {

        if (getWidth() != b.getWidth() || getHeight() != b.getHeight()) {
            throw new IllegalArgumentException("Input Matrixes should have same dimensions");
        }

        Matrix temp = new Matrix(getWidth(), getHeight(), getName() + "-" + b.getName());

        for (int i = 0; i < getHeight(); i++) {
            for (int j = 0; j < getWidth(); j++) {
                temp.setContent(getContent(i, j) - b.getContent(i, j), i, j);
            }
        }

        return temp;

    }

    /**
     * Multiplies the input matrix with this matrix
     *
     * @param b input matrix
     * @return returns the result of this*b
     */
    public Matrix mul(Matrix b) {

        if (getWidth() != b.getHeight()) {
            throw new IllegalArgumentException(MessageFormat.format("A:Rows: {0} did not match B:Columns {1}.",
                    getWidth(), b.getHeight()));
        }

        Matrix temp = new Matrix(getHeight(), b.getWidth());

        double[][] result = new double[getHeight()][b.getWidth()];

        for (int i = 0; i < getHeight(); i++) {
            for (int j = 0; j < b.getWidth(); j++) { // bColumn
                for (int k = 0; k < getWidth(); k++) { // aColumn
                    result[i][j] += getContent(i, k) * b.getContent(k, j);
                }
            }
        }

        temp.setContent(result);
        return temp;
    }

    /**
     * Powers the matrix to input number
     *
     * @param c power number
     * @return returns the result of this^c
     */
    public Matrix power(int c) {
        Matrix temp = new Matrix(getHeight(), getWidth());
        temp.setMatrix(this);
        for (int i = 1; i < c; i++) {
            temp.setMatrix(temp.mul(this));
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
    public void lu(Matrix l, Matrix u) throws Exception {
        if (getHeight() != getWidth())
            throw new Exception("Can not decompose");

        double[][] lu;

        int height;
        int width;

        lu = getContent();
        height = getHeight();
        width = getWidth();

        int[] piv = new int[height];
        for (int i = 0; i < height; i++) {
            piv[i] = i;
        }
        int pivsign = 1;
        double[] LUrowi;
        double[] LUcolj = new double[height];

        for (int j = 0; j < width; j++) {

            for (int i = 0; i < height; i++) {
                LUcolj[i] = lu[i][j];
            }

            for (int i = 0; i < height; i++) {
                LUrowi = lu[i];

                int kmax = Math.min(i, j);
                double s = 0.0;
                for (int k = 0; k < kmax; k++) {
                    s += LUrowi[k] * LUcolj[k];
                }

                LUrowi[j] = LUcolj[i] -= s;
            }
            int p = j;
            for (int i = j + 1; i < height; i++) {
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

            if (j < height & lu[j][j] != 0.0) {
                for (int i = j + 1; i < height; i++) {
                    lu[i][j] /= lu[j][j];
                }
            }
        }

        Matrix lTemp = new Matrix(height, width);

        for (int i = 0; i < height; i++) {
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
        u.setMatrix(uTemp);
        l.setMatrix(lTemp);
    }

    public Matrix echelonForm() {

        double[][] a = content.clone();

        for (int r = 0; r < a.length; r++) {
            if (a[r][r] != 1 && a[r][r] != 0) {
                a[r] = divide(a[r], a[r][r]);
            }
            for (int i = r + 1; i < a.length; i++) {
                a[i] = sub(a[i], multiply(a[r], a[i][r])).clone();
            }
        }

        return new Matrix(name, a);
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
        if (height != width)
            throw new Exception("Matrix should be square matrix!");

        double sum = 0;
        for (int i = 0; i < height; i++) {
            sum += content[i][i];
        }

        return sum;
    }

    public Matrix eigenValues() {
        Matrix y = new Matrix(height, 1);
        y.setContent(1);

        for (int i = 1; i < 10; i++) {
            Matrix pre = this.power(i - 1).mul(y);
            Matrix in = this.power(i).mul(y);

            y = in.divide(pre);
        }
        return y;
    }
}