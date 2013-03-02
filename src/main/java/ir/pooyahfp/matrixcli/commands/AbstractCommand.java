/*
 * Copyright (c) 2013, Phsys and/or its affiliates. All rights reserved.
 *  Phsys PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package ir.pooyahfp.matrixcli.commands;

import ir.pooyahfp.matrixcli.matrix.Matrix;
import ir.pooyahfp.matrixcli.matrix.SimpleValue;
import ir.pooyahfp.matrixcli.exception.DuplicateMatrixException;
import ir.pooyahfp.matrixcli.exception.DuplicateSimpleValueException;
import ir.pooyahfp.matrixcli.exception.MatrixNotFoundException;
import ir.pooyahfp.matrixcli.exception.SimpleValueNotFoundException;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : Pooya husseini
 *         Email : info@pooya-hfp.ir
 *         Date: 1/23/13
 *         Time: 1:59 PM
 */
public abstract class AbstractCommand {


    private static PrintWriter writer;

    public abstract void execute(List<String> params, List<String> values) throws Exception;

    // contains the matrices
    private final static Map<String, Matrix> matrixMap = new HashMap<String, Matrix>();

    // contains the simple values like 1, 2 ,5
    private final static Map<String, SimpleValue> simpleValuesMap = new HashMap<String, SimpleValue>();

    /**
     * Persist the given matrices. it stores them in a map that the key is the matrix name and the value is the
     * matrix object. if the given matrix has already defined, it will raise an exception.
     *
     * @param args The vararg of the matrices
     */
    void persistMatrix(Matrix... args) throws DuplicateMatrixException {
        for (Matrix matrix : args)
            if (!matrixMap.containsKey(matrix.getName()))
                matrixMap.put(matrix.getName(), matrix);
            else {
                throw new DuplicateMatrixException(String.format("Matrix %s already has defined!", matrix.getName()));
            }
    }

    /**
     * Persists the values that user wants, like val a 1, so it creates the 'a' with value of '1'
     *
     * @param args The simple values
     * @throws DuplicateSimpleValueException
     */
    void persistSimpleValue(SimpleValue... args) throws DuplicateSimpleValueException {
        for (SimpleValue arg : args) {
            if (!simpleValuesMap.containsKey(arg.getName()))
                simpleValuesMap.put(arg.getName(), arg);
            else {
                throw new DuplicateSimpleValueException(String.format("Value %s already has defined!",
                        arg.getName()));
            }
        }
    }

    /**
     * Delete the given matrices from the hash map
     *
     * @param args matrices names
     * @throws MatrixNotFoundException
     */
    void deleteMatrix(String... args) throws MatrixNotFoundException {
        for (String matrixName : args) {
            if (!matrixMap.containsKey(matrixName))
                throw new MatrixNotFoundException("Matrix " + matrixName + " not found!");
            else {
                matrixMap.remove(matrixName);
            }
        }
    }

    /**
     * Returns the matrix with given name. if it does not find the matrix throws MatrixNotFoundException
     *
     * @param name The matrix name
     * @return The object of matrix that stored in the map
     * @throws MatrixNotFoundException
     */
    Matrix getMatrix(String name) throws MatrixNotFoundException {
        Matrix matrix = matrixMap.get(name);
        if (matrix == null)
            throw new MatrixNotFoundException("Matrix " + name + " not found!");
        return matrix;
    }

    /**
     * Returns the value with given name. if it does not find the value throws SimpleValueNotFoundException
     *
     * @param name The value name
     * @return The object of value that stored in the map
     * @throws SimpleValueNotFoundException
     */
    SimpleValue getSimpleValue(String name) throws SimpleValueNotFoundException {
        SimpleValue value = simpleValuesMap.get(name);
        if (value == null)
            throw new SimpleValueNotFoundException("Value " + name + " not found!");
        return value;
    }


    /**
     * Checks that the given matrix is putted in the matrix map or not
     * @param name the matrix name
     * @return true if exists and false if not
     */
    boolean hasMatrix(String name) {
        return matrixMap.containsKey(name);
    }

    /**
     * Checks that the given value is putted in the value map or not
     * @param name the value name
     * @return true if exists and false if not
     */
    boolean hasSimpleValue(String name) {
        return simpleValuesMap.containsKey(name);
    }

    List<Matrix> getAllMatrices() {
        List<Matrix> result = new ArrayList<Matrix>();
        for (Matrix matrix : matrixMap.values()) {
            result.add(matrix);
        }
        return result;
    }

    public static void setWriter(PrintWriter writer) {
        AbstractCommand.writer = writer;
    }

    /**
     * Returns the print writer that you can print with it in the defined console
     *
     * @return the writer
     */
    PrintWriter getWriter() {
        return writer;
    }
}