package matrix.commands;

import matrix.Matrix;
import matrix.SaveLoad;

import java.util.List;

/**
 * User: e.amoli and pooya.hfp
 * Date: 1/23/13
 * Time: 2:01 PM
 */
public class SaveCommand extends AbstractCommand {

    @Override
    public void execute(List<String> params) throws Exception {
        if (params.size() < 2)
            throw new IllegalArgumentException("Save should have 2 parameters");
        String name = params.get(0);
        String path = params.get(1);
        Matrix matrix = getMatrix(name);
        SaveLoad.saveObject(path, matrix);
    }
}