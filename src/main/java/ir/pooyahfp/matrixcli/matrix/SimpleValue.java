/*
 * Copyright (c) 2013, Phsys and/or its affiliates. All rights reserved.
 *  Phsys PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package ir.pooyahfp.matrixcli.matrix;

import ir.pooyahfp.matrixcli.exception.NotSupportedException;
import ir.pooyahfp.matrixcli.exception.TypeConversionException;

import java.io.Serializable;

/**
 * A POJO class that contains simple values
 *
 * @author : Pooya husseini
 *         Email : info@pooya-hfp.ir
 *         Date: 3/2/13
 *         Time: 5:59 PM
 */
public class SimpleValue implements MathObject, Serializable, Cloneable {
    private String name;
    private Number value;


    public SimpleValue(String name, Number value) {
        this.name = name;
        this.value = value;
    }

    public SimpleValue(Number value) {
        this("", value);
    }

    public SimpleValue(String name) {
        this(name, null);
    }

    public SimpleValue() {
        this(null, null);
    }

    public String getName() {
        return name;
    }

    @Override
    public MathObject getTranspose() throws Exception {
        throw new NotSupportedException("Values hast not transpose");
    }

    @Override
    public double getDeterminant() throws Exception {
        throw new NotSupportedException("Values hast not determinant");
    }

    @Override
    public MathObject getInvert() throws Exception {
        throw new NotSupportedException("Values hast not invert");
    }

    @Override
    public MathObject add(MathObject b) throws Exception {
        SimpleValue a = cast(b);
        return new SimpleValue(a.value.doubleValue() + this.value.doubleValue());
    }

    @Override
    public MathObject sub(MathObject b) throws Exception {

        return new SimpleValue(this.value.doubleValue() - cast(b).value.doubleValue());
    }

    @Override
    public MathObject mul(MathObject b) throws Exception {
        return new SimpleValue(this.value.doubleValue() * cast(b).value.doubleValue());
    }

    @Override
    public MathObject power(int c) throws Exception {
        return new SimpleValue(Math.pow(this.value.doubleValue(), c));
    }

    @Override
    public void lu(MathObject l, MathObject u) throws Exception {
        throw new NotSupportedException("Values hast not lu decomposition");
    }

    @Override
    public MathObject echelonForm() throws Exception {
        throw new NotSupportedException("Values hast not echelon form");
    }

    @Override
    public int getRank() throws Exception {
        throw new NotSupportedException("Values hast not rank");
    }

    @Override
    public double getTrace() throws Exception {
        throw new NotSupportedException("Values hast not trace");
    }

    @Override
    public MathObject eigenValues() throws Exception {
        throw new NotSupportedException("Values hast not Eigen value");
    }

    @Override
    public MathObject getIdentity() throws Exception {
        return new SimpleValue(1);
    }

    @Override
    public MathObject copy() throws Exception {
        return new SimpleValue(name,value);
    }

    @Override
    public SimpleValue cast(MathObject o) throws Exception {
        if (!(o instanceof SimpleValue))
            throw new TypeConversionException("Can't convert non value " + o.getName() + " to value");

        return (SimpleValue) o;
    }

    @Override
    public Matrix setContent(Integer row, Integer col, double[] content) throws Exception {
        throw new NotSupportedException("Can not set values");
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

    @Override
    public String toString() {
        return "[" + name + "]\n" + value;
    }
}
