/*
 * Copyright (c) 2013, Phsys and/or its affiliates. All rights reserved.
 *  Phsys PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package matrix.token;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
* @author : Pooya husseini
 * Email : info@pooya-hfp.ir
 * Date: 1/23/13
 * Time: 2:50 PM
 */
public class Tokenizer {

    public static List<Token> createToken(String s) {

        List<Token> temp = new ArrayList<Token>();

//        if (!s.trim().endsWith(";"))
//            throw new IllegalArgumentException("Statements should ends with ;");

        StringTokenizer lines = new StringTokenizer(s, ";");
        while (lines.hasMoreElements()) {

            StringTokenizer tokens = new StringTokenizer((String) lines.nextElement(), " {}");
            String command = (String) tokens.nextElement();
            List<String> params = new ArrayList<String>();
            while (tokens.hasMoreElements()) {
                params.add(((String) tokens.nextElement()).toLowerCase());
            }
            temp.add(new Token(command.toLowerCase(), params));
        }
        return temp;
    }

}