/*
 * Copyright (c) 2013, Phsys and/or its affiliates. All rights reserved.
 *  Phsys PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package ir.pooyahfp.matrixcli.commands;

import ir.pooyahfp.matrixcli.matrix.SimpleObject;
import org.jetbrains.annotations.NotNull;

/**
 * @author : Pooya husseini
 *         Email : info@pooya-hfp.ir
 *         Date: 2/19/13
 *         Time: 5:35 PM
 */
public class DeterminantCommand extends AbstractPrintableCommand {
    @NotNull
    @Override
    public SimpleObject operation(@NotNull SimpleObject simpleObject) {
        return simpleObject.getDeterminant();
    }
}
