package matrix.commands;

import java.io.IOException;
import java.util.List;

/**
 * User: e.amoli and pooya.hfp
 * Date: 1/23/13
 * Time: 2:16 PM
 */
public class ShowCommand extends AbstractCommand {
    @Override
    public void execute(List<String> params) throws Exception{
        for (String matrixName : params)
            System.out.println(getMatrix(matrixName));
    }
}
