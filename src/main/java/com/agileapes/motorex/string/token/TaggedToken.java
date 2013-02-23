/*
 * Copyright (c) 2013, Phsys and/or its affiliates. All rights reserved.
 *  Phsys PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.agileapes.motorex.string.token;

/**
 * A tagged token is a token that can carry a tag data so that it can be augmented with
 * additional data, e.g., semantics of the token
 *
 * @author Mohammad Milad Naseri (m.m.naseri@gmail.com)
 * @since 1.0 (2012/12/7, 18:24)
 */
public interface TaggedToken extends Token {

    /**
     * @return the tag meta data for the current token
     */
    Object getTag();

}
