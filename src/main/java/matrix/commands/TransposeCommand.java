package matrix.commands;

import matrix.Matrix;
import matrix.MatrixOperations;

import java.io.IOException;
import java.util.List;

/**
 * User: e.amoli and pooya.hfp
 * Date: 1/23/13
 * Time: 2:14 PM
 */
public class TransposeCommand extends AbstractCommand {
    @Override
    public void execute(List<String> params) throws Exception {
        if (params.size() < 1)
            throw new IllegalArgumentException("Invalid parameters");

        Matrix matrix1;
        Matrix resultMatrix = null;
        if (params.size() == 2) {

            matrix1 = getMatrix(params.get(1));
            resultMatrix = MatrixOperations.transpose(matrix1);
            resultMatrix.setName(params.get(0));

        } else if (params.size() == 1) {
            matrix1 = getMatrix(params.get(0));
            resultMatrix = MatrixOperations.transpose(matrix1);

            resultMatrix.setName(matrix1.getName());
        }
        persistMatrix(resultMatrix);

    }

}

