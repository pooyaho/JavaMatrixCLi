/*
 * Copyright (c) 2013, Phsys and/or its affiliates. All rights reserved.
 *  Phsys PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package ir.pooyahfp.matrixcli.tokenizer;

import java.util.ArrayList;
import java.util.List;

/**
 * A POJO class that contains each command and parameters like command name, parameters and values of command
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

    /**
     *
     * @return returns the command name
     */
    public String getCommand() {
        return command;
    }

    /**
     * Sets the command name
     * @param command the command name
     */
    public void setCommand(String command) {
        this.command = command;
    }

    /**
     *
     * @return returns the list of parameters
     */
    public List<String> getParams() {
        return params;
    }

    /**
     *
     * @return list of values
     */
    public List<String> getValues() {
        return values;
    }


    /**
     *
     * @param param Adds parameter to the parameter list
     */
    public void addParam(String param) {
        params.add(param);
    }

    /**
     *
     * @param value Adds a value to the list
     */
    public void addValue(String value) {
        values.add(value);
    }

}