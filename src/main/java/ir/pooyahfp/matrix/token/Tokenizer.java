/*
 * Copyright (c) 2013, Phsys and/or its affiliates. All rights reserved.
 *  Phsys PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package ir.pooyahfp.matrix.token;

import com.agileapes.motorex.string.scan.DocumentScanner;
import com.agileapes.motorex.string.scan.SnippetParser;
import com.agileapes.motorex.string.scan.impl.EnclosedSnippetParser;
import com.agileapes.motorex.string.scan.impl.IdentifierParser;
import com.agileapes.motorex.string.scan.impl.PositionAwareDocumentScanner;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @author : Pooya husseini
 *         Email : info@pooya-hfp.ir
 *         Date: 1/23/13
 *         Time: 2:50 PM
 */
public class Tokenizer {

    public static List<Token> createToken(String s) {

        List<Token> tokenArrayList = new ArrayList<Token>();

        final DocumentScanner lineScanner = new PositionAwareDocumentScanner(s);
        lineScanner.read("\\s*");

        String command;
        while (!(command = lineScanner.readUntil(";")).isEmpty()) {

            final Token token = new Token();

            final DocumentScanner scanner = new PositionAwareDocumentScanner(command);
            lineScanner.read("\\s*");

            if (scanner.contains("[", "{")) {
                scanner.parse(new SnippetParser() {
                    @Override
                    public com.agileapes.motorex.string.token.Token parse(DocumentScanner scanner) {
                        scanner.read("\\s*");
                        String commandName = scanner.expect(Pattern.compile(IdentifierParser.IDENTIFIER_PATTERN));
                        token.setCommand(commandName);

                        scanner.read("\\s*");
                        String identifier = scanner.expect(Pattern.compile(IdentifierParser.IDENTIFIER_PATTERN));
                        token.addParam(identifier);

                        scanner.read("\\s*");

                        String firstDimension = "";

                        if (scanner.has("[")) {
                            firstDimension = scanner.parse(new EnclosedSnippetParser("[", "]"));
                            scanner.expect("]");
                        }
                        token.addParam(firstDimension);

                        scanner.read("\\s*");
                        String secondDimension = "";

                        if (scanner.has("[")) {
                            secondDimension = scanner.parse(new EnclosedSnippetParser("[", "]"));
                            scanner.expect("]");
                        }
                        token.addParam(secondDimension);

                        scanner.read("\\s*");
                        scanner.expect("{");

                        while (!scanner.has("}")) {
                            scanner.read("\\s*");
                            token.addValue(scanner.expect(Pattern.compile("\\d+")));
                            scanner.read("\\s*");
                            if (!scanner.has("}")) {
                                scanner.expect(Pattern.compile("\\s*,\\s*"));
                            }
                        }
                        scanner.expect("}");
                        return null;
//                    return new SimpleTaggedToken(scanner.getOffset() - offset, offset, new SetCommand.CommandDescriptor
//                            (identifier, Integer.parseInt(firstDimension.isEmpty() ? "-1" : firstDimension),
//                                    Integer.parseInt(secondDimension.isEmpty() ? "-1" : secondDimension),
//                                    values.toArray(new Integer[values.size()])));
                    }
                });

//            StringTokenizer lines = new StringTokenizer(s, ";");
//            while (lines.hasMoreElements()) {
//
//                StringTokenizer tokens = new StringTokenizer((String) lines.nextElement(), " {}");
//                String command = (String) tokens.nextElement();
//                List<String> params = new ArrayList<String>();
//                while (tokens.hasMoreElements()) {
//                    params.add(((String) tokens.nextElement()).toLowerCase());
//                }
//                tokenArrayList.add(new Token(command.toLowerCase(), params));
//            }
//            return tokenArrayList;
//        }

            } else {
                scanner.read("\\s*");

                scanner.parse(new SnippetParser() {

                    @Override
                    public com.agileapes.motorex.string.token.Token parse(DocumentScanner scanner) {
                        scanner.read("\\s*");
                        String commandName = scanner.expect(Pattern.compile(IdentifierParser.IDENTIFIER_PATTERN));
                        token.setCommand(commandName);

                        while (scanner.remaining() > 0) {
                            scanner.read("\\s*");
                            if (scanner.remaining() <= 0)
                                continue;
                            String param = scanner.expect(Pattern.compile("(\\d+)|(\\w+)"));
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