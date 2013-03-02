/*
 * Copyright (c) 2013, Phsys and/or its affiliates. All rights reserved.
 *  Phsys PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package ir.pooyahfp.matrixcli.matrix;

/**
 * A POJO class that contains simple values
 *
 * @author : Pooya husseini
 *         Email : info@pooya-hfp.ir
 *         Date: 3/2/13
 *         Time: 5:59 PM
 */
public class SimpleValue {
    private String name;
    private Number value;


    public SimpleValue(String name, Number value) {
        this.name = name;
        this.value = value;
    }

    public SimpleValue() {
        this(null, null);
    }

    public String getName() {
        return name;
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
