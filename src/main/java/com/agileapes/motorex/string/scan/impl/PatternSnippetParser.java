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
import com.agileapes.motorex.string.token.impl.SimpleToken;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.regex.Pattern;

/**
 * @author Mohammad Milad Naseri (m.m.naseri@gmail.com)
 * @since 1.0 (2012/12/8, 3:55)
 */
public class PatternSnippetParser implements SnippetParser {

    private final Pattern pattern;

    public PatternSnippetParser(Pattern pattern) {
        this.pattern = pattern;
    }

    public PatternSnippetParser(String pattern) {
        this.pattern = Pattern.compile(pattern, Pattern.DOTALL);
    }

    @Nullable
    @Override
    public Token parse(@NotNull DocumentScanner scanner) {
        if (scanner.matches(pattern)) {
            return new SimpleToken(scanner.read(pattern).length());
        }
        Character quotation;
        if (scanner.has("\"", "'", "`")) {
            quotation = scanner.read();
        } else {
            return null;
        }
        String read = "";
        while (scanner.remaining() > 0 && !scanner.has(quotation.toString())) {
            read += scanner.read();
        }
        scanner.expect(quotation);
        if (pattern.matcher(read).matches()) {
            return new SimpleToken(read.length() + 2);
        }
        return null;
    }

}
