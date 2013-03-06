/*
 * Copyright (c) 2013, Phsys and/or its affiliates. All rights reserved.
 *  Phsys PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package ir.pooyahfp.matrixcli.commands;

import java.util.Enumeration;
import java.util.List;
import java.util.ResourceBundle;

/**
 * @author : Pooya husseini
 *         Email : info@pooya-hfp.ir
 *         Date: 2/19/13
 *         Time: 10:58 AM
 */
public class UsageCommand extends AbstractCommand {

    @Override
    public void execute(List<String> params, List<String> values) throws Exception {
        ResourceBundle rb = ResourceBundle.getBundle("usage");

        if (params.size() <= 0) {
            StringBuilder builder = new StringBuilder();
            builder.append("Command line Matrix manipulation program\n")
                    .append("Usage : \n\n")
                    .append("Choose one of these options:\n");
            Enumeration<String> keys = rb.getKeys();
            while (keys.hasMoreElements()) {
                builder.append(keys.nextElement().replace(".", " ")).append("\n");
            }
            getWriter().println(
                    builder.toString()
            );
         }

        for (String param : params) {
            getWriter().println(rb.getString("usage." + param));
        }
    }
}