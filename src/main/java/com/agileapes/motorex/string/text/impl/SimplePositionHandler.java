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

import com.agileapes.motorex.string.text.PositionAwareTextHandler;
import org.jetbrains.annotations.NotNull;

/**
 * @author Mohammad Milad Naseri (m.m.naseri@gmail.com)
 * @since 1.0 (2012/12/7, 19:18)
 */
public class SimplePositionHandler implements PositionAwareTextHandler {

    private int line;
    private int column;

    public SimplePositionHandler(@SuppressWarnings("SameParameterValue") int line, @SuppressWarnings("SameParameterValue") int column) {
        this.line = line;
        this.column = column;
    }

    public SimplePositionHandler() {
        this(1, 1);
    }

    @Override
    public int getLine() {
        return line;
    }

    @Override
    public int getColumn() {
        return column;
    }

    public void offset(int i) {
        column += i;
    }

    public void reset() {
        column = 1;
        line = 1;
    }

    public void readChar(char character) {
        if (character != '\n') {
            column ++;
        } else {
            column = 1;
            line ++;
        }
    }

    public void readString(@NotNull String string) {
        for (int i = 0; i < string.length(); i ++) {
            readChar(string.charAt(i));
        }
    }

    public void restore(int line, int column) {
        this.line = line;
        this.column = column;
    }

}
