/*
 * Copyright (c) 2013, Phsys and/or its affiliates. All rights reserved.
 *  Phsys PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package matrix.commands;

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
    public void execute(List<String> params) throws Exception {
        if (params.size() <= 0) {
            System.out.println(
                    "Command line Matrix manipulation program\n" +
                            "Usage: \n\n" +
                            "Choose one of these options:\n" +
                            "usage matrix\n" +
                            "usage set\n" +
                            "usage read\n" +
                            "usage save\n" +
                            "usage show\n" +
                            "usage copy\n" +
                            "usage swap\n" +
                            "usage add\n" +
                            "usage sub\n" +
                            "usage mul\n" +
                            "usage pow\n" +
                            "usage inv\n" +
                            "usage trn\n" +
                            "usage solve\n" +
                            "usage lu"
            );
        }
        ResourceBundle rb = ResourceBundle.getBundle("usage");

        for (String param : params) {
            System.out.println(rb.getString("usage." + param));
        }
    }

}