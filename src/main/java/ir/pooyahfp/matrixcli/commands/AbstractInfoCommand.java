/*
 * Copyright (c) 2013, Phsys and/or its affiliates. All rights reserved.
 *  Phsys PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package ir.pooyahfp.matrixcli.commands;

import org.jetbrains.annotations.NotNull;

import java.util.Enumeration;
import java.util.List;
import java.util.ResourceBundle;

/**
 * @author : Pooya husseini
 *         Email : info@pooya-hfp.ir
 *         Date: 4/8/13
 *         Time: 4:17 PM
 */
public abstract class AbstractInfoCommand extends AbstractCommand {

    @Override
    public void execute(@NotNull List<String> params, List<String> values) throws IllegalAccessException, InstantiationException {
        ResourceBundle rb = ResourceBundle.getBundle(getInfoType());

        if (params.size() <= 0) {
            StringBuilder builder = new StringBuilder();
            builder.append("Command line Matrix manipulation program\n")
                    .append(getInfoType())
                    .append(": \n\n")
                    .append("Choose one of these options:\n");
            Enumeration<String> keys = rb.getKeys();
            while (keys.hasMoreElements()) {
                builder.append(keys.nextElement().replace(".", " ")).append("\n");
            }
            getWriter().println(builder.toString());
        }

        for (String param : params) {
            String key = getInfoType() + "." + param;
            if (rb.containsKey(key)) {
                getWriter().println(rb.getString(key));
            } else {
                getWriter().println("Command not found!");
            }
        }
    }

    @NotNull
    protected abstract String getInfoType();
}
