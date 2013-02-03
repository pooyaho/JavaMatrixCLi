package matrix.commands;

import matrix.Matrix;
import matrix.MatrixOperations;

import java.io.IOException;
import java.util.List;

/**
 * User: e.amoli and pooya.hfp
 * Date: 1/23/13
 * Time: 2:12 PM
 */
public class SubCommand extends AbstractCommand {
    @Override
    public void execute(List<String> params) throws Exception {
        if (params.size() < 2)
            throw new IllegalArgumentException("Input should has 2 or 3 parameters");

        Matrix matrix1;
        Matrix matrix2;
        Matrix resultMatrix = null;
        if (params.size() == 3) {

            matrix1 = getMatrix(params.get(1));
            matrix2 = getMatrix(params.get(2));
            resultMatrix = MatrixOperations.sub(matrix1, matrix2);
            resultMatrix.setName(params.get(0));

        } else if (params.size() == 2) {
            matrix1 = getMatrix(params.get(0));
            matrix2 = getMatrix(params.get(1));
            resultMatrix = MatrixOperations.sub(matrix1, matrix2);

            resultMatrix.setName(matrix1.getName());
        }


        persistMatrix(resultMatrix);
    }
}
