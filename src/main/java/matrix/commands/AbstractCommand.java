package matrix.commands;

import matrix.Matrix;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: e.amoli and pooya.hfp
 * Date: 1/23/13
 * Time: 1:59 PM
 */
public abstract class AbstractCommand {

    public abstract void execute(List<String> params) throws Exception;

    private final static Map<String, Matrix> matrixMap = new HashMap<String, Matrix>();

    protected void persistMatrix(Matrix... args) {
        for (Matrix matrix : args)
            matrixMap.put(matrix.getName(), matrix);
    }

    protected Matrix getMatrix(String name) throws Exception {
        Matrix matrix = matrixMap.get(name);
        if (matrix == null)
            throw new Exception("Matrix " + name + " not found!");
        return matrixMap.get(name);
    }
}