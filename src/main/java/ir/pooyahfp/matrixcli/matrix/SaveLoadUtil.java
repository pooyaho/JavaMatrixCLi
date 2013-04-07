/*
 * Copyright (c) 2013, Phsys and/or its affiliates. All rights reserved.
 *  Phsys PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package ir.pooyahfp.matrixcli.matrix;

import ir.pooyahfp.matrixcli.exception.RuntimeClassNotFoundException;
import ir.pooyahfp.matrixcli.exception.RuntimeIOException;

import java.io.*;

/**
 * A class to store and restore the objects, It uses the serialization technology
 *
 * @author : Pooya husseini
 *         Email : info@pooya-hfp.ir
 *         Date: 1/26/13
 *         Time: 11:24 AM
 */
public final class SaveLoadUtil {

    private SaveLoadUtil() {
    }

    /**
     * Read the object from the given file. if file does not exist or it is not convertible to an object,
     * It will throw the exceptions
     *
     * @param path the path of the file that contains the object
     * @return returns the object
     */
    public static Object readObject(String path) {
        try {
            FileInputStream f = new FileInputStream(path);
            ObjectInput s = new ObjectInputStream(f);
            Object o = s.readObject();
            s.close();
            f.close();

            return o;
        } catch (IOException x) {
            throw new RuntimeIOException(x);
        } catch (ClassNotFoundException e) {
            throw new RuntimeClassNotFoundException();
        }
    }

    /**
     * It stores your object in the entered path
     *
     * @param path The given path that you want to save object in it
     * @param o    the given object

     */
    public static void saveObject(String path, Object o) {
        try {
            FileOutputStream f = new FileOutputStream(path);
            ObjectOutput s = new ObjectOutputStream(f);
            s.writeObject(o);
            s.flush();
            s.close();
            f.close();
        } catch (FileNotFoundException e) {
            throw new OperationRuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeIOException(e);
        }
    }

}