/*
 * Copyright (c) 2013, Phsys and/or its affiliates. All rights reserved.
 *  Phsys PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package ir.pooyahfp.matrixcli.commands;

import ir.pooyahfp.matrixcli.exception.IllegalCommandArguments;

import java.util.List;

/**
 * @author : Pooya husseini
 *         Email : info@pooya-hfp.ir
 *         Date: 1/23/13
 *         Time: 2:14 PM
 */
public class DeleteCommand extends AbstractCommand {
    @Override
    public void execute(List<String> params, List<String> values) {
        if (params.size() < 1) {
            throw new IllegalCommandArguments();
        }

        for (String param : params) {
            deleteMathObject(param);
        }
    }
}