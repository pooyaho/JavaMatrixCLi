/*
 * Copyright (c) 2012. AgileApes (http://www.agileapes.scom/), and
 * associated organization.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this
 * software and associated documentation files (the "Software"), to deal in the Software
 * without restriction, including without limitation the rights to use, copy, modify,
 * merge, publish, distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to the following
 * conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies
 * or substantial portions of the Software.
 */

package com.agileapes.motorex.string.scan.impl;

import com.agileapes.motorex.string.scan.DocumentScanner;
import com.agileapes.motorex.string.scan.SnippetParser;
import com.agileapes.motorex.string.token.Token;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * @author Mohammad Milad Naseri (m.m.naseri@gmail.com)
 * @since 1.0 (2012/12/8, 4:06)
 */
public class DelimitedSnippetParser extends EnclosedSnippetParser {

    private final String[] delimiters;

    public DelimitedSnippetParser(String opening, String closing, String... delimiters) {
        super(opening, closing);
        this.delimiters = delimiters;
    }

    public DelimitedSnippetParser(String opening, String closing, SnippetParser fallback, String... delimiters) {
        super(opening, closing, fallback);
        this.delimiters = delimiters;
    }

    public DelimitedSnippetParser(String opening, String closing, SnippetParser fallback, boolean allowUnenclosed, boolean acceptNested, String... delimiters) {
        super(opening, closing, fallback, allowUnenclosed, acceptNested);
        this.delimiters = delimiters;
    }

    public DelimitedSnippetParser(String opening, String closing, SnippetParser fallback, boolean allowUnenclosed, boolean acceptNested, Character escape, String... delimiters) {
        super(opening, closing, fallback, allowUnenclosed, acceptNested, escape);
        this.delimiters = delimiters;
    }

    @Nullable
    @Override
    public Token parse(@NotNull DocumentScanner scanner) {
        final Token token = super.parse(scanner);
        if (token != null) {
            if (scanner.has(delimiters)) {
                return token;
            }
        }
        return null;
    }
}
