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

import com.agileapes.motorex.string.scan.ScannerSnapshot;

/**
 * @author Mohammad Milad Naseri (m.m.naseri@gmail.com)
 * @since 1.0 (2012/12/7, 19:46)
 */
public class SimpleScannerSnapshot implements ScannerSnapshot {

    private final String document;
    private final int offset;

    public SimpleScannerSnapshot(String document, int offset) {
        this.document = document;
        this.offset = offset;
    }

    @Override
    public String getDocument() {
        return document;
    }

    @Override
    public int getOffset() {
        return offset;
    }
}
