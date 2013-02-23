/*
 * Copyright (c) 2013, Phsys and/or its affiliates. All rights reserved.
 *  Phsys PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package ir.pooyahfp.matrix.commands;

import java.util.List;

/**
* @author : Pooya husseini
 * Email : info@pooya-hfp.ir
 * Date: 1/23/13
 * Time: 2:16 PM
 */
public class ShowCommand extends AbstractCommand {
    @Override
    public void execute(List<String> params, List<String> values) throws Exception{
        for (String matrixName : params)
            getWriter().println(getMatrix(matrixName));
    }
}
