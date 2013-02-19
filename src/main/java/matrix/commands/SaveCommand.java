/*
 * Copyright (c) 2013, Phsys and/or its affiliates. All rights reserved.
 *  Phsys PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package matrix.commands;

import matrix.Matrix;
import matrix.SaveLoad;

import java.util.List;

/**
* @author : Pooya husseini
 * Email : info@pooya-hfp.ir
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