package matrix;

import java.io.Serializable;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * User: e.amoli - pooya.hfp
 * Date: 1/26/13
 * Time: 10:58 AM
 */
public class Matrix implements Serializable {
    private double[][] content;
    private String name;
    private int width;
    private int height;

    public Matrix() {
    }

    public Matrix(int height, int width) {
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


    public void setContent(double[][] content) {
        for (int i = 0; i < content.length; i++) {
            System.arraycopy(content[i], 0, this.content[i], 0, content[0].length);
        }
        this.height = content.length;
        this.width = content[0].length;
    }

    public void setContent(double[] content) {
        for (int i = 0; i < height; i++)
            System.arraycopy(content, i * width, this.content[i], 0, width);
    }

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public double getContent(int i, int j) {
        return content[i][j];
    }

    public double[][] getContent() {
        return content;
    }

    public void setContent(double val, int i, int j) {
        content[i][j] = val;
    }

    public void setMatrix(Matrix x) {
        setContent(x.content);
        setName(x.name);
    }

    public Matrix removeRow(int r) {
        Matrix x = new Matrix(height - 1, width, name);
        x.setContent(removeRow(content, r));

        return x;
    }

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

    // arraye content ra tabdil be yek list mikonad va az aan satre morede nazar ra hazf mikonad
    private double[][] removeRow(double[][] content, int r) {
        List<double[]> l = new ArrayList<double[]>(Arrays.asList(content));
        l.remove(r);
        return l.toArray(new double[][]{});
    }

//    public Matrix getTranspose() {
//        return getTranspose(this.content);
//    }

    public Matrix getTranspose() {
        double temp[][] = new double[this.width][this.height];
        for (int i = 0; i < height; ++i) {
            for (int j = 0; j < width; ++j) {
                temp[j][i] = this.content[i][j];
            }
        }
        Matrix matrix = new Matrix(width, height);
        matrix.setContent(temp);
        matrix.setName(name);

        return matrix;
    }

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

    public double determinant() {
        return determinant(this);
    }

    public boolean isDeterministic() {
        return height == width;
    }

    public boolean isInvertible() {
        return determinant() != 0;
    }

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

    public Matrix removeRowAndCol(int i, int j) {
        Matrix temp = removeRow(i);
        temp.setMatrix(temp.removeColumn(j));
        return temp;
    }

    public Matrix hamsaze() {
        Matrix temp = new Matrix(height, width);
//        Matrix temp = removeRowAndCol(i, j);
//        temp.divide(((i + j) % 2 == 0 ? 1 : -1));
//        temp.setMatrix(temp.removeColumn(j));
//        return temp;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                Matrix hamsaze = this.removeRowAndCol(i, j);
                temp.setContent(((i + j) % 2 == 0 ? 1 : -1) * determinant(hamsaze), i, j);
            }
        }
        return temp;
    }

    public Matrix invert() {
//        Matrix temp = new Matrix(height, width);
        double det = this.determinant();

        return hamsaze().getTranspose().divide(det);
    }

    public double[] getRow(int i) {
        return content[i];
    }

    public Matrix add(Matrix b) {
        if (getWidth() != b.getWidth() || getHeight() != b.getHeight()) {
            throw new IllegalArgumentException("Input Matrixes should have same dimensions");
        }

        Matrix temp = new Matrix(getHeight(), getWidth());

        for (int i = 0; i < getHeight(); i++) {
            for (int j = 0; j < getWidth(); j++) {
                temp.setContent(getContent(i, j) + b.getContent(i, j), i, j);
            }
        }

        return temp;
    }

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

    public Matrix power(int c) {
        Matrix temp = new Matrix(getHeight(), getWidth());
        temp.setMatrix(this);
        for (int i = 1; i < c; i++) {
            temp.setMatrix(temp.mul(this));
        }
        return temp;
    }
    public void lu(Matrix l, Matrix u) throws Exception {
        if (getHeight() != getWidth())
            throw new Exception("Can not decompose");

        LUDecomposition luDecomposition = new LUDecomposition(this);
        l.setMatrix( luDecomposition.getL());
        u.setMatrix(luDecomposition.getU());

    }

}