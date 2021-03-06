/*
 * Copyright (c) 2013, Phsys and/or its affiliates. All rights reserved.
 *  Phsys PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package ir.pooyahfp.matrixcli.tokenizer;

import com.agileapes.motorex.string.scan.DocumentScanner;
import com.agileapes.motorex.string.scan.SnippetParser;
import com.agileapes.motorex.string.scan.impl.EnclosedSnippetParser;
import com.agileapes.motorex.string.scan.impl.IdentifierParser;
import com.agileapes.motorex.string.scan.impl.PositionAwareDocumentScanner;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @author : Pooya husseini
 *         Email : info@pooya-hfp.ir
 *         Date: 1/23/13
 *         Time: 2:50 PM
 */
public final class Tokenizer {

    private Tokenizer() {
    }

    /**
     * It create a list of token according to the given string. a line can contain infinite commands that separated
     * with semicolon. In this program command has two structure,one of them has {} like set command and others have
     * not. The method start with the tokenizer that tokenize with semicolon. and separates each command,
     * then tokenize them and returns a list of tokens
     *
     * @param s input command string
     * @return a list of token
     */
    @NotNull
    public static List<Token> createToken(String s) {

        List<Token> tokenArrayList = new ArrayList<Token>();

        final DocumentScanner lineScanner = new PositionAwareDocumentScanner(s);
        final String pattern = "\\s*";
        lineScanner.read(pattern);

        String command;
        while (!(command = lineScanner.readUntil(";")).isEmpty()) {

            final Token token = new Token();

            final DocumentScanner scanner = new PositionAwareDocumentScanner(command);
            lineScanner.read(pattern);

            if (scanner.contains("[", "{")) {
                scanner.parse(new SnippetParser() {
                    @Nullable
                    @Override
                    public com.agileapes.motorex.string.token.Token parse(@NotNull DocumentScanner scanner) {
                        scanner.read(pattern);
                        String commandName = scanner.expect(Pattern.compile(IdentifierParser.IDENTIFIER_PATTERN));
                        token.setCommand(commandName);

                        scanner.read(pattern);
                        String identifier = scanner.expect(Pattern.compile(IdentifierParser.IDENTIFIER_PATTERN));
                        token.addParam(identifier);

                        scanner.read(pattern);

                        String firstDimension = "";

                        if (scanner.has("[")) {
                            firstDimension = scanner.parse(new EnclosedSnippetParser("[", "]"));
                            scanner.expect("]");
                        }
                        token.addParam(firstDimension);

                        scanner.read(pattern);
                        String secondDimension = "";

                        if (scanner.has("[")) {
                            secondDimension = scanner.parse(new EnclosedSnippetParser("[", "]"));
                            scanner.expect("]");
                        }
                        token.addParam(secondDimension);

                        scanner.read(pattern);
                        scanner.expect("{");

                        while (!scanner.has("}")) {
                            scanner.read(pattern);
                            token.addValue(scanner.expect(Pattern.compile("\\d+")));
                            scanner.read(pattern);
                            if (!scanner.has("}")) {
                                scanner.expect(Pattern.compile("\\s*,\\s*"));
                            }
                        }
                        scanner.expect("}");
                        return null;
                    }
                });

            } else {
                scanner.read(pattern);

                scanner.parse(new SnippetParser() {

                    @Nullable
                    @Override
                    public com.agileapes.motorex.string.token.Token parse(@NotNull DocumentScanner scanner) {
                        scanner.read(pattern);
                        String commandName = scanner.expect(Pattern.compile(IdentifierParser.IDENTIFIER_PATTERN));
                        token.setCommand(commandName);

                        while (scanner.remaining() > 0) {
                            scanner.read(pattern);
                            if (scanner.remaining() <= 0) {
                                continue;
                            }
                            String param = scanner.expect(Pattern.compile("(\\.|\\w|\\d|/)+"));

                            token.addParam(param);
                        }
                        return null;
                    }
                });

            }
            scanner.read(";");
            tokenArrayList.add(token);
        }
        return tokenArrayList;
    }
}