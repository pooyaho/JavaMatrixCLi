package matrix;

/**
 * User: e.amoli - pooya.hfp
 * Date: 1/26/13
 * Time: 10:58 AM
 */
public class LUDecomposition {

    private double[][] LU;

    private int m;
    private int n;

    public LUDecomposition(Matrix A) {

        LU = A.getContent();
        m = A.getHeight();
        n = A.getWidth();

        int[] piv = new int[m];
        for (int i = 0; i < m; i++) {
            piv[i] = i;
        }
        int pivsign = 1;
        double[] LUrowi;
        double[] LUcolj = new double[m];

        for (int j = 0; j < n; j++) {

            for (int i = 0; i < m; i++) {
                LUcolj[i] = LU[i][j];
            }

            for (int i = 0; i < m; i++) {
                LUrowi = LU[i];

                int kmax = Math.min(i, j);
                double s = 0.0;
                for (int k = 0; k < kmax; k++) {
                    s += LUrowi[k] * LUcolj[k];
                }

                LUrowi[j] = LUcolj[i] -= s;
            }
            int p = j;
            for (int i = j + 1; i < m; i++) {
                if (Math.abs(LUcolj[i]) > Math.abs(LUcolj[p])) {
                    p = i;
                }
            }
            if (p != j) {
                for (int k = 0; k < n; k++) {
                    double t = LU[p][k];
                    LU[p][k] = LU[j][k];
                    LU[j][k] = t;
                }
                int k = piv[p];
                piv[p] = piv[j];
                piv[j] = k;
                pivsign = -pivsign;
            }

            if (j < m & LU[j][j] != 0.0) {
                for (int i = j + 1; i < m; i++) {
                    LU[i][j] /= LU[j][j];
                }
            }
        }
    }

    public Matrix getL() {
        Matrix X = new Matrix(m, n);
        double[][] L = X.getContent();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i > j) {
                    L[i][j] = LU[i][j];
                } else if (i == j) {
                    L[i][j] = 1.0;
                } else {
                    L[i][j] = 0.0;
                }
            }
        }
        return X;
    }

    public Matrix getU() {
        Matrix X = new Matrix(n, n);
        double[][] U = X.getContent();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i <= j) {
                    U[i][j] = LU[i][j];
                } else {
                    U[i][j] = 0.0;
                }
            }
        }
        return X;
    }
}
