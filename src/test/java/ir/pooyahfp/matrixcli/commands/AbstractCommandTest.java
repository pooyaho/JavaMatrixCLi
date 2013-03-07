/*
 * Copyright (c) 2013, Phsys and/or its affiliates. All rights reserved.
 *  Phsys PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package ir.pooyahfp.matrixcli.commands;

import ir.pooyahfp.matrixcli.matrix.MatrixObject;
import ir.pooyahfp.matrixcli.matrix.SimpleObject;
import org.junit.Before;

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
    protected List<String> params = new ArrayList<String>();
    protected List<String> values = new ArrayList<String>();

    public AbstractCommandTest() throws Exception {
        fillMap();
    }

    protected void fillMap() throws Exception {
        dropAll();
        params.clear();
        values.clear();
        SimpleObject m1 = new MatrixObject(3, 3, "a");
        SimpleObject m2 = new MatrixObject(3, 3, "b");
        SimpleObject m3 = new MatrixObject(3, 2, "c");
        SimpleObject o1 = new SimpleObject("d", 3);
        SimpleObject o2 = new SimpleObject("e", 4);
        SimpleObject o3 = new SimpleObject("f", 5);

        createMathObject(
                m1.setContent(null, null, new double[]{1, 2, 3, 4, 5, 6, 7, 8, 9}),
                m2.setContent(null, null, new double[]{9, 8, 7, 6, 5, 4, 3, 2, 1}),
                m3.setContent(null, null, new double[]{9, 8, 7, 6, 5, 4}),

                o1.setContent(null, null, new double[]{1}),
                o2.setContent(null, null, new double[]{67}),
                o3.setContent(null, null, new double[]{69})
        );
    }

    protected void executeWithOperands(String... params) throws Exception {
        Collections.addAll(this.params, params);
        execute(this.params, values);
    }

    protected void executeAndExpectException(String... params) throws Exception {
        Collections.addAll(this.params, params);
        boolean errorRaised = false;

        try {
            execute(this.params, values);
        } catch (Exception x) {
            errorRaised = true;
        }

        if (!errorRaised) {
            throw new Exception("Expected an error!");
        }
    }

    @Before
    public void cleanup() throws Exception {
        fillMap();
    }
}