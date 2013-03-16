/*
 * Copyright (c) 2013, Phsys and/or its affiliates. All rights reserved.
 *  Phsys PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package ir.pooyahfp.matrixcli.commands;

import ir.pooyahfp.matrixcli.exception.DuplicateMathObjectException;
import ir.pooyahfp.matrixcli.exception.MathObjectNotFoundException;
import ir.pooyahfp.matrixcli.matrix.SimpleObject;

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

    public abstract void execute(List<String> params, List<String> values) throws IllegalAccessException, InstantiationException;

    // contains the math objects
    private final static Map<String, SimpleObject> mathObjectsMap = new HashMap<String, SimpleObject>();

//    // contains the simple values like 1, 2 ,5
//    private final static Map<String, SimpleValue> simpleValuesMap = new HashMap<String, SimpleValue>();

    /**
     * Updates the given math objects that are in a map that the key is the object name and the value is the
     * object. if the given object not defined earlier, it will raise an exception.
     *
     * @param args The vararg of the objects
     */
    protected void updateMathObject(SimpleObject... args) {
        for (SimpleObject simpleObject : args) {
            if (mathObjectsMap.containsKey(simpleObject.getName())) {
                SimpleObject old = getMathObject(simpleObject.getName());
                if (old.getClass().getSimpleName().equals(simpleObject.getClass().getSimpleName())) {
                    mathObjectsMap.put(simpleObject.getName(), simpleObject);
                } else {
                    throw new IllegalArgumentException("Objects do not have the same types");
                }
            } else {
                throw new MathObjectNotFoundException(String.format("Object %s has not found!",
                        simpleObject.getName()));
            }
        }
    }

    /**
     * Creates the given math objects. if the given object has already defined, it will raise an exception.
     *
     * @param args The vararg of the objects
     */
    protected void createMathObject(SimpleObject... args) {
        for (SimpleObject simpleObject : args) {
            if (!mathObjectsMap.containsKey(simpleObject.getName())) {
                mathObjectsMap.put(simpleObject.getName(), simpleObject);
            } else {
                throw new DuplicateMathObjectException(String.format("Object %s has already defined!",
                        simpleObject.getName()));
            }
        }
    }
//    /**
//     * Persists the values that user wants, like val a 1, so it creates the 'a' with value of '1'
//     *
//     * @param args The simple values
//     * @throws DuplicateSimpleValueException
//     */
//    void persistSimpleValue(SimpleValue... args) throws DuplicateSimpleValueException {
//        for (SimpleValue arg : args) {
//            if (!simpleValuesMap.containsKey(arg.getName()))
//                simpleValuesMap.put(arg.getName(), arg);
//            else {
//                throw new DuplicateSimpleValueException(String.format("Value %s already has defined!",
//                        arg.getName()));
//            }
//        }
//    }

    /**
     * Delete the given objects from the hash map
     *
     * @param args objects names
     * @throws MathObjectNotFoundException
     */
    protected void deleteMathObject(String... args) {
        for (String mathObjectName : args) {
            if (!mathObjectsMap.containsKey(mathObjectName)) {
                throw new MathObjectNotFoundException("Object " + mathObjectName + " not found!");
            } else {
                mathObjectsMap.remove(mathObjectName);
            }
        }
    }

    /**
     * Returns the object with given name. if it does not find the object throws MathObjectNotFoundException
     *
     * @param name The object name
     * @return The object of object that stored in the map
     * @throws MathObjectNotFoundException
     */
    protected SimpleObject getMathObject(String name) {
        SimpleObject simpleObject = mathObjectsMap.get(name);
        if (simpleObject == null) {
            throw new MathObjectNotFoundException("Object " + name + " not found!");
        }
        return simpleObject;
    }

//    /**
//     * Returns the value with given name. if it does not find the value throws SimpleValueNotFoundException
//     *
//     * @param name The value name
//     * @return The object of value that stored in the map
//     * @throws SimpleValueNotFoundException
//     */
//    SimpleValue getSimpleValue(String name) throws SimpleValueNotFoundException {
//        SimpleValue value = simpleValuesMap.get(name);
//        if (value == null)
//            throw new SimpleValueNotFoundException("Value " + name + " not found!");
//        return value;
//    }


    /**
     * Checks that the given object is putted in the object map or not
     *
     * @param name the object name
     * @return true if exists and false if not
     */
    protected boolean hasMathObject(String name) {
        return mathObjectsMap.containsKey(name);
    }

//    /**
//     * Checks that the given value is putted in the value map or not
//     *
//     * @param name the value name
//     * @return true if exists and false if not
//     */
//    boolean hasSimpleValue(String name) {
//        return simpleValuesMap.containsKey(name);
//    }

    /**
     * Returns all defined objects by the user
     *
     * @return A list of objects
     */
    protected List<SimpleObject> getAllObjects() {
        List<SimpleObject> result = new ArrayList<SimpleObject>();
        for (SimpleObject o : mathObjectsMap.values()) {
            result.add(o);
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
    protected PrintWriter getWriter() {
        return writer;
    }

    /**
     * Drops all registered elements
     */
    protected void dropAll() {
        mathObjectsMap.clear();
    }
}