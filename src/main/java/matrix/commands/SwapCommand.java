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
public class SwapCommand extends AbstractCommand {

    @Override
    public void execute(List<String> params) throws Exception {
        if (params.size() < 2)
            throw new IllegalArgumentException("Input should has 2 parameters");

        Matrix matrix1 = getMatrix(params.get(0));
        Matrix matrix2 = getMatrix(params.get(1));

        MatrixOperations.swap(matrix1, matrix2);

        persistMatrix(matrix1, matrix2);
    }

}
