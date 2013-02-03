package matrix.commands;

import matrix.Matrix;

import java.util.List;

/**
 * User: e.amoli and pooya.hfp
 * Date: 1/23/13
 * Time: 2:12 PM
 */
public class PowerCommand extends AbstractCommand {
    @Override
    public void execute(List<String> params) throws Exception {
        if (params.size() < 2)
            throw new IllegalArgumentException("Input should has 2 or 3 parameters");

        Matrix matrix1;
        int pow;
        Matrix resultMatrix = null;
        if (params.size() == 3) {

            matrix1 = getMatrix(params.get(1));
            pow = Integer.parseInt(params.get(2));

            resultMatrix = matrix1.power(pow);
            resultMatrix.setName(params.get(0));

        } else if (params.size() == 2) {
            matrix1 = getMatrix(params.get(0));
            pow = Integer.parseInt(params.get(1));

            resultMatrix = matrix1.power(pow);

            resultMatrix.setName(matrix1.getName());
        }
        persistMatrix(resultMatrix);
    }
}
