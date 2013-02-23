/*
 * Copyright (c) 2013, Phsys and/or its affiliates. All rights reserved.
 *  Phsys PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.agileapes.motorex.string.scan.impl;

import com.agileapes.motorex.string.exception.IllegalScannerSnapshotException;
import com.agileapes.motorex.string.exception.ImmatureEndOfDocumentException;
import com.agileapes.motorex.string.exception.MissingExpectedTokenException;
import com.agileapes.motorex.string.exception.NoParserAvailableException;
import com.agileapes.motorex.string.scan.DocumentScanner;
import com.agileapes.motorex.string.scan.ScannerSnapshot;
import com.agileapes.motorex.string.scan.SnippetParser;
import com.agileapes.motorex.string.text.PatternFactory;
import com.agileapes.motorex.string.text.PositionAwareTextHandler;
import com.agileapes.motorex.string.text.impl.DefaultPatternFactory;
import com.agileapes.motorex.string.text.impl.SimplePositionHandler;
import com.agileapes.motorex.string.token.Token;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Mohammad Milad Naseri (m.m.naseri@gmail.com)
 * @since 1.0 (2012/12/7, 19:38)
 */
public class PositionAwareDocumentScanner implements DocumentScanner, PositionAwareTextHandler {

    private final SimplePositionHandler positionHandler;
    private final SnippetParser parser;
    private String document;
    private PatternFactory patternFactory;
    private int cursor;
    private Stack<PositionAwareScannerSnapshot> marks;

    public PositionAwareDocumentScanner(String document) {
        this(document, new DefaultPatternFactory(Pattern.DOTALL | Pattern.MULTILINE), null);
    }

    public PositionAwareDocumentScanner(String document, PatternFactory patternFactory) {
        this(document, patternFactory, null);
    }

    public PositionAwareDocumentScanner(String document, SnippetParser parser) {
        this(document, new DefaultPatternFactory(Pattern.DOTALL | Pattern.MULTILINE), parser);
    }

    public PositionAwareDocumentScanner(String document, PatternFactory patternFactory, SnippetParser parser) {
        if (document == null) {
            throw new NullPointerException();
        }
        this.document = document;
        this.patternFactory = patternFactory;
        this.positionHandler = new SimplePositionHandler();
        this.marks = new Stack<PositionAwareScannerSnapshot>();
        this.parser = parser;
        remember();
        reset();
    }

    @Override
    public String getDocument() {
        return document;
    }

    @Override
    public int getOffset() {
        return cursor;
    }

    @Override
    public char peek() {
        if (remaining() == 0) {
            throw new ImmatureEndOfDocumentException();
        }
        return document.charAt(cursor);
    }

    @Override
    public String peek(int length) {
        if (remaining() < length) {
            throw new ImmatureEndOfDocumentException();
        }
        return document.substring(cursor, cursor + length);
    }

    @Override
    public char read() {
        final char peek = peek();
        cursor ++;
        positionHandler.readChar(peek);
        return peek;
    }

    @Override
    public String read(int length) {
        final String peek = peek(length);
        cursor += length;
        positionHandler.readString(peek);
        return peek;
    }

    @Override
    public String read(String pattern) {
        return read(patternFactory.getPattern(pattern));
    }

    @Override
    public String read(Pattern pattern) {
        final Matcher matcher = pattern.matcher(getRemainder());
        if (matcher.find() && matcher.start() == 0) {
            final String read = matcher.group();
            cursor += read.length();
            positionHandler.readString(read);
            return read;
        }
        return "";
    }

    @Override
    public String readUntil(String... delimiters) {
        String read = "";
        while (remaining() > 0) {
            boolean done = false;
            for (String delimiter : delimiters) {
                if (has(delimiter)) {
                    done = true;
                    break;
                }
            }
            if (done) {
                break;
            }
            read += read();
        }
        return read;
    }

