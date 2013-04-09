/*
 * Copyright (c) 2013, Phsys and/or its affiliates. All rights reserved.
 *  Phsys PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package ir.pooyahfp.matrixcli.commands;

import ir.pooyahfp.matrixcli.matrix.MatrixObject;
import ir.pooyahfp.matrixcli.matrix.SimpleObject;
import org.jetbrains.annotations.NotNull;
import org.junit.Before;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author : Pooya husseini
 *         Email : info@pooya-hfp.ir
 *         Date: 3/6/13
 *         Time: 7:40 PM
 */
public abstract class AbstractCommandTest extends AbstractCommand {

    private final List<String> params = new ArrayList<String>();
    private final List<String> values = new ArrayList<String>();

    AbstractCommandTest() {
        fillMap();
        setWriter(new PrintWriter(System.out));
    }

    void fillMap() {
        dropAll();
        params.clear();
        values.clear();
        SimpleObject m1 = new MatrixObject(3, 3, "a");
        SimpleObject m2 = new MatrixObject(3, 3, "b");
        SimpleObject m3 = new MatrixObject(3, 2, "c");
        SimpleObject m4 = new MatrixObject(3, 1, "m");
        SimpleObject m5 = new MatrixObject(3, 1, "x");
        SimpleObject o1 = new SimpleObject("d", 3);
        SimpleObject o2 = new SimpleObject("e", 4);
        SimpleObject o3 = new SimpleObject("f", 5);
        SimpleObject o4 = new SimpleObject("g", 5);

        createMathObject(
                m1.setContent(null, null, new double[]{1, 2, 3, 4, 5, 6, 7, 8, 9}),
                m2.setContent(null, null, new double[]{9, 8, 7, 6, 5, 4, 3, 2, 1}),
                m3.setContent(null, null, new double[]{9, 8, 7, 6, 5, 4}),
                m4.setContent(null, null, new double[]{9, 8, 7}),
                m5.setContent(null, null, new double[]{0, 0, 0}),

                o1.setContent(null, null, new double[]{1}),
                o2.setContent(null, null, new double[]{67}),
                o3.setContent(null, null, new double[]{69}),
                o4.setContent(null, null, new double[]{3})
        );
    }

    void executeWithOperands(String... params) throws InstantiationException, IllegalAccessException {
        this.params.clear();
        this.values.clear();
        Collections.addAll(this.params, params);
        execute(this.params, values);
    }

    void executeWithOperands(String[] params, @NotNull int[] values) throws InstantiationException, IllegalAccessException {
        this.params.clear();
        this.values.clear();
        Collections.addAll(this.params, params);

        fillValues(values);

        execute(this.params, this.values);
    }

    void executeWithOperands(@SuppressWarnings("SameParameterValue") String name, @NotNull int[] values) throws IllegalAccessException, InstantiationException {

        executeWithOperands(new String[]{name}, values);
    }

    void executeWithOperands(@SuppressWarnings("SameParameterValue") String name, String i, String j, @NotNull int[] values) throws IllegalAccessException, InstantiationException {
        executeWithOperands(new String[]{name, i, j}, values);
    }

    void executeAndExpectException(String... params) {
        this.params.clear();
        this.values.clear();
        Collections.addAll(this.params, params);
        boolean errorRaised = false;

        try {
            execute(this.params, values);
        } catch (Exception x) {
            errorRaised = true;
        }

        if (!errorRaised) {
            throw new RuntimeException("Expected an error!");
        }

    }

    void executeAndExpectException(@NotNull int[] values, @SuppressWarnings("SameParameterValue") String... params) {
        this.params.clear();
        this.values.clear();
        Collections.addAll(this.params, params);

        fillValues(values);

        boolean errorRaised = false;

        try {
            execute(this.params, this.values);
        } catch (Exception x) {
            errorRaised = true;
        }

        if (!errorRaised) {
            throw new RuntimeException("Expected an error!");
        }

    }

    private void fillValues(@NotNull int[] values) {
        for (Integer value : values) {
            this.values.add(String.valueOf(value));
        }
    }

    @Before
    public void cleanup() {
        fillMap();
    }

    @Override
    public void execute(List<String> params, List<String> values) throws IllegalAccessException, InstantiationException {
        Command annotation = this.getClass().getAnnotation(Command.class);

        AbstractCommand addCommand = (AbstractCommand) annotation.targetClass().newInstance();
        addCommand.execute(params, values);
    }
}