package matrix.commands;

import matrix.Matrix;
import matrix.MatrixOperations;

import java.util.List;

public class LuCommand extends AbstractCommand {
    @Override
    public void execute(List<String> params) throws Exception {
        if (params.size() < 3)
            throw new IllegalArgumentException("Input should has 3 parameters");

        Matrix a = getMatrix(params.get(0));
        Matrix l = getMatrix(params.get(1));
        Matrix u = getMatrix(params.get(2));

        MatrixOperations.lu(a, l, u);

        persistMatrix(a, l, u);

    }
}