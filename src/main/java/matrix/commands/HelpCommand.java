/*
 * Copyright (c) 2013, Phsys and/or its affiliates. All rights reserved.
 *  Phsys PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package matrix.commands;

import java.util.List;
import java.util.ResourceBundle;

/**
 *
 * @author : Pooya husseini
 *         Email : info@pooya-hfp.ir
 *         Date: 2/19/13
 *         Time: 10:58 AM
 */
public class HelpCommand extends AbstractCommand {

    @Override
    public void execute(List<String> params) throws Exception {
        if (params.size() <= 0) {
            getWriter().println(
                    "Command line Matrix manipulation program\n" +
                            "Help: \n\n" +
                            "Choose one of these options:\n" +
                            "help matrix\n" +
                            "help set\n" +
                            "help read\n" +
                            "help save\n" +
                            "help show\n" +
                            "help copy\n" +
                            "help swap\n" +
                            "help add\n" +
                            "help sub\n" +
                            "help mul\n" +
                            "help pow\n" +
                            "help inv\n" +
                            "help trn\n" +
                            "help solve\n" +
                            "help lu"
            );
        }
        ResourceBundle rb = ResourceBundle.getBundle("help");

        for (String param : params) {
            getWriter().println(rb.getString("help." + param));
        }
    }

}