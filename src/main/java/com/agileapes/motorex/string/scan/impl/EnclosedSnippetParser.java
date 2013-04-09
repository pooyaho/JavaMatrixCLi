/*
 * Copyright (c) 2013, Phsys and/or its affiliates. All rights reserved.
 *  Phsys PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.agileapes.motorex.string.scan.impl;

import com.agileapes.motorex.string.exception.MissingExpectedTokenException;
import com.agileapes.motorex.string.exception.NoParserAvailableException;
import com.agileapes.motorex.string.scan.DocumentScanner;
import com.agileapes.motorex.string.scan.SnippetParser;
import com.agileapes.motorex.string.token.Token;
import com.agileapes.motorex.string.token.impl.SimpleTaggedToken;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This implementation of {@link com.agileapes.motorex.string.scan.SnippetParser} will allow developers to discover textual data
 * that has been enclosed by a pair of meaningful container characters (e.g., {@code []}, {@code ''},
 * {@code {}}, etc.)
 *
 * @author Mohammad Milad Naseri (m.m.naseri@gmail.com)
 * @since 1.0 (2012/12/7, 21:43)
 */
public class EnclosedSnippetParser implements SnippetParser {

    private final Map<Character, List<Character>> containers = new HashMap<Character, List<Character>>();
    private final SnippetParser fallback;
    private final boolean allowUnenclosed;
    private final boolean acceptNested;
    private final Character escape;

    public EnclosedSnippetParser(String opening, String closing) {
        this(opening, closing, null);
    }

    @SuppressWarnings("WeakerAccess")
    public EnclosedSnippetParser(String opening, String closing, @Nullable SnippetParser fallback) {
        this(opening, closing, fallback, fallback != null, true);
    }

    @SuppressWarnings("WeakerAccess")
    public EnclosedSnippetParser(String opening, String closing, SnippetParser fallback, boolean allowUnenclosed, boolean acceptNested) {
        this(opening, closing, fallback, allowUnenclosed, acceptNested, null);
    }

    @SuppressWarnings("WeakerAccess")
    public EnclosedSnippetParser(@Nullable String opening, @Nullable String closing, SnippetParser fallback, boolean allowUnenclosed, boolean acceptNested, Character escape) {
        this.fallback = fallback;
        this.allowUnenclosed = allowUnenclosed;
        this.acceptNested = acceptNested;
        this.escape = escape;
        if (opening == null || closing == null) {
            throw new NullPointerException();
        }
        if (opening.length() != closing.length() || opening.isEmpty()) {
            throw new IllegalStateException();
        }
        for (int i = 0; i < opening.length(); i++) {
            List<Character> list = containers.get(opening.charAt(i));
            if (list == null) {
                list = new ArrayList<Character>();
            }
            if (!list.contains(closing.charAt(i))) {
                list.add(closing.charAt(i));
            }
            containers.put(opening.charAt(i), list);
        }
    }

    @Nullable
    @Override
    public Token parse(@NotNull DocumentScanner scanner) {
        final char firstChar = scanner.peek();
        final List<Character> closing = containers.get(firstChar);
        //if no valid container can be found, we will check if we can
        //find the first _unenclosed_ token
        if (closing == null) {
            if (!allowUnenclosed) {
                return null;
            }
            if (fallback != null) {
                return fallback.parse(scanner);
            } else {
                final SnippetParser parser = scanner.getSnippetParser();
                if (parser == null) {
                    throw new NoParserAvailableException();
                }
                return parser.parse(scanner);
            }
        }
        //We will keep track of the number of opening and closing characters
        int open = 1;
        String result = "";
        //We skip the first character, as it is the opening character
        int offset = 1;
        scanner.read();
        while (scanner.remaining() > 0) {
            final char next = scanner.read();
            //If this is a valid opening and is _not_ a designated closing
            //for this same opening, and nesting has been enabled, then we
            //have to increase the number of open groups by one
            if (acceptNested && !closing.contains(next) && next == firstChar) {
                if (escape == null || result.isEmpty() || !result.endsWith(Character.toString(escape)) || open != 1) {
                    open++;
                }
            }
            //If a closing has been matched ...
            if (closing.contains(next)) {
                //... if this closing has been escaped, we will continue, otherwise ...
                if (escape == null || result.isEmpty() || !result.endsWith(Character.toString(escape))) {
                    //... we will decrease the number of open groups ...
                    open--;
                    if (open == 0) {
                        //... once we reach zero, we can return
                        return new SimpleTaggedToken(result.length(), offset, open);
                    }
                }
            }
            result += next;
        }
        throw new MissingExpectedTokenException(closing.toArray(new Character[closing.size()]));
    }

}
