package matrix.commands;

import matrix.Matrix;
import matrix.MatrixOperations;

import java.util.List;

/**
 * User: e.amoli and pooya.hfp
 * Date: 1/23/13
 * Time: 2:15 PM
 */
public class CopyCommand extends AbstractCommand {
    @Override
    public void execute(List<String> params) throws Exception {

        if (params.size() < 2)
            throw new IllegalArgumentException("Copy should have 2 parameters");

        Matrix matrix1 = getMatrix(params.get(0));
        Matrix matrix2 = getMatrix(params.get(1));

        MatrixOperations.copy(matrix1, matrix2);

        persistMatrix(matrix1, matrix2);
    }
}