    @Override
    public char expect(char... characters) throws MissingExpectedTokenException {
        final char read = read();
        for (char character : characters) {
            if (read == character) {
                return read;
            }
        }
        throw new MissingExpectedTokenException(characters);
    }

    @Override
    public String expect(String... tokens) throws MissingExpectedTokenException {
        for (String token : tokens) {
            if (has(token)) {
                positionHandler.readString(token);
                cursor += token.length();
                return token;
            }
        }
        throw new MissingExpectedTokenException(tokens);
    }

    @Override
    public String expect(Pattern... patterns) throws MissingExpectedTokenException {
        for (Pattern pattern : patterns) {
            if (matches(pattern)) {
                return read(pattern);
            }
        }
        throw new MissingExpectedTokenException(patterns);
    }

    @Override
    public boolean has(String... tokens) {
        for (String token : tokens) {
            if (getRemainder().startsWith(token)) {
                return true;
            }
        }
        return false;
    }
    @Override
    public boolean contains(String... tokens) {
        for (String token : tokens) {
            if (getRemainder().contains(token)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean matches(String pattern) {
        return matches(patternFactory.getPattern(pattern));
    }

    @Override
    public boolean matches(Pattern pattern) {
        final Matcher matcher = pattern.matcher(getRemainder());
        return matcher.find() && matcher.start() == 0;
    }

    @Override
    public int length() {
        return document.length();
    }

    @Override
    public int remaining() {
        return document.length() - cursor;
    }

    @Override
    public void push(String text) {
        document = document.substring(0, cursor) + text + getRemainder();
    }

    @Override
    public void reset() {
        restore(marks.peek());
    }

    @Override
    public void rewind() {
        cursor = 0;
        positionHandler.reset();
    }

    @Override
    public ScannerSnapshot remember() {
        final PositionAwareScannerSnapshot snapshot = new PositionAwareScannerSnapshot(document, cursor, getLine(), getColumn());
        marks.push(snapshot);
        return snapshot;
    }

    @Override
    public void forget() {
        if (marks.size() > 1) {
            marks.pop();
        }
    }

    @Override
    public void restore(ScannerSnapshot snapshot) {
        if (!(snapshot instanceof PositionAwareTextHandler)) {
            throw new IllegalScannerSnapshotException();
        }
        this.document = snapshot.getDocument();
        if (document == null) {
            throw new IllegalScannerSnapshotException();
        }
        this.cursor = snapshot.getOffset();
        if (document.length() < cursor) {
            throw new IllegalScannerSnapshotException();
        }
        this.positionHandler.restore(((PositionAwareTextHandler) snapshot).getLine(), ((PositionAwareTextHandler) snapshot).getColumn());
    }

    @Override
    public String parse(SnippetParser parser) {
        if (parser == null) {
            throw new NoParserAvailableException();
        }
        final ScannerSnapshot snapshot = remember();
        final int marked = marks.size();
        final Token parsed = parser.parse(this);
        //This is to make sure that the snapshot set by the scanner is not
        //forgotten during parsing
        if (marked > marks.size()) {
            throw new IllegalScannerSnapshotException();
        }
        //This is to clean up after untidy parsing with loose snapshots
        while (marks.size() > marked) {
            forget();
        }
        //if {@code null} is returned, we will assume that the parser
        //did not find anything useful, and we will have to restore any
        //actions taken by the parser
        int processedLength = parsed == null ? 0 : parsed.getOffset() + parsed.getLength();
        restore(snapshot);
        forget();
        if (processedLength == 0) {
            return "";
        }
        final String read = read(processedLength);
        return read.substring(parsed.getOffset());
    }

    @Override
    public String parse() {
        return parse(getSnippetParser());
    }

    @Override
    public String getRemainder() {
        return document.substring(cursor);
    }

    @Override
    public SnippetParser getSnippetParser() {
        return parser;
    }

    @Override
    public int getLine() {
        return positionHandler.getLine();
    }

    @Override
    public int getColumn() {
        return positionHandler.getColumn();
    }

}
