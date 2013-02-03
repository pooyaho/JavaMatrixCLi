package matrix;

/**
 * User: e.amoli - pooya.hfp
 * Date: 1/26/13
 * Time: 10:58 AM
 */
public class MatrixOperations {

    public static void copy(Matrix a, Matrix b) {
        a.setMatrix(b);
    }

    public static void swap(Matrix a, Matrix b) {
        String temp = a.getName();
        a.setName(b.getName());
        b.setName(temp);
    }

    public static Matrix transpose(Matrix a) {
        return a.getTranspose();
    }



}
