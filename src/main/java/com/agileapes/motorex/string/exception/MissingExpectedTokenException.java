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

package com.agileapes.motorex.string.exception;

import java.util.regex.Pattern;

/**
 * @author Mohammad Milad Naseri (m.m.naseri@gmail.com)
 * @since 1.0 (2012/12/7, 19:27)
 */
public class MissingExpectedTokenException extends ScannerException {

    public MissingExpectedTokenException() {
    }

    public MissingExpectedTokenException(String message, Throwable cause) {
        super(message, cause);
    }

    public MissingExpectedTokenException(Throwable cause) {
        super(cause);
    }

    public MissingExpectedTokenException(Character... tokens) {
        this(convertChars(tokens));
    }

    public MissingExpectedTokenException(char... tokens) {
        this(convertChars(convertPrimitive(tokens)));
    }

    public MissingExpectedTokenException(Pattern... patterns) {
        this(convertPatterns(patterns));
    }

    public MissingExpectedTokenException(String... tokens) {
        super("Expected one of the tokens: " + arrayToString(tokens));
    }

    private static Character[] convertPrimitive(char[] chars) {
        final Character[] characters = new Character[chars.length];
        //noinspection ForLoopReplaceableByForEach
        for (int i = 0; i < chars.length; i++) {
            characters[i] = chars[i];
        }
        return characters;
    }

    private static String[] convertChars(Character[] chars) {
        final String[] strings = new String[chars.length];
        for (int i = 0; i < chars.length; i++) {
            strings[i] = chars[i].toString();
        }
        return strings;
    }

    private static String[] convertPatterns(Pattern[] patterns) {
        final String[] strings = new String[patterns.length];
        for (int i = 0; i < patterns.length; i++) {
            strings[i] = patterns[i].toString();
        }
        return strings;
    }

    private static String arrayToString(String[] strings) {
        final StringBuilder builder = new StringBuilder();
        for (int i = 0; i < strings.length; i++) {
            String string = strings[i];
            if (i > 0) {
                builder.append(", ");
            }
            builder.append(string);
        }
        return builder.toString();
    }

}
