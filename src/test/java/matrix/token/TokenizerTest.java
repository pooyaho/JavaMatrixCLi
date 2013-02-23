/*
 * Copyright (c) 2013, Phsys and/or its affiliates. All rights reserved.
 *  Phsys PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package matrix.token;

import org.junit.Test;

import java.util.List;

/**
 * @author : Pooya husseini
 *         Email : info@pooya-hfp.ir
 *         Date: 2/23/13
 *         Time: 6:58 PM
 */
public class TokenizerTest {
    @Test
    public void testCreateToken() throws Exception {
        String command="set x[1][2]{1,2,3,4,5,6}";
        List<Token> tokens = Tokenizer.createToken(command);
        for (Token t : tokens) {
            System.out.println(t.getCommand());
        }
    }
}
