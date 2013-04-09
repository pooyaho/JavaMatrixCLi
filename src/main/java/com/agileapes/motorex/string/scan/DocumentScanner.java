/*
 * Copyright (c) 2013, Phsys and/or its affiliates. All rights reserved.
 *  Phsys PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.agileapes.motorex.string.scan;

import com.agileapes.motorex.string.exception.MissingExpectedTokenException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.regex.Pattern;

/**
 * This interface will expose functionality expected of a standard parser, plus additional
 * methods to help facilitate the job of walking in a String stream.
 *
 * @author Mohammad Milad Naseri (m.m.naseri@gmail.com)
 * @since 1.0 (2012/12/7, 18:13)
 */
public interface DocumentScanner {

    /**
     * @return the document being scanned in its entirety -- as it is available to the
     * scanner itself
     */
    @Nullable
    String getDocument();

    /**
     * @return current number of characters read from the beginning of the document
     */
    int getOffset();

    /**
     * This will return the next character from the document without changing the
     * position of the cursor
     * @return the next character to be read
     */
    char peek();

    /**
     * This will return the next <em>n</em> characters from the document without changing the
     * position of the cursor
     * @param length    the number of characters to be read
     * @return the characters to come
     */
    String peek(int length);

    /**
     * This will read the next character in the document, moving forward by one
     * @return the next character
     */
    char read();

    /**
     * This will read the specified amount of characters from the document, moving forward
     * as reading, one position per character.
     * @param length    the number of characters to read
     * @return the read data
     */
    String read(int length);

    /**
     * Will read the string matching the specified pattern from the document, or do nothing.
     * @param pattern    the pattern to match the text against
     * @return the read portion of the document, or the empty string ({@code ""}) if the next
     * characters do not match the given pattern
     */
    String read(String pattern);

    /**
     * Will read the string matching the specified pattern from the document, or do nothing.
     * @param pattern    the pattern to match the text against
     * @return the read portion of the document, or the empty string ({@code ""}) if the next
     * characters do not match the given pattern
     * @see #read(String)
     */
    String read(Pattern pattern);

    /**
     * This method will attempt to read from the input document, until reaching one of the
     * specified delimiters, or the end of document
     * @param delimiters    the delimiters signifying the end of required portion
     * @return the portion of the document that was read
     */
    String readUntil(@SuppressWarnings("SameParameterValue") String... delimiters);

    /**
     * This will read the given character from the document, failing if it does not appear
     * @param characters    the characters expecting to appear
     * @return the read character
     * @throws MissingExpectedTokenException
     */
    char expect(char... characters) throws MissingExpectedTokenException;

    /**
     * This will attempt to read one of the given tokens from the input, failing if none exist
     * @param tokens    the tokens to match against
     * @return the read token
     * @throws MissingExpectedTokenException
     */
    @NotNull
    String expect(String... tokens) throws MissingExpectedTokenException;

    /**
     * This will attempt to read a token from the document that matches one of the
     * given patterns. This method fails if no such token exists.
     * @param patterns    the patterns to match againt
     * @return the read token
     * @throws MissingExpectedTokenException
     */
    String expect(Pattern... patterns) throws MissingExpectedTokenException;

    /**
     * This method will check whether the next token in the document is the
     * token specified by the parameter.<br/>
     * <strong>NB</strong> the term token is used somewhat generally here, and does
     * not mean that this interface provides tokenization capabilities on its own.
     * @param tokens    the string to match against
     * @return {@code true} if the remainder of the document starts with the
     * given token
     */
    boolean has(String... tokens);

    boolean contains(String... tokens);
    /**
     * This method will examine whether the remainder of the document matches the given pattern
     * @param pattern    the pattern to use
     * @return {@code true} if a match can be found, starting at the beginning of the remaining
     * text in the document
     */
    boolean matches(String pattern);

    /**
     * This method will examine whether the remainder of the document matches the given pattern
     * @param pattern    the pattern to use
     * @return {@code true} if a match can be found, starting at the beginning of the remaining
     * text in the document
     * @see #matches(String)
     */
    boolean matches(Pattern pattern);

    /**
     * @return the length of the document being scanned
     */
    int length();

    /**
     * @return the remaining number of characters to be scanned.
     */
    int remaining();

    /**
     * This method will push the given text into the document at the position of the cursor
     * @param text    the text to be push ahead
     */
    void push(String text);

    /**
     * This method will reset the flow of text, and set back the position of the cursor
     * to the last remembered position in the document
     */
    void reset();

    /**
     * This method will simply go back to the beginning of the document
     */
    void rewind();

    /**
     * A call to this method will cause the scanner to remember the current position in the
     * document, and thus making subsequent calls to {@link #reset()} to jump to this position
     * @return The snapshot for the current situation
     */
    @NotNull
    ScannerSnapshot remember();

    /**
     * This will undo the latest call to remember, if any
     */
    void forget();

    /**
     * Will restore the scanner to the specification required by the given snapshot
     * @param snapshot    the snapshot of the scanner
     */
    void restore(ScannerSnapshot snapshot);

    /**
     * This method will run the given parser over the remaining of the document
     * @param parser    the parser
     * @return the parsed portion
     */
    String parse(SnippetParser parser);

    /**
     * This method will run the default parser over the remaining of the document
     * @return the parsed portion
     * @see #getSnippetParser()
     * @see #parse(com.agileapes.motorex.string.scan.SnippetParser)
     */
    String parse();

    /**
     * This method will return the unprocessed portion of the text, i.e. from cursor
     * position onwards
     * @return the remainder of the document
     */
    String getRemainder();

    /**
     * @return the default parser used by this scanner
     */
    SnippetParser getSnippetParser();


}
