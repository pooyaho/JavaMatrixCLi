package matrix;

import java.text.MessageFormat;

/**
 * User: e.amoli - pooya.hfp
 * Date: 1/26/13
 * Time: 10:58 AM
 */
public class MatrixOperations {

    public static Matrix add(Matrix a, Matrix b) {
        if (a.getWidth() != b.getWidth() || a.getHeight() != b.getHeight()) {
            throw new IllegalArgumentException("Input Matrixes should have same dimensions");
        }

        Matrix temp = new Matrix(a.getHeight(), a.getWidth());

        for (int i = 0; i < a.getHeight(); i++) {
            for (int j = 0; j < a.getWidth(); j++) {
                temp.setContent(a.getContent(i, j) + b.getContent(i, j), i, j);
            }
        }

        return temp;
    }

    public static Matrix sub(Matrix a, Matrix b) {

        if (a.getWidth() != b.getWidth() || a.getHeight() != b.getHeight()) {
            throw new IllegalArgumentException("Input Matrixes should have same dimensions");
        }

        Matrix temp = new Matrix(a.getWidth(), a.getHeight(), a.getName() + "-" + b.getName());

        for (int i = 0; i < a.getHeight(); i++) {
            for (int j = 0; j < a.getWidth(); j++) {
                temp.setContent(a.getContent(i, j) - b.getContent(i, j), i, j);
            }
        }

        return temp;
    }

    public static Matrix mul(Matrix a, Matrix b) {

        if (a.getWidth() != b.getHeight()) {
            throw new IllegalArgumentException(MessageFormat.format("A:Rows: {0} did not match B:Columns {1}.",
                    a.getWidth(), b.getHeight()));
        }

        Matrix temp = new Matrix(a.getHeight(), b.getWidth());

        double[][] result = new double[a.getHeight()][b.getWidth()];

        for (int i = 0; i < a.getHeight(); i++) {
            for (int j = 0; j < b.getWidth(); j++) { // bColumn
                for (int k = 0; k < a.getWidth(); k++) { // aColumn
                    result[i][j] += a.getContent(i, k) * b.getContent(k, j);
                }
            }
        }

        temp.setContent(result);
        return temp;
    }


    public static void copy(Matrix a, Matrix b) {
        a.setMatrix(b);
    }

    public static void swap(Matrix a, Matrix b) {
        String temp = a.getName();
        a.setName(b.getName());
        b.setName(temp);
    }

    public static Matrix power(Matrix a, int c) {
        Matrix temp = new Matrix(a.getHeight(), a.getWidth());
        copy(temp, a);
        for (int i = 1; i < c; i++) {
            temp.setMatrix(mul(temp, a));
        }
        return temp;
    }

    public static Matrix transpose(Matrix a) {
        return a.getTranspose();
    }

    public static Matrix hamsaze(Matrix a) {
        return a.hamsaze();
    }

    public static double determinant(Matrix a) {
        return a.determinant();
    }

    public static Matrix invert(Matrix a) {
        return a.invert();
    }

    public static void lu(Matrix a, Matrix l, Matrix u) throws Exception {
        if (a.getHeight() != a.getWidth())
            throw new Exception("Can not decompose");

        LUDecomposition luDecomposition = new LUDecomposition(a);
        l.setMatrix( luDecomposition.getL());
        u.setMatrix(luDecomposition.getU());

    }
}
