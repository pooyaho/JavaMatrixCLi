/*
 * Copyright (c) 2013, Phsys and/or its affiliates. All rights reserved.
 *  Phsys PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package ir.pooyahfp.matrixcli.matrix;

import ir.pooyahfp.matrixcli.exception.NotSupportedException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

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


    @NotNull
    public SimpleObject getTranspose() {
        throw new NotSupportedException("Value does not have transpose");
    }


    @NotNull
    public SimpleObject getDeterminant() {
        throw new NotSupportedException("Value does not have determinant");
    }


    @NotNull
    public SimpleObject getInvert() {
        throw new NotSupportedException("Value does not have invert");
    }


    @NotNull
    public SimpleObject add(@NotNull SimpleObject b) {
        return new SimpleObject(b.doubleValue() + this.doubleValue());
    }


    @NotNull
    public SimpleObject sub(@NotNull SimpleObject b) {
        return new SimpleObject(this.doubleValue() - b.doubleValue());
    }


    @NotNull
    public SimpleObject mul(@NotNull SimpleObject b) {
        return new SimpleObject(b.doubleValue() * this.doubleValue());
    }


    @NotNull
    public SimpleObject power(int c) {
        return new SimpleObject(Math.pow(this.doubleValue(), c));
    }


    @NotNull
    public SimpleObject power(@NotNull SimpleObject o) {
        return power(o.intValue());
    }


    public void lu(SimpleObject l, SimpleObject u) {
        throw new NotSupportedException("Value does not have lu decomposition");
    }


    @NotNull
    public SimpleObject echelonForm() {
        throw new NotSupportedException("Value does not have echelon form");
    }


    @NotNull
    public SimpleObject getRank() {
        throw new NotSupportedException("Value does not have rank");
    }


    @NotNull
    public SimpleObject getTrace() {
        throw new NotSupportedException("Value does not have trace");
    }


    @NotNull
    public SimpleObject eigenValues() {
        throw new NotSupportedException("Value does not have Eigen value");
    }

    @NotNull
    public SimpleObject copy() {
        return new SimpleObject(name, value);
    }

    @NotNull
    public SimpleObject setContent(Integer row, Integer col, @NotNull double[] content) {
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

    public void setValue(@SuppressWarnings("SameParameterValue") Number value) {
        this.value = value;
    }

    @NotNull
    public String toString() {
        return "[" + name + "]\n" + value;
    }

    @Nullable
    public SimpleObject tryCast(SimpleObject o) {
        throw new NotSupportedException("Simple object could not try to cast");
    }

    @NotNull
    public MatrixObject cast(SimpleObject o) {
        throw new NotSupportedException("Simple object could not cast");
    }
}