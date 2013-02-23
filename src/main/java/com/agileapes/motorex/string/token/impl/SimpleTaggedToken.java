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

package com.agileapes.motorex.string.token.impl;

import com.agileapes.motorex.string.token.TaggedToken;

/**
 * @author Mohammad Milad Naseri (m.m.naseri@gmail.com)
 * @since 1.0 (2012/12/7, 18:28)
 */
public class SimpleTaggedToken extends SimpleToken implements TaggedToken {

    private final Object tag;

    public SimpleTaggedToken(int length) {
        this(length, 0, null);
    }

    public SimpleTaggedToken(int length, int offset) {
        this(length, offset, null);
    }

    public SimpleTaggedToken(int length, int offset, Object tag) {
        super(length, offset);
        this.tag = tag;
    }

    @Override
    public Object getTag() {
        return tag;
    }

}
