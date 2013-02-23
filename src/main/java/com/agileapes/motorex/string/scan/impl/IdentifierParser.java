/*
 * Copyright (c) 2013, Phsys and/or its affiliates. All rights reserved.
 *  Phsys PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.agileapes.motorex.string.scan.impl;

import com.agileapes.motorex.string.scan.DocumentScanner;
import com.agileapes.motorex.string.scan.SnippetParser;
import com.agileapes.motorex.string.token.Token;
import com.agileapes.motorex.string.token.impl.SimpleToken;

/**
 * @author Mohammad Milad Naseri (m.m.naseri@gmail.com)
 * @since 1.0 (2012/12/8, 4:24)
 */
public class IdentifierParser implements SnippetParser {

    public static final String IDENTIFIER_PATTERN = "([a-zA-Z_][a-zA-Z_\\d]*)+";

    @Override
    public Token parse(DocumentScanner scanner) {
        return new SimpleToken(scanner.read(IDENTIFIER_PATTERN).length());
    }

}
