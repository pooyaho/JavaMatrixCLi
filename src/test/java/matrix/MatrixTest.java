/*
 * Copyright (c) 2013, Phsys and/or its affiliates. All rights reserved.
 *  Phsys PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package matrix;

import com.agileapes.motorex.string.scan.DocumentScanner;
import com.agileapes.motorex.string.scan.SnippetParser;
import com.agileapes.motorex.string.scan.impl.EnclosedSnippetParser;
import com.agileapes.motorex.string.scan.impl.IdentifierParser;
import com.agileapes.motorex.string.scan.impl.PositionAwareDocumentScanner;
import com.agileapes.motorex.string.token.Token;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @author : Pooya husseini
 *         Email : info@pooya-hfp.ir
 *         Date: 2/20/13
 *         Time: 3:11 PM
 */
public class MatrixTest {
    @Test
    public void testSetContent() throws Exception {
        Matrix x = new Matrix(3, 3, "a");
        x.setContent(1);
        for (double[] doubles : x.getContent()) {
            Assert.assertArrayEquals(doubles, new double[]{1, 1, 1}, 0);
        }

    }


    @Test
    public void testGetName() throws Exception {

    }

    @Test
    public void testSetName() throws Exception {

    }

    @Test
    public void testGetWidth() throws Exception {

    }

    @Test
    public void testSetWidth() throws Exception {

    }

    @Test
    public void testGetHeight() throws Exception {

    }

    @Test
    public void testSetHeight() throws Exception {

    }

    @Test
    public void testGetContent() throws Exception {

    }


    @Test
    public void testSetMatrix() throws Exception {

    }

    @Test
    public void testRemoveRow() throws Exception {

    }

    @Test
    public void testRemoveColumn() throws Exception {

    }

    @Test
    public void testGetTranspose() throws Exception {

    }

    @Test
    public void testToString() throws Exception {

    }

    @Test
    public void testDivide() throws Exception {

    }

    @Test
    public void testDeterminant() throws Exception {

    }

    @Test
    public void testIsDeterministic() throws Exception {

    }

    @Test
    public void testIsInvertible() throws Exception {

    }

    @Test
    public void testRemoveRowAndCol() throws Exception {

    }

    @Test
    public void testCofactor() throws Exception {

    }

    @Test
    public void testInvert() throws Exception {

    }

    @Test
    public void testGetRow() throws Exception {

    }

    @Test
    public void testAdd() throws Exception {

    }

    @Test
    public void testSub() throws Exception {

    }

    @Test
    public void testMul() throws Exception {

    }

    @Test
    public void testPower() throws Exception {

    }

    @Test
    public void testLu() throws Exception {

    }

    @Test
    public void testEchelonForm() {
        double[][] a = {
                {2, 4, 1, 3},
                {-1, -2, 1, 0},
                {0, 0, 2, 2},
                {3, 6, 2, 5}
        };
        Matrix p = new Matrix("P", a);
        System.out.println(p.echelonForm());
    }

    @Test
    public void testEigenValues() {
        Matrix matrix = new Matrix();
        System.out.println(matrix.eigenValues());
    }

    @Test
    public void testSetScanner() {
        String document = "set x {1,2,3,4}";
        final DocumentScanner scanner = new PositionAwareDocumentScanner(document);
        scanner.read("\\s*");

        String command = scanner.parse(new SnippetParser() {
            @Override
            public Token parse(DocumentScanner scanner) {
                int offset = scanner.read("\\s*").length();
                String commandName = scanner.expect(Pattern.compile(IdentifierParser.IDENTIFIER_PATTERN));
                System.out.println("commandName = " + commandName);
                scanner.read("\\s*");
                String identifier = scanner.expect(Pattern.compile(IdentifierParser.IDENTIFIER_PATTERN));
                scanner.read("\\s*");
                String firstDimension = scanner.parse(new EnclosedSnippetParser("[", "]"));
                if (!firstDimension.isEmpty()) {
                    scanner.expect("]");
                }
                scanner.read("\\s*");
                String secondDimension = scanner.parse(new EnclosedSnippetParser("[", "]"));
                if (!secondDimension.isEmpty()) {
                    scanner.expect("]");
                }
                scanner.read("\\s*");
                scanner.expect("{");
                final List<Integer> values = new ArrayList<Integer>();
                while (!scanner.has("}")) {
                    scanner.read("\\s*");
                    values.add(Integer.parseInt(scanner.expect(Pattern.compile("\\d+"))));
                    scanner.read("\\s*");
                    if (!scanner.has("}")) {
                        scanner.expect(Pattern.compile("\\s*,\\s*"));
                    }
                }
                scanner.expect("}");
                return null;
            }
        });
        System.out.println("command = " + command);
    }

    @Test
    public void testSimpleCommandScanner() {
        String document = "set x y er 3 5 6 u    ";
        final DocumentScanner scanner = new PositionAwareDocumentScanner(document);
        scanner.read("\\s*");

        scanner.parse(new SnippetParser() {
            @Override
            public Token parse(DocumentScanner scanner) {
                scanner.read("\\s*");
                String commandName = scanner.expect(Pattern.compile(".*;"));
                System.out.println("commandName = " + commandName);

                while (scanner.remaining() > 0) {
                    scanner.read("\\s*");
                    if (scanner.remaining() <= 0)
                        continue;
                    String identifier = scanner.expect(Pattern.compile("(\\d+)|(\\w+)"));
                    System.out.println(identifier);
                }

                return null;
            }
        });

    }

    @Test
    public void testMultiCommandScanner() {
        String document = "set x y er 3 5 6 u    ";
        final DocumentScanner scanner = new PositionAwareDocumentScanner(document);
        String command;
        while (!(command = scanner.readUntil(";")).isEmpty()) {
            System.out.println(command);
            scanner.read(";");
        }
    }
}