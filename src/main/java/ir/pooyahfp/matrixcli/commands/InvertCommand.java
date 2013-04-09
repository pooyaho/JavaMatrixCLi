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
 *         Date: 1/23/13
 *         Time: 2:13 PM
 */
public class InvertCommand extends AbstractUnaryOperation {
    @NotNull
    @Override
    public SimpleObject operation(@NotNull SimpleObject object) {
        return object.getInvert();
    }
}
