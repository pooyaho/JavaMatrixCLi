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

package com.agileapes.motorex.string.token;

/**
 * A token is a marker inside a stream, that designates a special portion of that stream.
 *
 * @author Mohammad Milad Naseri (m.m.naseri@gmail.com)
 * @since 1.0 (2012/12/7, 18:22)
 */
public interface Token {

    /**
     * @return the offset distance of this token from the beginning of the stream
     */
    int getOffset();

    /**
     * @return the length of the token, in terms verifiable by and conforming to the definition of
     * the stream being used
     */
    int getLength();

}
