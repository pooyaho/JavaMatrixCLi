/*
 * Copyright (c) 2013, Phsys and/or its affiliates. All rights reserved.
 *  Phsys PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package ir.pooyahfp.matrix.token;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : Pooya husseini
 *         Email : info@pooya-hfp.ir
 *         Date: 1/23/13
 *         Time: 2:50 PM
 */
public class Token {

    private String command;
    private List<String> params = new ArrayList<String>();
    private List<String> values = new ArrayList<String>();

    public Token() {

    }

    public Token(String command, List<String> params, List<String> values) {
        this.command = command;
        this.params = params;
        this.values = values;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public List<String> getParams() {
        return params;
    }

    public List<String> getValues() {
        return values;
    }

    public void addParam(String param) {
        params.add(param);
    }

    public void addValue(String value) {
        values.add(value);
    }

}