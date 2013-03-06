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

//    public abstract String toString();
//
//    public abstract String getName() throws Exception;
//
//    public abstract void setName(String name) throws Exception;
//
//    public abstract SimpleObject getTranspose() throws Exception;
//
//    public abstract double getDeterminant() throws Exception;
//
//    public abstract SimpleObject getInvert() throws Exception;
//
//    public abstract SimpleObject add(SimpleObject b) throws Exception;
//
//    public abstract SimpleObject sub(SimpleObject b) throws Exception;
//
//    public abstract SimpleObject mul(SimpleObject b) throws Exception;
//
//    public abstract SimpleObject power(int c) throws Exception;
//
//    public abstract SimpleObject power(SimpleObject o) throws Exception;
//
//    public abstract void lu(SimpleObject l, SimpleObject u) throws Exception;
//
//    public abstract SimpleObject echelonForm() throws Exception;
//
//    public abstract SimpleObject getRank() throws Exception;
//
//    public abstract SimpleObject getTrace() throws Exception;
//
//    public abstract SimpleObject eigenValues() throws Exception;
//
//    public abstract SimpleObject getIdentity() throws Exception;
//
//    public abstract SimpleObject copy() throws Exception;
//
//    public abstract SimpleObject cast(SimpleObject o) throws Exception;
//
//    public abstract SimpleObject setContent(Integer row, Integer col, double[] content) throws Exception;
//
//    public abstract double getEquivalenceValue() throws Exception;

//    
//    public int intValue() {
//        throw new NotImplementedException();
//    }
//
//    
//    public long longValue() {
//        throw new NotImplementedException();
//    }
//
//    
//    public float floatValue() {
//        throw new NotImplementedException();
//    }
//
//    
//    public double doubleValue() {
//        throw new NotImplementedException();
//
//    }


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


    public SimpleObject getTranspose() throws Exception {
        throw new NotSupportedException("Value does not have transpose");
    }


    public double getDeterminant() throws Exception {
        throw new NotSupportedException("Value does not have determinant");
    }


    public SimpleObject getInvert() throws Exception {
        throw new NotSupportedException("Value does not have invert");
    }


    public SimpleObject add(SimpleObject b) throws Exception {
//       SimpleObject a = cast(b);
        return new SimpleObject(b.value.doubleValue() + this.value.doubleValue());

    }


    public SimpleObject sub(SimpleObject b) throws Exception {

        return new SimpleObject(this.value.doubleValue()-b.value.doubleValue());
    }


    public SimpleObject mul(SimpleObject b) throws Exception {
        return new SimpleObject(b.value.doubleValue() * this.value.doubleValue());
    }


    public SimpleObject power(int c) throws Exception {
        return new SimpleObject(Math.pow(this.value.doubleValue(), c));
    }


    public SimpleObject power(SimpleObject o) throws Exception {

        return power(o.value.intValue());
    }


    public void lu(SimpleObject l, SimpleObject u) throws Exception {
        throw new NotSupportedException("Value does not have lu decomposition");
    }


    public SimpleObject echelonForm() throws Exception {
        throw new NotSupportedException("Value does not have echelon form");
    }


    public SimpleObject getRank() throws Exception {
        throw new NotSupportedException("Value does not have rank");
    }


    public SimpleObject getTrace() throws Exception {
        throw new NotSupportedException("Value does not have trace");
    }


    public SimpleObject eigenValues() throws Exception {
        throw new NotSupportedException("Value does not have Eigen value");
    }


//    public SimpleObject getIdentity() throws Exception {
//        return new SimpleObject(1);
//    }


    public SimpleObject copy() throws Exception {
        return new SimpleObject(name, value);
    }


//    public SimpleObject cast(SimpleObject o) throws Exception {
//        if (o == null)
//            throw new TypeConversionException("Can't convert non value " + o.getName() + " to value");
//
//        return (SimpleObject) o;
//    }


    public SimpleObject setContent(Integer row, Integer col, double[] content) throws Exception {
        throw new NotSupportedException("Can not set values");
    }

    public double getEquivalenceValue() throws Exception {
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
}