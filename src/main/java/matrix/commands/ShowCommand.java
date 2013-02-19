/*
 * Copyright (c) 2013, Phsys and/or its affiliates. All rights reserved.
 *  Phsys PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package matrix.commands;

import java.io.IOException;
import java.util.List;

/**
* @author : Pooya husseini
 * Email : info@pooya-hfp.ir
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
