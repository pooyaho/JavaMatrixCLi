/*
 * Copyright (c) 2013, Phsys and/or its affiliates. All rights reserved.
 *  Phsys PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package ir.pooyahfp.matrixcli.commands;

import ir.pooyahfp.matrixcli.matrix.SimpleObject;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * @author : Pooya husseini
 *         Email : info@pooya-hfp.ir
 *         Date: 1/23/13
 *         Time: 2:16 PM
 */
public class ShowCommand extends AbstractCommand {

    @Override
    public void execute(@NotNull List<String> params, List<String> values)  {
        if (params.size() == 1 && "all".equalsIgnoreCase(params.get(0))) {
            for (SimpleObject matrix : getAllObjects()) {
                getWriter().println(matrix);
            }
            return;
        }

        for (String name : params) {
            if (hasMathObject(name)) {
                getWriter().println(getMathObject(name));
            }
        }
    }
}
