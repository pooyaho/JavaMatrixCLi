/*
 * Copyright (c) 2013, Phsys and/or its affiliates. All rights reserved.
 *  Phsys PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package ir.pooyahfp.matrixcli;

import com.agileapes.motorex.string.scan.DocumentScanner;
import com.agileapes.motorex.string.scan.SnippetParser;
import com.agileapes.motorex.string.scan.impl.EnclosedSnippetParser;
import com.agileapes.motorex.string.scan.impl.IdentifierParser;
import com.agileapes.motorex.string.scan.impl.PositionAwareDocumentScanner;
import com.agileapes.motorex.string.token.Token;
import ir.pooyahfp.matrixcli.matrix.MatrixObject;
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
    public void testSetContent()  {
        MatrixObject x = new MatrixObject(3, 3, "a").setContent(1);

        for (double[] doubles : x.getContent()) {
            Assert.assertArrayEquals(doubles, new double[]{1, 1, 1}, 0);
        }

    }


    @Test
    public void testGetName()  {
        MatrixObject x = new MatrixObject("A");
        Assert.assertEquals(x.getName(), "A");
    }

    @Test
    public void testSetName()  {
        MatrixObject x = new MatrixObject("A");
        x.setName("B");
        Assert.assertEquals(x.getName(), "B");
    }

    @Test
    public void testGetWidth()  {
        MatrixObject x = new MatrixObject(10, 10, "A");

        Assert.assertEquals(x.getWidth(), 10);
    }

    @Test
    public void testSetWidth()  {

        MatrixObject x = new MatrixObject(10, 10, "A");
        boolean ex = false;

        try {
            x.setWidth(0);
        } catch (Exception y) {
            ex = true;
        }
        Assert.assertTrue(ex);

        x = x.setWidth(200);
        Assert.assertEquals(x.getWidth(), 200);
        Assert.assertEquals(x.getContent()[0].length, 200);
    }

    @Test
    public void testGetHeight()  {
        MatrixObject x = new MatrixObject(10, 10, "A");

        Assert.assertEquals(x.getHeight(), 10);
    }

    @Test
    public void testSetHeight()  {
        MatrixObject x = new MatrixObject(10, 10, "A");
        boolean ex = false;

        try {
            x.setHeight(0);
        } catch (Exception y) {
            ex = true;
        }
        Assert.assertTrue(ex);

        x = x.setHeight(200);
        Assert.assertEquals(x.getHeight(), 200);
        Assert.assertEquals(x.getContent().length, 200);
    }

    @Test
    public void testGetContent()  {
        MatrixObject x = new MatrixObject(2, 2, "A").setContent(new double[]{1, 2, 3, 4});
        Assert.assertArrayEquals(x.getContent()[0], new double[]{1, 2}, 0);
        Assert.assertArrayEquals(x.getContent()[1], new double[]{3, 4}, 0);
    }


    @Test
    public void testSetMatrixObject()  {

        MatrixObject y = new MatrixObject(2, 2, "B").setContent(new double[]{1, 2, 3, 4});

        MatrixObject x = y.copy();
        Assert.assertEquals(x.getName(), "B");
        Assert.assertArrayEquals(x.getContent()[0], new double[]{1, 2}, 0);
        Assert.assertArrayEquals(x.getContent()[1], new double[]{3, 4}, 0);
    }

    @Test
    public void testRemoveRow()  {
        MatrixObject x = new MatrixObject(2, 2, "A").setContent(new double[]{1, 2, 3, 4});

        MatrixObject matrixObject = x.removeRow(0);
        Assert.assertArrayEquals(matrixObject.getContent()[0], new double[]{3, 4}, 0);
    }

    @Test
    public void testRemoveColumn()  {
        MatrixObject x = new MatrixObject(2, 2, "A").setContent(new double[]{1, 2, 3, 4});

        MatrixObject matrixObject = x.removeColumn(0);
        Assert.assertArrayEquals(matrixObject.getContent()[0], new double[]{2}, 0);
        Assert.assertArrayEquals(matrixObject.getContent()[1], new double[]{4}, 0);
    }

    @Test
    public void testGetTranspose()  {
        MatrixObject x = new MatrixObject(2, 2, "A").setContent(new double[]{1, 2, 3, 4});

        MatrixObject transpose = x.getTranspose();
        Assert.assertArrayEquals(transpose.getContent()[0], new double[]{1, 3}, 0);
        Assert.assertArrayEquals(transpose.getContent()[1], new double[]{2, 4}, 0);
    }

    @Test
    public void testToString()  {
        MatrixObject x = new MatrixObject(2, 2, "A").setContent(new double[]{1, 2, 3, 4});

        System.out.println(x);
    }

    @Test
    public void testDivide()  {
        MatrixObject x = new MatrixObject(2, 2, "A").setContent(new double[]{1, 2, 3, 4});

        MatrixObject y = new MatrixObject(2, 2, "B").setContent(new double[]{4, 4, 2, 1});

        MatrixObject divide = x.divide(y);
        Assert.assertArrayEquals(divide.getContent()[0], new double[]{0.25, 0.5}, 0);
        Assert.assertArrayEquals(divide.getContent()[1], new double[]{1.5, 4L}, 0);
    }

    @Test
    public void testDeterminant()  {
        MatrixObject x = new MatrixObject(2, 2, "A").setContent(new double[]{1, 2, 3, 4});

        Assert.assertEquals(x.getDeterminant().doubleValue(), -2L, 0);
    }

    @Test
    public void testIsDeterministic()  {
        MatrixObject x = new MatrixObject(2, 2, "A").setContent(new double[]{1, 2, 3, 4});

        Assert.assertTrue(x.hasDeterminant());
    }

    @Test
    public void testIsInvertible()  {
        MatrixObject x = new MatrixObject(2, 2, "A").setContent(new double[]{1, 2, 3, 4});

        Assert.assertTrue(x.isInvertible());
    }

    @Test
    public void testRemoveRowAndCol()  {
        MatrixObject x = new MatrixObject(2, 2, "A").setContent(new double[]{1, 2, 3, 4});

        MatrixObject matrixObject = x.removeRowAndCol(0, 0);
        Assert.assertEquals(matrixObject.getContent()[0][0], 4L, 0);
    }

    @Test
    public void testCofactor()  {

    }

    @Test
    public void testInvert()  {
        MatrixObject x = new MatrixObject(2, 2, "A").setContent(new double[]{1, 2, 3, 4});

        MatrixObject invert = x.getInvert();
        Assert.assertArrayEquals(invert.getContent()[0], new double[]{-2L, 1L}, 0);
        Assert.assertArrayEquals(invert.getContent()[1], new double[]{1.5, -0.5}, 0);

        x=x.setWidth(3).setHeight(3).setContent(new double[]{1, 2, 3, 4, 5, 6, 7, 8, 9}).copy();

        boolean ex = false;

        try {
            x.getInvert();
        } catch (Exception xx) {
            ex = true;
        }

        Assert.assertTrue(ex);
    }

    @Test
    public void testGetRow()  {
        MatrixObject x = new MatrixObject(2, 2, "A").setContent(new double[]{1, 2, 3, 4});
        Assert.assertArrayEquals(x.getRow(0), new double[]{1L, 2L}, 0);

        boolean ex = false;

        try {
            x.getRow(-2);

        } catch (IllegalArgumentException xx) {
            ex = true;
        }

        Assert.assertTrue(ex);
    }

    @Test
    public void testAdd()  {
        MatrixObject x = new MatrixObject(2, 2, "A").setContent(new double[]{1, 2, 3, 4});

        MatrixObject y = new MatrixObject(2, 2, "A").setContent(new double[]{4, 3, 2, 1});

        MatrixObject add = x.add(y);

        Assert.assertArrayEquals(add.getContent()[0], new double[]{5L, 5L}, 0);
        Assert.assertArrayEquals(add.getContent()[1], new double[]{5L, 5L}, 0);

        y=y.setWidth(3).setHeight(3).setContent(new double[]{1, 2, 3, 4, 5, 6, 7, 8, 9});

        boolean ex = false;

        try {
            x.add(y);

        } catch (IllegalArgumentException xx) {
            ex = true;
        }

        Assert.assertTrue(ex);
    }

    @Test
    public void testSub()  {
        MatrixObject x = new MatrixObject(2, 2, "A").setContent(new double[]{1, 2, 3, 4});

        MatrixObject y = new MatrixObject(2, 2, "A").setContent(new double[]{4, 3, 2, 1});

        MatrixObject sub = x.sub(y);

        Assert.assertArrayEquals(sub.getContent()[0], new double[]{-3L, -1L}, 0);
        Assert.assertArrayEquals(sub.getContent()[1], new double[]{1L, 3L}, 0);

        y=y.setWidth(3).setHeight(3).setContent(new double[]{1, 2, 3, 4, 5, 6, 7, 8, 9});

        boolean ex = false;

        try {
            x.sub(y);

        } catch (IllegalArgumentException xx) {
            ex = true;
        }

        Assert.assertTrue(ex);
    }

    @Test
    public void testMul()  {
        MatrixObject x = new MatrixObject(2, 2, "A").setContent(new double[]{1, 2, 3, 4});

        MatrixObject y = new MatrixObject(2, 2, "A").setContent(new double[]{4, 3, 2, 1});

        MatrixObject mul = x.mul(y);

        Assert.assertArrayEquals(mul.getContent()[0], new double[]{8L, 5L}, 0);
        Assert.assertArrayEquals(mul.getContent()[1], new double[]{20L, 13L}, 0);

        y=y.setWidth(3).setHeight(3).setContent(new double[]{1, 2, 3, 4, 5, 6, 7, 8, 9});

        boolean ex = false;

        try {
            x.mul(y);

        } catch (IllegalArgumentException xx) {
            ex = true;
        }

        Assert.assertTrue(ex);
    }

    @Test
    public void testPower()  {
        MatrixObject x = new MatrixObject(2, 2, "A").setContent(new double[]{1, 2, 3, 4});

        MatrixObject power = x.power(3);

        Assert.assertArrayEquals(power.getContent()[0], new double[]{37L, 54L}, 0);
        Assert.assertArrayEquals(power.getContent()[1], new double[]{81L, 118L}, 0);

        boolean ex = false;

        try {
            x.power(0);

        } catch (IllegalArgumentException xx) {
            ex = true;
        }

        Assert.assertTrue(ex);
    }

    @Test
    public void testLu()  {

    }

    @Test
    public void testEchelonForm() {
        double[][] a = {
                {2, 4, 1, 3},
                {-1, -2, 1, 0},
                {0, 0, 2, 2},
                {3, 6, 2, 5}
        };
        MatrixObject p = new MatrixObject("P").setContent(a);
        System.out.println(p.echelonForm());
    }

    @Test
    public void testEigenValues() {
        MatrixObject matrixObject = new MatrixObject(3, 3, "A");
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
        String document = "set x y er 3 5 6 u   ; ";
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

    @Test
    public void testIdentityMatrixObject()  {
        MatrixObject matrixObject = new MatrixObject(4, 4, "A");
        System.out.println(matrixObject.getIdentity());

    }


}