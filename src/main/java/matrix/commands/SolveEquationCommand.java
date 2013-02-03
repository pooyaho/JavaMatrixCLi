package matrix.commands;

import matrix.Matrix;
import matrix.MatrixOperations;

import java.io.IOException;
import java.util.List;


public class SolveEquationCommand extends AbstractCommand {
    @Override
    public void execute(List<String> params) throws Exception {
        if (params.size() < 3)
            throw new IllegalArgumentException("Input should has 3 parameters");

        Matrix x=getMatrix(params.get(0));
        Matrix a=getMatrix(params.get(1));
        Matrix b=getMatrix(params.get(2));

        MatrixOperations.copy(x,MatrixOperations.mul(a.invert(),b));

        persistMatrix(x);
    }
}
