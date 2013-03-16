/*
 * Copyright (c) 2013, Phsys and/or its affiliates. All rights reserved.
 *  Phsys PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package ir.pooyahfp.matrixcli.matrix;

import ir.pooyahfp.matrixcli.exception.NotSupportedException;

/**
 * @author : Pooya husseini
 *         Email : info@pooya-hfp.ir
 *         Date: 3/2/13
 *         Time: 6:28 PM
 */
public class SimpleObject extends Number {

    private String name;
    private Number value;

    public SimpleObject(String name, Number value) {
        this.name = name;
        this.value = value;
    }

    public SimpleObject(Number value) {
        this("", value);
    }

    public SimpleObject(String name) {
        this(name, null);
    }

    public SimpleObject() {
        this(null, null);
    }

    @Override
    public int intValue() {
        return value.intValue();
    }

    @Override
    public long longValue() {
        return value.longValue();
    }

    @Override
    public float floatValue() {
        return value.floatValue();
    }

    @Override
    public double doubleValue() {
        return value.doubleValue();
    }

    public String getName() {
        return name;
    }


    public SimpleObject getTranspose() {
        throw new NotSupportedException("Value does not have transpose");
    }


    public SimpleObject getDeterminant() {
        throw new NotSupportedException("Value does not have determinant");
    }


    public SimpleObject getInvert() {
        throw new NotSupportedException("Value does not have invert");
    }


    public SimpleObject add(SimpleObject b) {
        return new SimpleObject(b.doubleValue() + this.doubleValue());
    }


    public SimpleObject sub(SimpleObject b) {
        return new SimpleObject(this.doubleValue() - b.doubleValue());
    }


    public SimpleObject mul(SimpleObject b) {
        return new SimpleObject(b.doubleValue() * this.doubleValue());
    }


    public SimpleObject power(int c) {
        return new SimpleObject(Math.pow(this.doubleValue(), c));
    }


    public SimpleObject power(SimpleObject o) {
        return power(o.intValue());
    }


    public void lu(SimpleObject l, SimpleObject u) {
        throw new NotSupportedException("Value does not have lu decomposition");
    }


    public SimpleObject echelonForm() {
        throw new NotSupportedException("Value does not have echelon form");
    }


    public SimpleObject getRank() {
        throw new NotSupportedException("Value does not have rank");
    }


    public SimpleObject getTrace() {
        throw new NotSupportedException("Value does not have trace");
    }


    public SimpleObject eigenValues() {
        throw new NotSupportedException("Value does not have Eigen value");
    }

    public SimpleObject copy() {
        return new SimpleObject(name, value);
    }

    public SimpleObject setContent(Integer row, Integer col, double[] content) {
        if (content.length != 1) {
            throw new IllegalArgumentException("Values are more than one");
        }

        return new SimpleObject(name, content[0]);
    }

    public double getEquivalenceValue() {
        return value.doubleValue();
    }

    public void setName(String name) {
        this.name = name;
    }

    public Number getValue() {
        return value;
    }

    public void setValue(Number value) {
        this.value = value;
    }

    public String toString() {
        return "[" + name + "]\n" + value;
    }

    public SimpleObject tryCast(SimpleObject o) {
        throw new NotSupportedException("Simple object could not try to cast");
    }

    public MatrixObject cast(SimpleObject o) {
        throw new NotSupportedException("Simple object could not cast");
    }
}