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

package com.agileapes.motorex.string.text.impl;

import com.agileapes.motorex.string.text.PatternFactory;

import java.util.regex.Pattern;

/**
 * @author Mohammad Milad Naseri (m.m.naseri@gmail.com)
 * @since 1.0 (2012/12/7, 19:35)
 */
public class DefaultPatternFactory implements PatternFactory {

    private final int flags;

    public DefaultPatternFactory() {
        this(0);
    }

    public DefaultPatternFactory(int flags) {
        this.flags = flags;
    }

    @Override
    public Pattern getPattern(String pattern) {
        return Pattern.compile(pattern, flags);
    }

}
