/*
 * Copyright (c) 2013, Phsys and/or its affiliates. All rights reserved.
 *  Phsys PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package ir.pooyahfp.matrix.commands;

import java.util.List;

/**
 * @author : Pooya husseini
 *         Email : info@pooya-hfp.ir
 *         Date: 1/23/13
 *         Time: 2:14 PM
 */
public class DeleteCommand extends AbstractCommand {


    @Override
    public void execute(List<String> params, List<String> values) throws Exception {
        if (params.size() < 1)
            throw new IllegalArgumentException("Input should has 2 or 3 parameters");

        for (String param : params) {
            deleteMatrix(param);
        }


    }


}